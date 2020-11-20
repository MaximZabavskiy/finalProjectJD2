package com.noirix.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("google.users.russians")

public class GoogleConfig {

    private String name;

    private String surname;

    private Long age;
}


