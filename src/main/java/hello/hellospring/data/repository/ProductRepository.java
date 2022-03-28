package hello.hellospring.data.repository;

import hello.hellospring.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    //jpaRepository를 사용한다는 것으로 다른 코드를 구현 하지 않아도 된다.
}
