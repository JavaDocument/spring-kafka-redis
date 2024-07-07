package org.item.api;

import lombok.RequiredArgsConstructor;
import org.item.model.common.CommonProduct;
import org.item.service.ProductService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemApi {
    private final StringRedisTemplate redis;
    private final ProductService productService;

    @GetMapping
    public String getItemWithRedis() {
        redis.opsForValue().set("itemKey", "itemValue");
        return "getItemWithRedis";
    }

    @GetMapping("product")
    public ResponseEntity<?> getProduct(@RequestParam(name = "id") Long productId){
        CommonProduct product = productService.findProduct(productId);
        return ResponseEntity.ok().body(product);
    }

    @KafkaListener(topics = "order-topic", groupId = "order-group1")
    public String getItemWithKafka(String event) {
        System.out.println("ItemApi.getItemWithKafka: " + event);
        return "getItemWithKafka";
    }
}