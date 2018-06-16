package com.agrcom.streamkafka.service;

import com.agrcom.streamkafka.model.Greetings;
import com.agrcom.streamkafka.stream.StreamGreetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class GreetingsService {

   private final StreamGreetings streamGreetings;

    public GreetingsService(StreamGreetings streamGreetings) {
        this.streamGreetings = streamGreetings;
    }

    public void sendGreeting(final Greetings greetings) {

        log.info("Sending greetings {}", greetings);

        MessageChannel messageChannel = streamGreetings.outboundGreetings();

        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    }
}
