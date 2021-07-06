package sp.spring.io.shop.seller.entity.sql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity
public class SellerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int userId;

	private double balance;

	private float rating;

	private String companyName;

	private boolean verificationStatus;

	private int accountType;

	private String lastLoginTime;

	private int totalActiveOrders;

	private int totalCancelledOrders;

	private int totalDeliveredOrders;

	private int totalOrders;

}
