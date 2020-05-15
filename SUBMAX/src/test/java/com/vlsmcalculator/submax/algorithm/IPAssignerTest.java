package com.vlsmcalculator.submax.algorithm;

import com.vlsmcalculator.submax.exception.NotEnoughSpace;
import com.vlsmcalculator.submax.model.HostGroupRequest;
import com.vlsmcalculator.submax.model.IP;
import com.vlsmcalculator.submax.playload.Request;
import com.vlsmcalculator.submax.playload.Response;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
class IPAssignerTest {
    public static Request request;

    public IPAssignerTest() {
    }

    @BeforeAll
    static void beforeAll() {
        /*
        {
        "sourceNetworkAddress": {
            "addressValue": 3422552332,
            "addressNotation": "204.0.1.12/16",
            "cidr": 16
        },
        "hostGroupRequestList": [
            {
                "id": 1,
                "name": "My Home",
                "size": 5
            },
            {
                "id": 2,
                "name": "My Office",
                "size": 15
            },
            {
                "id": 3,
                "name": "My Garage",
                "size": 23
            },
            {
                "id": 4,
                "name": "My Rooftop",
                "size": 3
            }
        ]
        }

         */

        IP sourceAddress = new IP(3422552332L,"204.0.1.12/16",16);

        System.out.println(sourceAddress);

        HostGroupRequest hostGroupRequest1 = new HostGroupRequest(1,"My Home",5);
        HostGroupRequest hostGroupRequest2 = new HostGroupRequest(2,"My Office",15);
        HostGroupRequest hostGroupRequest3 = new HostGroupRequest(3,"My Garage",23);
        HostGroupRequest hostGroupRequest4 = new HostGroupRequest(4,"My Rooftop",3);

        request = new Request(sourceAddress, Arrays.asList(hostGroupRequest1,hostGroupRequest2,hostGroupRequest3,hostGroupRequest4));
    }

    @Test
    void DataValidation() {
        System.out.println(request);
    }

    @Test
    void IPAssign() throws NotEnoughSpace {
        System.out.println(request);
        Response response = IPAssigner.AssignIP(request);
        System.out.println(response);
    }
}
