package com.example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 3. Merge & Aggregate Data
 Problem Statement: Given a list of Order objects with fields:

 orderId
 customerId
 amount
 Produce a Map<Long, BigDecimal> where:

 Key = customerId
 Value = total amount spent by that customer
 Constraints:

 Multiple orders may exist for the same customer
 Use Stream API collectors for aggregation
 */
public class MergeAndAggregateCustomerData {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1l,1l,1000.0));
        customers.add(new Customer(2l,2l,1000.0));
        customers.add(new Customer(3l,3l,1000.0));
        customers.add(new Customer(4l,1l,1000.0));
        customers.add(new Customer(5l,2l,1000.0));

        Map<Long,BigDecimal> result = new HashMap<>();

        result = customers.stream()
                .collect(Collectors.groupingBy(
                        Customer::getCustomerId,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                c->BigDecimal.valueOf(c.getAmount()),
                                BigDecimal::add))
                        );
        System.out.println(result);
    }
}

/**
 * Customer
 */
class Customer{
    Long orderId;
    Long customerId;
    Double amount;

    public Customer(Long orderId, Long customerId, Double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
