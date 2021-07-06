package sp.spring.io.shop.common.repository.categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.categories.ProductBrandCategory;

public interface ProductBrandCategoryRepository extends JpaRepository<ProductBrandCategory, Integer> {

	@Query(value = "SELECT p FROM ProductBrandCtegory p")
	List<ProductBrandCategory> getAllData();

	ProductBrandCategory findByType(String brandName);
}
