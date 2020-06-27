package com.vlsmcalculator.submax.controller;

import com.vlsmcalculator.submax.playload.Request;
import com.vlsmcalculator.submax.playload.Response;
import com.vlsmcalculator.submax.service.VLSMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class VLSMController {

    private VLSMService vlsmService;

    public VLSMController(VLSMService vlsmService) {
        this.vlsmService = vlsmService;
    }

    @GetMapping("/status")
    public String status(){
        System.err.println("Okay!");
        return "VLSM-Calculator is UP!";
    }

    @GetMapping("/allocate")
    public ResponseEntity<Response> handleRequest(@RequestBody Request request){
        System.err.println(request);
        try {
            Response response = VLSMService.allocate(request);


            // Create a CSV file and generate a Downloadable Link

            return  ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
