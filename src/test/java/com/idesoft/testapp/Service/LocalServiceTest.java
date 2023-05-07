package com.idesoft.testapp.Service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalServiceTest {





    @Test
    void testNormalizedString(){
        LocalService localServiceMock = mock(LocalService.class);
        //Given
        String request = "CoM U N a";

        //When
        when(localServiceMock.normalizeString(request)).thenReturn("comuna");
        String result = localServiceMock.normalizeString(request);

        //Then
        assertEquals("comuna", result);
    }
}