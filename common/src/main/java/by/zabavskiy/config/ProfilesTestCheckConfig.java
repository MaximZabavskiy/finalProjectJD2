package by.zabavskiy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("profiletest")
public class ProfilesTestCheckConfig {
    private String profileName;
}
