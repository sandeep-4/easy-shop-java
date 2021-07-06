package sp.spring.io.shop.common.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ApparelImagesDTO implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String title;

	private String imageLocalPath;

	private String imageURL;

	private ApparelDTO apparelInfo;

	private GenderDTO genderInfo;

}

@Getter
@Setter
@NoArgsConstructor
@ToString
class ApparelDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
}

@Getter
@Setter
@NoArgsConstructor
@ToString
class GenderDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
}
