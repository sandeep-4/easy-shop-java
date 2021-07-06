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
public class SearchSuggestionForThreeAttrDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer attr1_id;
    String attr1_type;
    Integer attr2_id;
    String attr2_type;
    Integer attr3_id;
    String attr3_type;
}

