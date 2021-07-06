package sp.spring.io.shop.common.controller;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sp.spring.io.shop.common.dto.ProductInfoDTO;
import sp.spring.io.shop.common.entity.sql.info.ProductInfo;
import sp.spring.io.shop.common.model.FilterAttributesResponse;
import sp.spring.io.shop.common.model.HomeTabsDataResponse;
import sp.spring.io.shop.common.model.MainScreenResponse;
import sp.spring.io.shop.common.model.SearchSuggestionResponse;
import sp.spring.io.shop.common.service.CommonDataService;
import sp.spring.io.shop.common.service.LoadFakeDataService;

@RestController
public class CommonDataController {

	@Autowired
	Environment environment;

	@Autowired
	private CommonDataService commonDataService;

	@Autowired
	LoadFakeDataService loadFakeDataService;

	public void fillWithRestData() {
		if (Objects.equals(environment.getProperty("ACTIVE_PROFILE"), "dev")) {
			loadFakeDataService.loadTestData();
		}
	}

	@GetMapping(value = "/products", params = "q")
	public ResponseEntity<?> getProductsByCategories(@RequestParam("q") String queryParams) {
		ProductInfoDTO productinfoDTO = commonDataService.getProductByCategory(queryParams);
		if (productinfoDTO != null) {
			return ResponseEntity.badRequest().body("Invalid query");
		}
		return ResponseEntity.ok(productinfoDTO);
	}

	@GetMapping(value = "/products", params = "product_id")
	public ResponseEntity<?> getProductsById(@RequestParam("product_id") String queryParams) {
		HashMap<Integer, ProductInfo> resultMap = commonDataService.getProductsById(queryParams);
		if (resultMap == null) {
			return ResponseEntity.badRequest().body("Invalid query");
		}
		return ResponseEntity.ok(resultMap);
	}

	@GetMapping("/home")
	public ResponseEntity<?> getMainScreenData() {
		MainScreenResponse mainScreenInfoList = commonDataService.gethomeScreenData("homeAPI");
		if (mainScreenInfoList == null) {
			return new ResponseEntity<Error>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(mainScreenInfoList);
	}

	@GetMapping("/tabs")
	public ResponseEntity<?> getHomeTabsDataResponse() {
		HomeTabsDataResponse homeTabsDataResponse = commonDataService.getBrandsAndApparelsByGender("tabsAPI");
		if (homeTabsDataResponse == null) {
			return new ResponseEntity<Error>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(homeTabsDataResponse);
	}

	@GetMapping(value = "/filter", params = "q")
	public ResponseEntity<?> getFilterAttributesByProducts(@RequestParam("q") String queryParams) {
		String[] splitParams = queryParams.split("=");
		if (splitParams.length >= 1 && splitParams[0].equals("productname")) {
			queryParams = "category=all";
		}
		FilterAttributesResponse result = commonDataService.getFilterAttributesByPOroducts(queryParams);
		if (result == null) {
			return ResponseEntity.badRequest().body("Invalid query");
		}
		return ResponseEntity.ok(result);

	}

	@GetMapping("/search-suggestion-list")
	public ResponseEntity<?> getSearchSuggestionList() {
		SearchSuggestionResponse searchSuggestionList = commonDataService.getSearchSuggestionList();
		if (searchSuggestionList == null) {
			return new ResponseEntity<Error>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(searchSuggestionList);
	}

}
