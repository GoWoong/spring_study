package hello.hellospring.data.repository;

import hello.hellospring.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
