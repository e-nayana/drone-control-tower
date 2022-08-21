package org.musalasoft.controlltower.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.musalasoft.controlltower.domain.DroneState;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDroneRq {
    @NonNull
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9-]*$")
    private String serialNumber;

    @NonNull
    private String model;

    @NonNull
    @Max(500)
    private Integer weightLimit;

    @NonNull
    @Max(100)
    private Integer batteryCapacity;

    @NonNull
    private DroneState state;

}
