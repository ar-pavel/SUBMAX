package com.vlsmcalculator.submax.model;

import com.vlsmcalculator.submax.algorithm.MathOperations;
import lombok.*;

@Data @Getter @Setter @NoArgsConstructor
public class HostGroupRequest {
    private long id;
    private String name;
    private long size;

    public HostGroupRequest(long id, String name, long size) {
        this.id = id;
        this.name = name;
        this.size = MathOperations.preferable(size);

    }

    public void setSize(long size) {
        this.size =MathOperations.preferable(size);
    }


    public int compare(HostGroupRequest that) {
        return Long.compare(that.getSize(), this.size);
    }
    public String toString(){
        return "{ id: " + id + " : " + name + " need : " + size + " }";
    }
}
