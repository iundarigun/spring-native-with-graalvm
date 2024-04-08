package br.com.devcave.graalvm.consumer;

import br.com.devcave.graalvm.domain.response.PersonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerService {

  @KafkaListener(topics = "person-topic")
  public void consume(final PersonResponse personResponse) {
    log.info("Consumer from kafka {}", personResponse);
  }
}
