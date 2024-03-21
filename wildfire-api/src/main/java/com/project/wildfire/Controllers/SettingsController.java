package com.project.wildfire.Controllers;

import com.project.wildfire.Models.DTO.GameDTO;
import com.project.wildfire.Services.ISettingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for settings endpoints
 */
@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    /**
     * Settings service
     */
    @Autowired
    private ISettingsService settingsService;

    /**
     * Endpoint used to load settings (initial simulation state).
     * @return Response Entity that contain initial game iteration
     */
    @GetMapping("")
    public ResponseEntity<?> getSettings(){
        try{
            GameDTO game = settingsService.loadGame();
            return new ResponseEntity<>(game, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
