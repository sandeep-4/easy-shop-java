package sp.spring.io.shop.seller.entity;

import java.util.ArrayList;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class SellerBulkInfo {


	@Id
	private int id;
	private SellerMessage sellerMessage;
    private ArrayList<SellerReview> sellerReview;

    private ArrayList<SellerAccountNotification> sellerAccountNotification;
	
}

