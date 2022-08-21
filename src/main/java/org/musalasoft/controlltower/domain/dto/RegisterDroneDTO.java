package org.musalasoft.controlltower.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.musalasoft.controlltower.domain.service.state.engine.State;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDroneDTO {
    private String serialNumber;
    private String model;
    private Integer weightLimit;
    private Integer batteryCapacity;
}
