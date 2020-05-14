package com.vlsmcalculator.submax.service;

import com.vlsmcalculator.submax.algorithm.IPAssigner;
import com.vlsmcalculator.submax.playload.Request;
import com.vlsmcalculator.submax.playload.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VLSMService {

    public static Response allocate(Request request){
        return IPAssigner.AssignIP(request);
    }
}
