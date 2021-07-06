package sp.spring.io.shop.payment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentStatus {

	private long order_id;
	private boolean payment_failed;
	private String charge_id;
	private String txn_id;
	private String receipt_url;

	public PaymentStatus(Long order_id, boolean payment_failed, String charge_id, String txn_id, String receipt_url) {
		this.order_id = order_id;
		this.payment_failed = payment_failed;
		this.charge_id = charge_id;
		this.txn_id = txn_id;
		this.receipt_url = receipt_url;
	}
}
