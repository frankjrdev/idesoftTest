package com.idesoft.testapp.Service;


import com.idesoft.testapp.Dto.LocalDto;
import com.idesoft.testapp.Dto.LocalResponseDto;
import jakarta.annotation.PostConstruct;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocalService {

    private List<LocalDto> locals;

    @PostConstruct
    public void init() throws IOException, JSONException {
        String url = "https://farmanet.minsal.cl/index.php/ws/getLocales";
        Document doc = Jsoup.connect(url).get();
        String body = doc.body().text();
        JSONArray jsonArray = new JSONArray(body);
        List<LocalDto> localsResponse = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject local = jsonArray.getJSONObject(i);
            LocalDto localDto = new LocalDto();
            localDto.setFecha(local.getString("fecha"));
            localDto.setLocal_id(local.getString("local_id"));
            localDto.setLocal_nombre(local.getString("local_nombre"));
            localDto.setComuna_nombre(local.getString("comuna_nombre"));
            localDto.setLocalidad_nombre(local.getString("localidad_nombre"));
            localDto.setLocal_direccion(local.getString("local_direccion"));
            localDto.setFuncionamiento_hora_apertura(local.getString("funcionamiento_hora_apertura"));
            localDto.setFuncionamiento_hora_cierre(local.getString("funcionamiento_hora_cierre"));
            localDto.setLocal_telefono(local.getString("local_telefono"));
            localDto.setLocal_lat(local.getString("local_lat"));
            localDto.setLocal_lng(local.getString("local_lng"));
            localDto.setFuncionamiento_dia(local.getString("funcionamiento_dia"));
            localDto.setFk_region(local.getString("fk_region"));
            localDto.setFk_comuna(local.getString("fk_comuna"));
            localDto.setFk_localidad(local.getString("fk_localidad"));
            localsResponse.add(localDto);
        }
        this.locals = localsResponse;
    }

    public List<LocalDto> getLocals() {
        return locals;
    }


    public List<LocalResponseDto> getLocalsByComuna(String comuna) {
        List<LocalDto> locals = getLocals();
        String comunaLowercase = normalizeString(comuna);

        return locals.stream()
                .filter(local -> normalizeString(local.getComuna_nombre()).equals(comunaLowercase))
                .map(local -> LocalResponseDto.builder()
                        .local_nombre(local.getLocal_nombre())
                        .local_direccion(local.getLocal_direccion())
                        .local_telefono(local.getLocal_telefono())
                        .build())
                .toList();

    }

    public String normalizeString(String str) {
        return str.toLowerCase().replaceAll("\\s+", "");
    }
}
