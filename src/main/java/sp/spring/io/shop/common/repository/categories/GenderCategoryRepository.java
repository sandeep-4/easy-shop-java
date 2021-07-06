package sp.spring.io.shop.common.repository.categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.categories.GenderCategory;

public interface GenderCategoryRepository extends JpaRepository<GenderCategory, Integer> {

	@Query(value = "SELECT g FROM GenderCategory g")
	List<GenderCategory> getAllData();

	GenderCategory findByType(String gender);
}
