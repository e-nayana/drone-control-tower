package org.musalasoft.controlltower.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("serial_number")
    private String serialNumber;

    @NonNull
    private String model;

    @NonNull
    @Max(500)
    @JsonProperty("weight_limit")
    private Integer weightLimit;

    @NonNull
    @Max(100)
    @JsonProperty("battery_capacity")
    private Integer batteryCapacity;

}
