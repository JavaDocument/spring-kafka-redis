package org.order.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderApi {
    private final StringRedisTemplate redis;
    private final KafkaTemplate<String, String> kafka;

    @GetMapping("/redis")
    public String getOrderWithRedis() {
        redis.opsForValue().set("orderKey", "orderValue");
        return "getOrderWithRedis";
    }

    @GetMapping("/kafka")
    public String getOrderWithKafka() {
        kafka.send("order-topic", "order 가 보낸 이벤트!");
        return "getOrderWithKafka";
    }
}