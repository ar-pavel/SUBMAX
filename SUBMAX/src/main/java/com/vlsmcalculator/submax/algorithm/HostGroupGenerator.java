package com.vlsmcalculator.submax.algorithm;

public class HostGroupGenerator {

//    vector<int> calculateBroadcast(){
//        vector<int>tempBroadcast(4,255);
//
//        int cidr = this->CIDR;
//        int wildcardMask = 32-cidr;
//
//        for(int idx=3; idx>=0; --idx){
//            tempBroadcast[idx]= this->ip[idx] | ((1<<min(8,wildcardMask))-1) ;
//            wildcardMask = max(0, wildcardMask-min(8,wildcardMask));
//        }
//
//        return tempBroadcast;
//    }
//    vector<int> calculateNetID(){
//        vector<int>tempNetID(4,255);
//        int cidr = this->CIDR;
//
//        for(int idx=0; idx<4; ++idx){
//            tempNetID[idx]= this->ip[idx] & ((1<<min(8,cidr))-1);
//            cidr = max(0, cidr-min(8,cidr));
//        }
//
//        return tempNetID;
//    }
//    long calculateHost(){
//
//        return (1<<(32- this->CIDR))-1;
//    }
}
