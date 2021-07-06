package sp.spring.io.shop.seller.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp.spring.io.shop.seller.entity.SellerAccountNotification;
import sp.spring.io.shop.seller.entity.SellerBulkInfo;
import sp.spring.io.shop.seller.entity.SellerMessage;
import sp.spring.io.shop.seller.entity.SellerMessageDetails;
import sp.spring.io.shop.seller.entity.SellerReview;
import sp.spring.io.shop.seller.entity.sql.SellerInfo;
import sp.spring.io.shop.seller.repository.SellerBulkInfoRepository;
import sp.spring.io.shop.seller.repository.sql.SellerInfoRepository;

@Service
public class SellerAccountDataServiceImpl implements SellerAccountDataService {

	@Autowired
	private SellerInfoRepository sellerInfoRepository;

	@Autowired
	private SellerBulkInfoRepository sellerBulkInforepository;

	@Override
	public SellerInfo findSellerById(Integer sellerId) {
		Optional<SellerInfo> result = sellerInfoRepository.findById(sellerId);
		SellerInfo sellerInfo = null;
		if (result.isPresent()) {
			sellerInfo = result.get();
		} else {
			throw new RuntimeException("invalid id");
		}
		return sellerInfo;
	}

	@Override
	public void save() {

	}

	public void createSellerAccount(SellerInfo sellerInfo) {
		sellerInfoRepository.save(sellerInfo);
	}

	@Override
	public void saveInMongo() {
		SellerReview sellerReview = new SellerReview(4.5, "Its really good!!", "2020-01-01 10:10:10");

		SellerAccountNotification sellerAccountNotification = new SellerAccountNotification(0, false,
				"Your product #32425 is delivered", "2020-01-01 10:10:10");

		SellerMessageDetails sellerMessageDetails = new SellerMessageDetails(1, 1, "This is message body",
				"This is message subject", "John Miller", "2020-01-01 10:10:10", true);
		SellerMessage sellerMessage = new SellerMessage();

		sellerMessage.getMsgThreadMap().put(1,
				new ArrayList<SellerMessageDetails>(Arrays.asList(sellerMessageDetails)));
		SellerBulkInfo sellerBulkInfo = new SellerBulkInfo(324, sellerMessage,
				new ArrayList<SellerReview>(Arrays.asList(sellerReview)),
				new ArrayList<SellerAccountNotification>(Arrays.asList(sellerAccountNotification)));

		sellerBulkInforepository.save(sellerBulkInfo);
	}

	@Override
	public SellerBulkInfo findMongoAddressById() {
		Optional<SellerBulkInfo> result = sellerBulkInforepository.findById(322);
		SellerBulkInfo sellerBulkInfo = null;
		if (result.isPresent()) {
			sellerBulkInfo = result.get();
		} else {
			throw new RuntimeException("No any ids");
		}
		return sellerBulkInfo;
	}

}
