package com.idesoft.testapp.Controller;

import com.idesoft.testapp.Dto.LocalResponseDto;
import com.idesoft.testapp.Service.LocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class LocalControllerTest {

    @Mock
    private LocalService localService;

    @InjectMocks
    private LocalController localController;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getAllLocals() {
    }

    @Test
    void testLocalesPorComuna() {
        List<LocalResponseDto> localList = List.of(
                LocalResponseDto.builder()
                        .local_nombre("LA CRUZ")
                        .local_direccion("21 DE MAYO N° 5481")
                        .local_telefono("+56332254902")
                        .build(),
                LocalResponseDto.builder()
                        .local_nombre("SALCOBRAND")
                        .local_direccion("21 DE MAYO 5628, LOCAL 1, LA CRUZ")
                        .local_telefono( "+56332320677")
                        .build(),
                LocalResponseDto.builder()
                        .local_nombre("CONSULTORIO MUNICIPAL DE LA CRUZ")
                        .local_direccion("21 DE MAYO 5010")
                        .local_telefono("+56332310288")
                        .build(),
                LocalResponseDto.builder()
                        .local_nombre("DR. SIMI")
                        .local_direccion("AVENIDA 21 DE MAYO 5426, LOCALES 8 Y 9")
                        .local_telefono("+560")
                        .build()
        );

        //Given
        String comuna = "LA CRUZ";
        when(localService.getLocalsByComuna(comuna)).thenReturn(localList);


        //When
        List<LocalResponseDto> result = localController.getLocalesPorComuna(comuna);

        //Then
        assertEquals(localList, result);
    }
}