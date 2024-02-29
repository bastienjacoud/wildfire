package com.project.wildfire.Models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.settings")
@Data
public class Settings {
    private Integer length;
    private Integer height;
    private Double probability;
}
