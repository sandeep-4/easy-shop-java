package sp.spring.io.shop.common.repository.categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.categories.PriceRangeCategory;

public interface PriceRangeCategoryRepository extends JpaRepository<PriceRangeCategory, Integer>{
	   @Query(value = "SELECT p FROM PriceRangeCategory p")
	    List<PriceRangeCategory> getAllData();

	    PriceRangeCategory findByType(String type);
	    
	    
}
