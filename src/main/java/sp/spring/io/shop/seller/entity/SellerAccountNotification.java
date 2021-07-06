package sp.spring.io.shop.seller.entity;

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
public class SellerAccountNotification {

	private int severityLevel;

	private boolean starred;

	private String notificationMsg;

	private String timestamp;
}
