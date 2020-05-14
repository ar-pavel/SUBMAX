package com.vlsmcalculator.submax.algorithm;

import com.vlsmcalculator.submax.model.HostGroupRequest;
import com.vlsmcalculator.submax.model.HostGroupResponse;
import com.vlsmcalculator.submax.model.IP;
import com.vlsmcalculator.submax.playload.Request;
import com.vlsmcalculator.submax.playload.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IPAssigner {
    private static Response response;
    private  static long currentIp;

    public IPAssigner() {
        response = new Response();
    }

    public static Response AssignIP(Request request) {

        response.setSourceNetworkAddress(request.getSourceNetworkAddress());

        currentIp = request.getSourceNetworkAddress().getAddressValue();

        response.setHostGroup(request.getHostGroup().stream().map(
                hostGroupRequest -> {
                    HostGroupResponse hostGroupResponse = new HostGroupResponse();
                    hostGroupResponse.setId(hostGroupRequest.getId());
                    hostGroupResponse.setName(hostGroupRequest.getName());
                    hostGroupResponse.setSize(hostGroupRequest.getSize());

                    /// Assign IP to this host group
                    hostGroupResponse.setNetworkAddress(new IP(currentIp));
                    currentIp += hostGroupRequest.getSize()+1;

                    /// Calculate Gateway
                    hostGroupResponse.setBroadcast(IPUtil.getGatewayAddress(hostGroupResponse.getNetworkAddress()));

                    // Calculate Broadcast
                    hostGroupResponse.setBroadcast(IPUtil.getBroadcastAddress(hostGroupResponse.getNetworkAddress(),hostGroupRequest.getSize()));

                    return hostGroupResponse;
                }
        ).collect(Collectors.toList()));

        return response;
    }



}
