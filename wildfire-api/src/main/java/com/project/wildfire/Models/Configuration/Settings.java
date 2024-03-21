package com.project.wildfire.Models.Configuration;

import com.project.wildfire.Models.Enums.CellStatus;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app.settings")
@Data
public class Settings {
    private int nbCols;
    private Double probability;
    private List<CellStatus> initialState;
}
