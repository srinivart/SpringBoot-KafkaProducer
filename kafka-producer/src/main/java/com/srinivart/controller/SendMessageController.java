package com.srinivart.controller;

import com.srinivart.message.ProducerMessage;
import com.srinivart.producer.KafkaMessageProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SendMessageController {
    private static final Logger log = LoggerFactory.getLogger(SendMessageController.class);
    private KafkaMessageProducer producer;

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody ProducerMessage message) {
        log.info("Received request message send with body {} ", message);
        producer.send(message);
    }

}
