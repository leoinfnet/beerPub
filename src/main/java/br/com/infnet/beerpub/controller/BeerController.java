package br.com.infnet.beerpub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class BeerController {
    @GetMapping
    public ResponseEntity hello(){
        return ResponseEntity.ok(Map.of("Message", "Getting a Stout for U S2"));
    }

}
