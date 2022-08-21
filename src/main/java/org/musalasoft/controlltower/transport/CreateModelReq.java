package org.musalasoft.controlltower.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelReq {

    @NonNull
    private String name;

    @NotNull
    @JsonProperty("weight_limit")
    private Integer weightLimit;
}
