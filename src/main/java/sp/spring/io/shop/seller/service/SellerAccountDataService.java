package sp.spring.io.shop.seller.service;

import sp.spring.io.shop.seller.entity.SellerBulkInfo;
import sp.spring.io.shop.seller.entity.sql.SellerInfo;

public interface SellerAccountDataService {

	public SellerInfo findSellerById(Integer sellerId);

	public void save();

	public void saveInMongo();

	public SellerBulkInfo findMongoAddressById();
}
