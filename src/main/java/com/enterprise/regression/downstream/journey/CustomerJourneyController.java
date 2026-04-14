package com.enterprise.regression.downstream.journey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/downstream/customers")
public class CustomerJourneyController {
    private final CustomerJourneyService service;

    public CustomerJourneyController(CustomerJourneyService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}/summary")
    public CustomerSummaryResponse summary(@PathVariable String customerId) {
        return service.summary(customerId);
    }

    @GetMapping("/{customerId}/journey")
    public CustomerJourneyResponse journey(@PathVariable String customerId) {
        return service.journey(customerId);
    }
}
