package com.vlsmcalculator.submax.playload;

import com.vlsmcalculator.submax.model.HostGroupResponse;
import com.vlsmcalculator.submax.model.IP;
import lombok.*;

import java.util.List;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Response {
    private IP sourceNetworkAddress;
    private List<HostGroupResponse> hostGroup;

}
