package com.example.demoObservation.config;

import demo.ApiClient;
import demo.openapi.PetApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppObservationConfiguration {

    //  private static final KeyValue URI_NONE = KeyValue.of(ClientHttpObservationDocumentation.LowCardinalityKeyNames.URI, "none");

    //    @Bean
    //  public ObservationConvention customObservationConvention() {
    //    return new CustomObservationConvention();
    //  }

    //    @Bean
    //  ObservationPredicate disableHttpServerObservationsFromName() {
    //    return (name, context) -> !name.startsWith("http.server.");
    //  }

    //    @Bean
    //  ObservationPredicate disableHttpClientObservationsWithoutUri() {
    //    return (name, context) ->
    //        name.startsWith("http.client.requests") && context.getAllKeyValues().stream().anyMatch(keyValue -> equals(URI_NONE));
    //  }

    @Bean
    public RestTemplate restClient(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public PetApi petApi(RestTemplate restClient,
                         @Value("${server.port}") String port) {
        ApiClient apiClient = new ApiClient(restClient);
        apiClient.setBasePath("http://localhost:" + port + "/app-rest");
        PetApi petApi = new PetApi(apiClient);
        return petApi;
    }

}
