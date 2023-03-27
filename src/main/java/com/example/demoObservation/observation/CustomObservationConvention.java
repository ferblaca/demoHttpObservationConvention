package com.example.demoObservation.observation;

import io.micrometer.common.KeyValues;
import io.micrometer.observation.GlobalObservationConvention;
import org.springframework.http.client.observation.ClientRequestObservationContext;
import org.springframework.http.client.observation.DefaultClientRequestObservationConvention;

public class CustomObservationConvention extends DefaultClientRequestObservationConvention implements GlobalObservationConvention<ClientRequestObservationContext> {

    @Override
    public KeyValues getLowCardinalityKeyValues(ClientRequestObservationContext context) {
        return super.getLowCardinalityKeyValues(context);
    }
}
