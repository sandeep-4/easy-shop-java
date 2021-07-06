package sp.spring.io.shop.common.repository.categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.categories.ApparelCategory;

public interface ApparelCategoryRepository extends JpaRepository<ApparelCategory, Integer> {

	@Query(value="SELECT c FROM ApparelImages c WHERE c.apparelCategory.type=?1 AND c.genderCategory.type=?2")
	ApparelCategory findByclothesTypeAndGender(String cloathesType, String gender);

	@Query(value = "SELECT c FROM ApparelCategory c")
	List<ApparelCategory> getAllData();

	ApparelCategory findByType(String title);
}
