package sp.spring.io.shop.common.repository.info;

import org.springframework.data.jpa.repository.JpaRepository;

import sp.spring.io.shop.common.entity.sql.info.AddressInfo;

public interface BankInfoRepository extends JpaRepository<AddressInfo, Integer>{

}
