package by.zabavskiy.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.htp.domain.NotBeanByDefault;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.net.http.HttpClient;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Configuration
public class ApplicationBeanConfiguration /*implements LoadTimeWeavingConfigurer*/ {

    @Bean
    @Scope("singleton")
    @Primary
    public NotBeanByDefault notDefaultBean() {
        return new NotBeanByDefault();
    }

    @Bean
    @Scope("singleton")
    //@Primary
    public NotBeanByDefault notDefaultBean1() {
        return new NotBeanByDefault("TestPrimaryAnnotation");
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    //    @Bean
//    public ViewResolver getViewResolver() {
//        return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
//    }
//
//    @Bean
//    public HttpMessageConverter getStringConverter() {
//        return new StringHttpMessageConverter();
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter getMessageConverter() {
//        return new MappingJackson2HttpMessageConverter();
//    }

    //This bean can be created by @EnableAspectJAutoProxy
//    @Bean("logAspect")
//    public LogAspect getLogAspect() {
//        return new LogAspect();
//    }
//
//    @Override
//    public LoadTimeWeaver getLoadTimeWeaver() {
//        return new ReflectiveLoadTimeWeaver();
//    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        // Fix Postgres JPA Error:
        // Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        // Package contain entity classes
        factoryBean.setPackagesToScan("com.htp");
        factoryBean.setDataSource(dataSource);
        factoryBean.setAnnotatedPackages("com.htp");
        factoryBean.setHibernateProperties(getAdditionalProperties());
        factoryBean.afterPropertiesSet();
        //
        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }

    //Entity Manager

    @Autowired
    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.htp");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }
//
//    @Bean
//    public JpaTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        return new JpaTransactionManager(sessionFactory);
//    }

    private Properties getAdditionalProperties() {
        Properties properties = new Properties();

        // See: application.properties
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.connection.characterEncoding", "utf8mb4");
        properties.put("hibernate.connection.CharSet", "utf8mb4");
        properties.put("hibernate.connection.useUnicode", "true");
        properties.put("current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        properties.put("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.put("hibernate.cache.use_second_level_cache", "true");
        properties.put("hibernate.cache.use_query_cache", "true");
        return properties;
    }

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager usersAdmins = new CaffeineCacheManager("usersAdmins");
        usersAdmins.setCaffeine(cacheProperties());
        return usersAdmins;
    }

    public Caffeine<Object, Object> cacheProperties() {
        return Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(50)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .weakKeys()
                .recordStats();
    }
}
