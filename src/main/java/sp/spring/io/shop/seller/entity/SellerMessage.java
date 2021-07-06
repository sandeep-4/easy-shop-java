package sp.spring.io.shop.seller.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerMessage {

	private Map<Integer, ArrayList<SellerMessageDetails>> msgThreadMap;

	public SellerMessage() {

		msgThreadMap = new HashMap<>();
	}
}
