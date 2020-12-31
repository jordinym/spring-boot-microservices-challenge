package com.jordinymontanez.challenge.customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@Builder
public class CustomerDto {
    @Positive(message = "El id debe ser mayor que cero")
    private int id;
    @NotEmpty(message = "Ingrese Nombres")
    private String name;

    @NotEmpty(message = "Ingrese Apellidos")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Ingrese Fecha Nacimiento")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Positive(message = "La edad debe ser mayor que cero")
    private int age;
}
