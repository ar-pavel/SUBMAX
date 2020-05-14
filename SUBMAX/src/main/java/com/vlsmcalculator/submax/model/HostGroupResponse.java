package com.vlsmcalculator.submax.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HostGroupResponse {
    private long id;
    private String name;
    private long size;

    private IP networkAddress;
    private IP gatewayAddress;
    private IP broadcast;

    public String toString(){
        return "{ id: " + id + " : " + name + " need : " + size + " }";
    }
}
