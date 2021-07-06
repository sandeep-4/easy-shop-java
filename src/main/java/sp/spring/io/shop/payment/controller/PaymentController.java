package sp.spring.io.shop.payment.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;

import sp.spring.io.shop.payment.model.CardToken;
import sp.spring.io.shop.payment.model.PaymentStatus;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PaymentController {

	@Autowired
	Environment env;

	@GetMapping("/test")
	public ResponseEntity<?> testing() {
		return ResponseEntity.ok("testing payment");
	}

	@PostMapping("/payment")
	public ResponseEntity<PaymentStatus> chargeCustomer(@RequestBody CardToken cardToken) {
		Stripe.apiKey = env.getProperty("STRIPE_SECRET_KEY");
		Stripe.setMaxNetworkRetries(2);

		Charge charge;
		PaymentStatus paymentStatus;
		try {

			ChargeCreateParams params = ChargeCreateParams.builder().setAmount(cardToken.getAmount())
					.setCurrency(cardToken.getCurrency()).setDescription("Shop here").setSource(cardToken.getId())
					.build();
			charge = Charge.create(params);
			System.out.println(charge);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			paymentStatus = new PaymentStatus(timestamp.getTime(), false, charge.getId(),
					charge.getBalanceTransaction(), charge.getReceiptUrl());

		} catch (Exception e) {
			paymentStatus = new PaymentStatus();
			paymentStatus.setPayment_failed(true);
			return ResponseEntity.badRequest().body(paymentStatus);
		}
		return ResponseEntity.ok(paymentStatus);
	}

}
