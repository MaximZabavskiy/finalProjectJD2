package by.zabavskiy;

import by.zabavskiy.config.ApplicationBeanConfiguration;
import by.zabavskiy.config.SwaggerConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"by.zabavskiy"})
@EnableCaching
@Import({
        ApplicationBeanConfiguration.class,
        //DatasourceConfiguration.class,
        SwaggerConfigBean.class
})
public class SpringBootStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApplication.class, args);
    }
}
