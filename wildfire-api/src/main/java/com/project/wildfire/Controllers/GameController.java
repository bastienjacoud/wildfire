package com.project.wildfire.Controllers;

import com.project.wildfire.Models.DTO.GameDTO;
import com.project.wildfire.Services.IGameService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Controller for game endpoints
 */
@RestController
@RequestMapping("/api/game")
public class GameController {

    /**
     * Game Service
     */
    @Autowired
    private IGameService gameService;

    /**
     * Object mapper
     */
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Endpoint used to run one iteration of the simulation.
     * @param body Current game iteration
     * @return Response entity that contain next game iteration
     */
    @PostMapping("/run/step")
    public ResponseEntity<?> goNextStep(@RequestBody HashMap<String, GameDTO> body){
        try{
            return new ResponseEntity<>(gameService.goNextStep(body.get("game")), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint used to check if the simulation is finished or not.
     * @param param Current game iteration
     * @return Response entity that contain true if the simulation is ended, otherwise false.
     */
    @GetMapping("/end")
    public ResponseEntity<?> checkEndGame(@RequestParam("game") String param){
        try{
            return new ResponseEntity<>(gameService.checkEndGame(mapper.readValue(param, GameDTO.class)), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
