package com.enterprise.regression.downstream.journey;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Component
public class OrderInsightRepository {
    private final Map<String, OrderInsight> orderInsights = Map.of(
            "CUST-1001", new OrderInsight("CUST-1001", 3, "ORD-9001", new BigDecimal("18450.25")),
            "CUST-1002", new OrderInsight("CUST-1002", 1, "ORD-9002", new BigDecimal("6200.00")),
            "CUST-1003", new OrderInsight("CUST-1003", 5, "ORD-9003", new BigDecimal("24800.00"))
    );

    public Optional<OrderInsight> findByCustomerId(String customerId) {
        return Optional.ofNullable(orderInsights.get(customerId));
    }

    public int count() {
        return orderInsights.size();
    }
}
