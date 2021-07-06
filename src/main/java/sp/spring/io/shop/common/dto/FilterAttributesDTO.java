package sp.spring.io.shop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterAttributesDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
    String value;
}

