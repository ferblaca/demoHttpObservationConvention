package com.example.demoObservation.controller;

import demo.openapi.PetApi;
import demo.openapi.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("app-rest")
public class AppController {

    @Autowired
    private RestTemplate restClient;
    @Autowired
    private PetApi petApi;

    @GetMapping(path = "/invoke")
    public String invokeRestClient() {
        return restClient.getForObject("http://localhost:8080/app-rest/client-invoked", String.class);
    }

    @GetMapping(path = "/client-invoked")
    public String invokedByClient() {
        return "hello!";
    }

    @GetMapping(path = "/invoke-templatized")
    public String invokeRestClientTemplatized() {
        return restClient.getForObject("http://localhost:8080/app-rest/client-invoked-with-template/{param}", String.class, "world!!");
    }

    @RequestMapping(value = {"/client-invoked-with-template/{param}"}, method = RequestMethod.GET)
    public String invokedByClient(@PathVariable String param) {
        return "hello! " + param;
    }

    @GetMapping(path = "/invoke-api-client-templatized")
    public Pet invokeRestApiClientTemplatized() {
        return petApi.getPet2ById(2L);
    }

    @RequestMapping(value = {"/pet2/{petId}"}, method = RequestMethod.GET)
    public Pet pet(@PathVariable Long petId) {
        Pet pet = new Pet();
        pet.setId(petId);
        return pet;
    }

}
