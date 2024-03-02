package com.project.wildfire.Controllers;

import com.project.wildfire.Models.DTO.SettingsDTO;
import com.project.wildfire.Services.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private ISettingsService settingsService;

    @GetMapping("")
    public ResponseEntity<?> getSettings(){
        try{
            SettingsDTO settings = settingsService.findFirst();
            return new ResponseEntity<>(settings, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
