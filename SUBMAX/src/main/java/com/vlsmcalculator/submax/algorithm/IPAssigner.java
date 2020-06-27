package com.vlsmcalculator.submax.algorithm;

import com.vlsmcalculator.submax.model.HostGroupResponse;
import com.vlsmcalculator.submax.model.IP;
import com.vlsmcalculator.submax.playload.Request;
import com.vlsmcalculator.submax.playload.Response;

import java.util.stream.Collectors;

public class IPAssigner {
    public static IP currentIp;

    public static Response AssignIP(Request request) {
        Response response = new Response();
        response.setSourceNetworkAddress(IPUtil.processISPIP(request.getSourceNetworkAddress()));

        currentIp = new IP(request.getSourceNetworkAddress().getAddressValue());

        response.setHostGroup(request.getHostGroup().stream().map(
                hostGroupRequest -> {

                    HostGroupResponse hostGroupResponse = new HostGroupResponse();
                    hostGroupResponse.setId(hostGroupRequest.getId());
                    hostGroupResponse.setName(hostGroupRequest.getName());
                    hostGroupResponse.setSize(hostGroupRequest.getSize());

                    /// Assign IP to this host group
                    hostGroupResponse.setNetworkAddress(new IP(currentIp.getAddressValue(), IPUtil.getCIDR(hostGroupRequest.getSize())));

                    /// Calculate Gateway
                    hostGroupResponse.setGatewayAddress(IPUtil.getGatewayAddress(hostGroupResponse.getNetworkAddress()));

                    // Calculate Broadcast
                    hostGroupResponse.setBroadcast(IPUtil.getBroadcastAddress(hostGroupResponse.getNetworkAddress(),hostGroupRequest.getSize()));

                    // Update Current IP to Next Available NetID
                    currentIp = new IP(currentIp.getAddressValue() + hostGroupRequest.getSize(),
                            IPUtil.getCIDR(hostGroupRequest.getSize()));

                    System.err.println(currentIp);
                    return hostGroupResponse;
                }
        ).collect(Collectors.toList()));

        return response;
    }



}
