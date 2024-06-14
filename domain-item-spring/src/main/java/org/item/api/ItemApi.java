package org.item.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemApi {
    private final StringRedisTemplate redis;

    @GetMapping
    public String getItemWithRedis() {
        redis.opsForValue().set("itemKey", "itemValue");
        return "getItemWithRedis";
    }

    @KafkaListener(topics = "order-topic", groupId = "order-group1")
    public String getItemWithKafka(String event) {
        System.out.println("ItemApi.getItemWithKafka: " + event);
        return "getItemWithKafka";
    }
}