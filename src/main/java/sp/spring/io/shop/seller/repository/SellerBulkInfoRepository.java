package sp.spring.io.shop.seller.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sp.spring.io.shop.seller.entity.SellerBulkInfo;

public interface SellerBulkInfoRepository extends MongoRepository<SellerBulkInfo, Integer>{

}
