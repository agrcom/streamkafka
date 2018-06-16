package com.agrcom.streamkafka.config;

import com.agrcom.streamkafka.stream.StreamGreetings;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(StreamGreetings.class)
public class StreamsConfig {
}
