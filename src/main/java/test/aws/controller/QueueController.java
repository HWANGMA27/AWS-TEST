package test.aws.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.aws.mq.CustomMessage;
import test.aws.mq.RabbitMqService;

@RequiredArgsConstructor
@RestController
public class QueueController {

    private final RabbitMqService rabbitMqService;

    @PostMapping("/send/msg")
    public ResponseEntity<String> sendMessage(
            @RequestBody CustomMessage customMessage
    ) {
        this.rabbitMqService.sendMessage(customMessage);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }
}
