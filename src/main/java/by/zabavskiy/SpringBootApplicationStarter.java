package by.zabavskiy;

import by.zabavskiy.config.AmazonConfig;
import by.zabavskiy.config.ApplicationBeans;
import by.zabavskiy.config.WebBeansConfig;
import by.zabavskiy.security.configuration.JwtTokenConfig;
import by.zabavskiy.security.configuration.WebSecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "by.zabavskiy")
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({WebSecurityConfiguration.class, JwtTokenConfig.class, AmazonConfig.class, ApplicationBeans.class, WebBeansConfig.class})
public class SpringBootApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationStarter.class, args);
    }
}
