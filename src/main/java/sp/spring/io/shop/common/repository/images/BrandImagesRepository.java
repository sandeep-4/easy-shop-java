package sp.spring.io.shop.common.repository.images;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.images.BrandImages;

public interface BrandImagesRepository extends JpaRepository<BrandImages, Integer> {

	@Query(value = "SELECT DISTINCT b FROM BrandImages b")
	List<BrandImages> getAllData();
}
