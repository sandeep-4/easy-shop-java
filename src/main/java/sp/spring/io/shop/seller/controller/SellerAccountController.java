package sp.spring.io.shop.seller.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sp.spring.io.shop.seller.entity.SellerBulkInfo;
import sp.spring.io.shop.seller.entity.sql.SellerInfo;
import sp.spring.io.shop.seller.service.SellerAccountDataService;

@RestController
public class SellerAccountController {

	@Autowired
	private SellerAccountDataService sellerAccountDataService;
	
	@GetMapping("/save")
	public void saveAddress() {
		sellerAccountDataService.save();
	}
	
	@GetMapping("/seller/{id}")
	public SellerInfo getAddress(@PathVariable int id) {
		return sellerAccountDataService.findSellerById(id);
	}
	
	@GetMapping("/seller-bulk/{id}")
	public SellerBulkInfo getAdress() {
		sellerAccountDataService.saveInMongo();
		return sellerAccountDataService.findMongoAddressById();
	}
	
	
	
	
}
