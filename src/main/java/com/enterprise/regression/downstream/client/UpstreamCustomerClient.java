package com.enterprise.regression.downstream.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "upstreamCustomerClient", url = "${upstream.base-url:http://localhost:8091}")
public interface UpstreamCustomerClient {
    @GetMapping("/api/upstream/customers/{customerId}")
    UpstreamCustomerResponse getCustomer(@PathVariable("customerId") String customerId);

    @GetMapping("/api/upstream/ops/status")
    Map<String, Object> status();

    default boolean isAvailable() {
        Object status = status().get("status");
        return "UP".equals(String.valueOf(status));
    }
}
