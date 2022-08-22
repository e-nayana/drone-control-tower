package org.musalasoft.controlltower.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationDTO {
    private String name;
    private String code;
    private Integer weight;
    private String imageUrl;
}
