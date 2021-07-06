package sp.spring.io.shop.common.service;

import java.util.HashMap;

import sp.spring.io.shop.common.dto.ProductInfoDTO;
import sp.spring.io.shop.common.entity.sql.info.ProductInfo;
import sp.spring.io.shop.common.model.FilterAttributesResponse;
import sp.spring.io.shop.common.model.HomeTabsDataResponse;
import sp.spring.io.shop.common.model.MainScreenResponse;
import sp.spring.io.shop.common.model.SearchSuggestionResponse;

public interface CommonDataService {

	MainScreenResponse gethomeScreenData(String apiName);

	FilterAttributesResponse getFilterAttributesByPOroducts(String queryParams);

	ProductInfoDTO getProductByCategory(String queryParams);

	HashMap<Integer, ProductInfo> getProductsById(String queryParams);

	HomeTabsDataResponse getBrandsAndApparelsByGender(String apiName);

	SearchSuggestionResponse getSearchSuggestionList();

}
