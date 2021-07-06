package sp.spring.io.shop.seller.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import sp.spring.io.shop.seller.entity.sql.SellerInfo;

public interface SellerInfoRepository extends JpaRepository<SellerInfo, Integer>{

}
