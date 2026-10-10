package com.BinarySeint.vsRabbit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Service;

@Service 
public class RabbitAdminService {

    private static final Logger log = LoggerFactory.getLogger(RabbitAdminService.class);
    private final AmqpAdmin amqpAdmin;

    // Inyección de dependencias por constructor
    public RabbitAdminService(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    public void createQueue(String queueName) {
        Queue queue = new Queue(queueName, true);
        amqpAdmin.declareQueue(queue);
        log.info("✅ Cola creada exitosamente en el broker: {}", queueName);
    }

    public void deleteQueue(String queueName) {
        amqpAdmin.deleteQueue(queueName);
        log.info("🗑️ Cola eliminada del broker: {}", queueName);
    }
}
