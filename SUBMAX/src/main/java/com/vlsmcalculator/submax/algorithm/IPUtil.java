package com.vlsmcalculator.submax.algorithm;

import com.vlsmcalculator.submax.model.IP;

public class IPUtil {

    public static IP processISPIP(IP ip){
        // TO DO preprocess and calculate decimal value

        return ip;
    }

    // This function was written by @TanvirSojal
    public static String getIPNotation(long address, int cidr){
        StringBuilder ip = new StringBuilder();
        // mask one octet (8-bit) at a time
        long mask = 255L << 24; // 11111111 00000000 00000000 00000000

        for (int i = 3; i >= 0; i--){
            long octet = (address & mask) >> (i * 8);
            if (i < 3) ip.append(".");
            ip.append(octet);
            mask >>= 8;
        }

        if (cidr != 0)
            ip.append("/").append(cidr);
        return ip.toString();
    }

    public static IP getGatewayAddress(IP networkAddress){
        return new IP(networkAddress.getAddressValue()+1, networkAddress.getCidr());
    }

    public static IP getBroadcastAddress(IP networkAddress, long groupSize){
        return new IP(networkAddress.getAddressValue() + groupSize - 1, networkAddress.getCidr());
    }

    public static int getCIDR(long address){
        int cidr = 1;
        while(true){
            if (((address >>> cidr) & 1) != 0) {
                break;
            }
            ++cidr;
        }
        System.err.println(address + "\t" + cidr);
        return  32-cidr;
    }

    //     From broadcast
//    public static int getCIDR(long address){
//        int cidr = 31;
//        while (((address >>> cidr) & 1) != 0) {
//            --cidr;
//        }
//        System.err.println(address + "\t" + cidr);
//        return  cidr;
//    }


}


