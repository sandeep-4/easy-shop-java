package sp.spring.io.shop.common.repository.info;

import java.util.HashMap;
import java.util.List;

import org.javatuples.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.dto.SearchSuggestionForThreeAttrDTO;
import sp.spring.io.shop.common.dto.SearchSuggestionForTwoAttrDTO;
import sp.spring.io.shop.common.entity.sql.info.ProductInfo;
import sp.spring.io.shop.common.model.FilterAttributesResponse;
import sp.spring.io.shop.common.model.HomeTabsDataResponse;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

//	Pair<Long, List<ProductInfo>> getProductsByCategories(HashMap<String, String> conditionMap);
//
	List<ProductInfo> getProductsById(String[] productsId);
//
//	FilterAttributesResponse getFilterAttributesByProducts(HashMap<String, String> conditionMap);
//
//	HomeTabsDataResponse getBrandsAndApparelsByGender();

	List<SearchSuggestionForTwoAttrDTO> getGenderAndApparelByIdAndName();

	List<SearchSuggestionForTwoAttrDTO> getGenderAndBrandByIdAndName();

	List<SearchSuggestionForTwoAttrDTO> getApparelAndBrandByIdAndName();

	@Query(value = "SELECT DISTINCT p.name FROM productInfo p")
	List<String> getByProductnName();

}
