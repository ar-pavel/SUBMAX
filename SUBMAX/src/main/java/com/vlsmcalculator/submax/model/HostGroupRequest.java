package com.vlsmcalculator.submax.model;

import lombok.*;

@Data @Getter @Setter
public class HostGroupRequest {
    private long id;
    private String name;
    private long size;

    public HostGroupRequest() {
        this.size = 3L;
    }

    public HostGroupRequest(long id, String name, long size) {
        this.id = id;
        this.name = name;
        this.size = Math.max(3L, (long) Math.pow(2,Math.ceil(Math.log(size))));

    }

    public void setSize(long size) {
        this.size = Math.max(3L, (long) Math.pow(2,Math.ceil(Math.log(size))));
    }


    public int compare(HostGroupRequest that) {
        return Long.compare(that.getSize(), this.size);
    }
    public String toString(){
        return "{ id: " + id + " : " + name + " need : " + size + " }";
    }
}
