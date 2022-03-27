package hello.hellospring.data.dao;

import hello.hellospring.data.entity.ProductEntity;

public interface ProductDAO {
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
