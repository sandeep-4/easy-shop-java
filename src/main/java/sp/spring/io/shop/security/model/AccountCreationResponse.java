package sp.spring.io.shop.security.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreationResponse {

	private String account_creation_status;
	private String error_msg;
}
