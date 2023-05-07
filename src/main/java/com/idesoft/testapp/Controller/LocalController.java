package com.idesoft.testapp.Controller;

import com.idesoft.testapp.Dto.LocalDto;
import com.idesoft.testapp.Dto.LocalResponseDto;
import com.idesoft.testapp.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/idesoft/v1")
public class LocalController {

    @Autowired
    LocalService localService;


    @GetMapping
    public List<LocalDto> getAllLocals(){
        return localService.getLocals();
    }

    @GetMapping("/locales/{comuna}")
    public List<LocalResponseDto> getLocalesPorComuna(@PathVariable String comuna){
        return localService.getLocalsByComuna(comuna);
    }
}
