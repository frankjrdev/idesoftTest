package com.idesoft.testapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalResponseDto {
    private String local_nombre;
    private String local_direccion;
    private String local_telefono;

}
