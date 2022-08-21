package org.musalasoft.controlltower.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO {
    private String name;
    private Integer weightLimit;
}
