package com.BinarySeint.vsRabbit.dto;

import jakarta.validation.constraints.NotBlank;

public class QueueRequestDTO {

    @NotBlank(message = "El nombre de la cola no puede estar vacío ni ser nulo")
    private String queueName;

    // Constructores, Getters y Setters
    public QueueRequestDTO() {}

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
