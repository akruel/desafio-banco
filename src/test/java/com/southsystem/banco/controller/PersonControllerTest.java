package com.southsystem.banco.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    JSONObject personJsonObject = new JSONObject();
    HttpHeaders headers = new HttpHeaders();

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testPhysicalSucessPost() throws Exception {
        createPersonJsonObj("PF", "Teste PF", "86281690087");
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "/person", request, String.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testLegalSucessPost() throws Exception {
        createPersonJsonObj("PJ", "Teste PJ", "00771194000129");
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "/person", request, String.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testPostNameException() throws Exception {
        createPersonJsonObj("PF", "", "70433960000");
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "/person", request, String.class);
        JSONObject responseJsonObject = createResponseJsonObj("Dados inválidos", "Nome não pode ser vazio");
        JSONAssert.assertEquals(response.getBody(), responseJsonObject, JSONCompareMode.LENIENT);
    }

    @Test
    public void testPostInvalidCpfException() throws Exception {
        createPersonJsonObj("PF", "Teste Invalid CPF", "70433960001");
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "/person", request, String.class);
        JSONObject responseJsonObject = createResponseJsonObj("Dados inválidos", "CPF inválido");
        JSONAssert.assertEquals(response.getBody(), responseJsonObject, JSONCompareMode.LENIENT);
    }

    @Test
    public void testPostInvalidCnpjException() throws Exception {
        createPersonJsonObj("PJ", "Teste Invalid CNPJ", "00771194000121");
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "/person", request, String.class);
        JSONObject responseJsonObject = createResponseJsonObj("Dados inválidos", "CNPJ inválido");
        JSONAssert.assertEquals(response.getBody(), responseJsonObject, JSONCompareMode.LENIENT);
    }

    void createPersonJsonObj(String type, String name, String document) throws Exception {
        this.base = new URL("http://localhost:" + port + "/api/bank/v1/");
        personJsonObject.put("type", type);
        personJsonObject.put("name", name);
        if(type == "PF"){
            personJsonObject.put("cpf", document);
        }
        if(type == "PJ"){
            personJsonObject.put("cnpj", document);
        }
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    JSONObject createResponseJsonObj(String message, String strDetails) throws Exception {
        JSONObject responseJsonObject = new JSONObject();
        JSONArray details = new JSONArray();
        details.put(strDetails);
        responseJsonObject.put("message", message);
        responseJsonObject.put("details", details);
        return responseJsonObject;
    }
}