package uno.zeron.one.LibraryV2.common.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j // Provides a 'log' variable for professional logging
public class KafkaProducerService {

    // The 'Megaphone'.
    // String is the Key type (usually an ID)
    // Object is the Value type (the actual data/DTO)
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEvent(String topic, String key, Object data) {
        log.info("Sending message to topic: {} with key: {}", topic, key);

        // This is an asynchronous call. Spring handles the heavy lifting.
        kafkaTemplate.send(topic, key, data);
    }
}