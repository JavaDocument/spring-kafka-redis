package org.item.model.redishash;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.item.model.common.CommonProduct;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("product")
@NoArgsConstructor
@Getter
@Setter
public class ProductRedisHash implements CommonProduct {
    @Id
    private Long id;

    private String name;

    private Long price;

    @Builder
    public ProductRedisHash(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
