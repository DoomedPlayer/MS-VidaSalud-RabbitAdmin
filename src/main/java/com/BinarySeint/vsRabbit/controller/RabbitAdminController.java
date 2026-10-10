package com.BinarySeint.vsRabbit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BinarySeint.vsRabbit.dto.QueueRequestDTO;
import com.BinarySeint.vsRabbit.service.RabbitAdminService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/rabbitmq/queues")
public class RabbitAdminController {

    private final RabbitAdminService adminService;

    public RabbitAdminController(RabbitAdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<String> createQueue(@Valid @RequestBody QueueRequestDTO request) {
        adminService.createQueue(request.getQueueName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cola declarada exitosamente: " + request.getQueueName());
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteQueue(@PathVariable("name") String name) {
        adminService.deleteQueue(name);
        return ResponseEntity.ok("Cola eliminada exitosamente: " + name);
    }
}
