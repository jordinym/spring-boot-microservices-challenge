package com.jordinymontanez.challenge.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerKpiDto {
    private double average;
    private double standardDeviation;
}
