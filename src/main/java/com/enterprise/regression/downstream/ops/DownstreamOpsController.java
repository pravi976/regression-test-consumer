package com.enterprise.regression.downstream.ops;

import com.enterprise.regression.downstream.client.UpstreamCustomerClient;
import com.enterprise.regression.downstream.journey.CustomerJourneyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/downstream/ops")
public class DownstreamOpsController {
    private final UpstreamCustomerClient upstreamCustomerClient;
    private final CustomerJourneyService customerJourneyService;

    public DownstreamOpsController(
            UpstreamCustomerClient upstreamCustomerClient,
            CustomerJourneyService customerJourneyService
    ) {
        this.upstreamCustomerClient = upstreamCustomerClient;
        this.customerJourneyService = customerJourneyService;
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        return Map.of(
                "service", "regression-test-consumer",
                "status", "UP",
                "upstreamAvailable", upstreamCustomerClient.isAvailable(),
                "customerJourneysLoaded", customerJourneyService.totalCustomers(),
                "resilienceMode", "STANDARD"
        );
    }
}
