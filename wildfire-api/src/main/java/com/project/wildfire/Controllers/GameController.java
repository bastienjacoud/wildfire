package com.project.wildfire.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.wildfire.Models.DTO.GameDTO;
import com.project.wildfire.Services.IGameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private IGameService gameService;

    private ObjectMapper mapper = new ObjectMapper();


    @PostMapping("/run/step")
    public ResponseEntity<?> goNextStep(@RequestBody HashMap<String, GameDTO> body){
        try{
            return new ResponseEntity<>(gameService.goNextStep(body.get("game")), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/end")
    public ResponseEntity<?> checkEndGame(@RequestParam("game") String param){
        try{
            return new ResponseEntity<>(gameService.checkEndGame(mapper.readValue(param, GameDTO.class)), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
