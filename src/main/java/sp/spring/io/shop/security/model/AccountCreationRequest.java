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
public class AccountCreationRequest {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
}
