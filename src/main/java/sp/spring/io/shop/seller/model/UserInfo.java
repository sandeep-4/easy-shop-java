package sp.spring.io.shop.seller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class UserInfo {

	private int id;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	private String email;
}
