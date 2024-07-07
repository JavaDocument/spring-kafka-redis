package org.item.service;

import lombok.RequiredArgsConstructor;
import org.item.model.common.CommonProduct;
import org.item.model.entity.Product;
import org.item.model.redishash.ProductRedisHash;
import org.item.repository.ProductRedisHashRepository;
import org.item.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRedisHashRepository productRedisHashRepository;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public CommonProduct findProduct(Long productId) {
        Optional<ProductRedisHash> byId = productRedisHashRepository.findById(productId);
        if(byId.isPresent()){
            return byId.get();
        }
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("해당상품은 존재하지않습니다"));

        ProductRedisHash productRedisHash = ProductRedisHash
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();

        productRedisHashRepository.save(productRedisHash);
        return product;
    }
}
