package com.vlsmcalculator.submax.model;

import com.vlsmcalculator.submax.algorithm.IPUtil;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class IP {
    protected long addressValue;
    protected String addressNotation;
    protected int cidr;

    public IP(long addressValue){
        this.addressValue = addressValue;
        this.cidr = 0;
        this.addressNotation = IPUtil.getIPNotation(this.addressValue, this.cidr);
    }

    public IP(long addressValue, int cidr){
        this.addressValue = addressValue;
        this.cidr = cidr;
        this.addressNotation = IPUtil.getIPNotation(this.addressValue, this.cidr);
    }

    public String toString(){
        return getAddressNotation();
    }

//    {
//        "addressValue": 3422552332,
//        "addressNotation": "204.0.1.12/16",
//        "cidr": 16
//    }

}
