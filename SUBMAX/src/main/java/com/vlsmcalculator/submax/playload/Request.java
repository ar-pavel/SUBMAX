package com.vlsmcalculator.submax.playload;

import com.vlsmcalculator.submax.model.HostGroupRequest;
import com.vlsmcalculator.submax.model.IP;
import lombok.*;

import java.util.List;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Request {
    private IP sourceNetworkAddress;
    private List<HostGroupRequest> hostGroup;
}
