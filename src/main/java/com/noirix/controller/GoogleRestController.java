package com.noirix.controller;

import com.noirix.config.GoogleConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/googleInfo")
@RequiredArgsConstructor
public class GoogleRestController {

    @Autowired
    public final GoogleConfig googleConfig;

    @GetMapping
    public ResponseEntity<GoogleConfig> getGoogleInfo() {

        return new ResponseEntity<>(googleConfig, HttpStatus.OK);
    }

}
