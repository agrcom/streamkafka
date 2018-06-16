package com.agrcom.streamkafka.service;

import com.agrcom.streamkafka.model.Greetings;
import com.agrcom.streamkafka.stream.StreamGreetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsListener {

    @StreamListener(StreamGreetings.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {

        log.info("Received greetings: {}", greetings);

    }
}
