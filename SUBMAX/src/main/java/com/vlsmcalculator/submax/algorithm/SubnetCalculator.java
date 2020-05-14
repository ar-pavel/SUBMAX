//package com.vlsmcalculator.submax.algorithm;
//
//import com.vlsmcalculator.submax.exception.NotEnoughSpace;
//import com.vlsmcalculator.submax.model.HostGroupRequest;
//import com.vlsmcalculator.submax.model.HostGroupResponse;
//import com.vlsmcalculator.submax.model.IP;
//
//import java.util.List;
//
//public class SubnetCalculator {
//    public static List<HostGroupResponse> allocate(HostGroupRequest request) throws NotEnoughSpace {
//
//        IP nextAvailableNetworkAddress = request.getSourceNetworkAddress();
//
//        List<HostGroupRequest> hostGroupRequestList = request.getHostGroupRequestList();
////        hostGroupRequestList.sort(HostGroupRequest::compare);
//
//        List<HostGroup> hostGroupList = new ArrayList<>();
//        for (HostGroupRequest hostGroupRequest : hostGroupRequestList){
//            hostGroupRequest.setSize(hostGroupRequest.getSize() + 2);
//            System.out.println(hostGroupRequest.toString());
//            HostGroup hostGroup = allocateHostGroup(nextAvailableNetworkAddress, hostGroupRequest);
//            System.out.println(hostGroup.getNetworkAddress());
//            hostGroupList.add(hostGroup);
//            nextAvailableNetworkAddress = new IP(hostGroup.getBroadcastAddress().getAddressValue()+1, hostGroup.getBroadcastAddress().getCidr());
//        }
//        hostGroupList.sort(HostGroup::compare);
//        return hostGroupList;
//    }
//
//    private static int bitsRequired(long hosts){
//        long p2 = 2;
//        int bits = 1;
//        while(p2 < hosts){
//            p2 *= 2;
//            bits++;
//        }
//        return bits;
//    }
//
//    private static HostGroup allocateHostGroup(IP networkAddress, HostGroupRequest host) throws NotEnoughSpace {
//        int hostBits = bitsRequired(host.getSize());
//        long netId = networkAddress.getAddressValue();
//        int cidr = networkAddress.getCidr();
//
//        System.out.println("Bits needed: " + hostBits);
//        if (32 - cidr < hostBits){
//            throw new NotEnoughSpace("Not enough IP Space!");
//        }
//
//        int newCidr = 32 - hostBits;
//        IP newNetworkAddress = new IP(netId, newCidr);
//        long totalHosts = 1L << hostBits;
//        return new HostGroup(host.getId(), host.getName(), newNetworkAddress, totalHosts);
//    }}
