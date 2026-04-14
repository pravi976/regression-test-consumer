package com.enterprise.regression.downstream.journey;

import com.enterprise.regression.downstream.client.UpstreamCustomerClient;
import com.enterprise.regression.downstream.client.UpstreamCustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerJourneyService {
    private final UpstreamCustomerClient upstreamCustomerClient;
    private final OrderInsightRepository repository;

    public CustomerJourneyService(UpstreamCustomerClient upstreamCustomerClient, OrderInsightRepository repository) {
        this.upstreamCustomerClient = upstreamCustomerClient;
        this.repository = repository;
    }

    public CustomerSummaryResponse summary(String customerId) {
        UpstreamCustomerResponse upstream = upstreamCustomerClient.getCustomer(customerId);
        OrderInsight insight = repository.findByCustomerId(customerId)
                .orElseThrow(() -> new IllegalArgumentException("No order insight for customer " + customerId));
        return new CustomerSummaryResponse(
                upstream.customerId(),
                upstream.customerName(),
                upstream.tier(),
                insight.activeOrders(),
                insight.lastOrderId(),
                insight.totalOrderValue(),
                upstream.currency(),
                upstream.status()
        );
    }

    public CustomerJourneyResponse journey(String customerId) {
        UpstreamCustomerResponse upstream = upstreamCustomerClient.getCustomer(customerId);
        OrderInsight insight = repository.findByCustomerId(customerId)
                .orElseThrow(() -> new IllegalArgumentException("No order insight for customer " + customerId));
        String recommendedAction = insight.activeOrders() >= 3 ? "PRIORITY_REVIEW" : "STANDARD_FOLLOWUP";
        return new CustomerJourneyResponse(
                upstream.customerId(),
                upstream.customerName(),
                upstream.city(),
                upstream.tier(),
                insight.activeOrders(),
                insight.lastOrderId(),
                recommendedAction,
                "READY"
        );
    }

    public int totalCustomers() {
        return repository.count();
    }
}
