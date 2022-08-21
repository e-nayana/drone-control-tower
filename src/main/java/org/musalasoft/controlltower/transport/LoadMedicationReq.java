package org.musalasoft.controlltower.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadMedicationReq {

    @NonNull
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$")
    private String name;

    @NotNull
    @Max(500)
    private Integer weight;

    @NotNull
    @Pattern(regexp = "^[A-Z0-9_]*$")
    private Integer code;

    private String imageUrl;
}
