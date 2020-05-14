package com.vlsmcalculator.submax.controller;

import com.vlsmcalculator.submax.playload.Request;
import com.vlsmcalculator.submax.playload.Response;
import com.vlsmcalculator.submax.service.VLSMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@RequestMapping("/api/v1")

public class VLSMController {

    private VLSMService vlsmService;

    public VLSMController(VLSMService vlsmService) {
        this.vlsmService = vlsmService;
    }

    @GetMapping("/status")
    public String status(){
        return "VLSM-Calculator is UP!";
    }

    @GetMapping("/calculate")
    public ResponseEntity<Response> handleRequest(@RequestBody Request request){
        try {
            Response response = VLSMService.allocate(request);

            // Create a CSV file and generate a Downloadable Link

            return  ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
//            e.printStackTrace();
        }
    }

}
