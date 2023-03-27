package com.example.demoObservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("app-rest")
public class AppController {

    @Autowired
    private RestTemplate restClient;

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

}
