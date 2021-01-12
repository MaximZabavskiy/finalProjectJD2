package by.zabavskiy;

import by.zabavskiy.config.AmazonConfig;
import by.zabavskiy.config.ApplicationBeans;
import by.zabavskiy.config.PersistenceContextBeansConfiguration;
import by.zabavskiy.security.configuration.JwtTokenConfig;
import by.zabavskiy.security.configuration.WebSecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "by.zabavskiy")
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching
@Import({
        WebSecurityConfiguration.class,
        JwtTokenConfig.class,
        AmazonConfig.class,
        ApplicationBeans.class,
        PersistenceContextBeansConfiguration.class})
public class SpringBootApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationStarter.class, args);
    }
}
