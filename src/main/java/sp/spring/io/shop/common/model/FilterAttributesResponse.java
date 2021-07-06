package sp.spring.io.shop.common.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sp.spring.io.shop.common.dto.FilterAttributesWithTotalItemsDTO;
import sp.spring.io.shop.common.entity.sql.categories.SortByCategory;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FilterAttributesResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<FilterAttributesWithTotalItemsDTO> brands;
	private List<FilterAttributesWithTotalItemsDTO> genders;
	private List<FilterAttributesWithTotalItemsDTO> apparels;
	private List<SortByCategory> sortby;
	private List<FilterAttributesWithTotalItemsDTO> prices;

	public FilterAttributesResponse(List<FilterAttributesWithTotalItemsDTO> brands,
			List<FilterAttributesWithTotalItemsDTO> genders, List<FilterAttributesWithTotalItemsDTO> apparels,
			List<FilterAttributesWithTotalItemsDTO> prices) {
		this.brands = brands;
		this.genders = genders;
		this.apparels = apparels;
		 this.prices = prices;
	}

}
