package com.workintech.jpa.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;
}
