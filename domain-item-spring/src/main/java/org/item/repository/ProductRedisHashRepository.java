package org.item.repository;

import org.item.model.redishash.ProductRedisHash;
import org.springframework.data.repository.CrudRepository;

public interface ProductRedisHashRepository extends CrudRepository<ProductRedisHash, Long> {
}
