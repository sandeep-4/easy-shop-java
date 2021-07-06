package sp.spring.io.shop.common.repository.categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.categories.SortByCategory;

public interface SortByCategoryRepository extends JpaRepository<SortByCategory, Integer> {

	@Query(value = "SELECT s FROM SortByCategory s")
	List<SortByCategory> getAllData();

	SortByCategory findByType(String type);
	
	
}
