package sp.spring.io.shop.common.repository.info;

import org.springframework.data.jpa.repository.JpaRepository;

import sp.spring.io.shop.common.entity.sql.info.OrderInfo;

public interface OrderInorRepository extends JpaRepository<OrderInfo, Integer>{

}
