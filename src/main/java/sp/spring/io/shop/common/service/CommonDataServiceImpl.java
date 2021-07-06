package sp.spring.io.shop.common.service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.javatuples.Pair;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import sp.spring.io.shop.common.dto.ApparelImagesDTO;
import sp.spring.io.shop.common.dto.BrandImagesDTO;
import sp.spring.io.shop.common.dto.ProductInfoDTO;
import sp.spring.io.shop.common.entity.sql.images.ApparelImages;
import sp.spring.io.shop.common.entity.sql.images.BrandImages;
import sp.spring.io.shop.common.entity.sql.images.CarouselImages;
import sp.spring.io.shop.common.entity.sql.info.ProductInfo;
import sp.spring.io.shop.common.model.FilterAttributesResponse;
import sp.spring.io.shop.common.model.HomeTabsDataResponse;
import sp.spring.io.shop.common.model.MainScreenResponse;
import sp.spring.io.shop.common.model.SearchSuggestionResponse;
import sp.spring.io.shop.common.repository.categories.ApparelCategoryRepository;
import sp.spring.io.shop.common.repository.categories.GenderCategoryRepository;
import sp.spring.io.shop.common.repository.categories.ProductBrandCategoryRepository;
import sp.spring.io.shop.common.repository.categories.SortByCategoryRepository;
import sp.spring.io.shop.common.repository.images.ApparelImagesRepository;
import sp.spring.io.shop.common.repository.images.BrandImagesRepository;
import sp.spring.io.shop.common.repository.images.CarouselImagesRepository;
import sp.spring.io.shop.common.repository.info.ProductInfoRepository;
import sp.spring.io.shop.common.repository.info.ProductInfoRepositoryImpl;

import org.modelmapper.TypeToken;

@Service
public class CommonDataServiceImpl implements CommonDataService {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Autowired
	private ProductInfoRepositoryImpl productInfoRepoImpl;
	
	@Autowired
	private GenderCategoryRepository genderCategoryRepository;

	@Autowired
	private ApparelCategoryRepository apparelCategoryRepository;

	@Autowired
	private ProductBrandCategoryRepository productBrandCategoryRepository;

	@Autowired
	private BrandImagesRepository brandImagesRepository;

	@Autowired
	private ApparelImagesRepository apparelImagesRepository;

	@Autowired
	private CarouselImagesRepository carouselImagesRepository;

	@Autowired
	private SortByCategoryRepository sortByCategoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	HashMap<String, String> getConditionMapFromQuery(String querParams) {
		querParams = querParams.concat("::");
		String[] seperaredConditions = querParams.split("::");

		if (seperaredConditions.length > 0) {
			HashMap<String, String> conditionMap = new HashMap<>();
			for (String condition : seperaredConditions) {
				String[] categories = condition.split("=");
				if (categories.length > 1) {
					conditionMap.put(categories[0], categories[1]);
				}
			}
			return conditionMap;
		}
		return null;
	}

	@Override
	@Cacheable(key = "#apiName", value = "mainScreenResponse")
	public MainScreenResponse gethomeScreenData(String apiName) {
		List<BrandImages> brandList = brandImagesRepository.getAllData();
		Type listType = new TypeToken<List<BrandImages>>() {
		}.getType();
		List<BrandImagesDTO> brandDTOList = modelMapper.map(brandList, listType);
		List<ApparelImages> apparelList = apparelImagesRepository.getAllData();
		listType = new TypeToken<List<ApparelImages>>() {
		}.getType();
		List<ApparelImagesDTO> apparelDTOList = modelMapper.map(apparelList, listType);

		List<CarouselImages> carouselList = carouselImagesRepository.getAllData();

		return new MainScreenResponse(brandDTOList, apparelDTOList, carouselList);
	}

	@Override
	@Cacheable(key = "#queryParams", value = "filterAttributesResponse")
	public FilterAttributesResponse getFilterAttributesByPOroducts(String queryParams) {
		HashMap<String, String> conditionMap = getConditionMapFromQuery(queryParams);

		if (conditionMap != null && !conditionMap.isEmpty()) {
			FilterAttributesResponse filterAttributesResponse = productInfoRepoImpl
					.getFilterAttributesByProducts(conditionMap);
			filterAttributesResponse.setSortby(sortByCategoryRepository.getAllData());
			return filterAttributesResponse;
		}
		return null;
	}

	@Override
	@Cacheable(key = "#queryParams", value = "productInfoDTO")
	public ProductInfoDTO getProductByCategory(String queryParams) {
		HashMap<String, String> conditionMap = getConditionMapFromQuery(queryParams);
		ProductInfoDTO productInfoDTO = null;
		if (conditionMap != null && !conditionMap.isEmpty()) {
			Pair<Long, List<ProductInfo>> result = productInfoRepoImpl.getProductsByCategories(conditionMap);
			if (result != null) {
				productInfoDTO = new ProductInfoDTO(result.getValue0(), result.getValue1());
			}
		}
		return productInfoDTO;
	}

	@Override
	@Cacheable(key = "#queryParams", value = "hashMap")
	public HashMap<Integer, ProductInfo> getProductsById(String queryParams) {
		String[] productIds = queryParams.split(",");
		HashMap<Integer, ProductInfo> resultMap = null;
		if (productIds.length > 0) {
			List<ProductInfo> result = productInfoRepoImpl.getProductsById(productIds);
			if (result != null) {
				resultMap = new HashMap<>();
				for (ProductInfo info : result) {
					resultMap.put(info.getId(), info);
				}
			}
		}
		return resultMap;
	}

	@Override
	@Cacheable(key = "#apiName", value = "homeTabsDataResponse")
	public HomeTabsDataResponse getBrandsAndApparelsByGender(String apiName) {
		return productInfoRepoImpl.getBrandsAndApparelsByGender();
	}

	@Override
	public SearchSuggestionResponse getSearchSuggestionList() {
		return new SearchSuggestionResponse(genderCategoryRepository.getAllData(),
				productBrandCategoryRepository.getAllData(), apparelCategoryRepository.getAllData(),
				productInfoRepository.getGenderAndApparelByIdAndName(),
				productInfoRepository.getApparelAndBrandByIdAndName(),
				productInfoRepository.getApparelAndBrandByIdAndName(),
				productInfoRepoImpl.getGenderApparelBrandByIdAndName(), productInfoRepository.getByProductnName());
	}

}
