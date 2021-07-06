package sp.spring.io.shop.common.repository.images;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.images.ApparelImages;

public interface ApparelImagesRepository extends JpaRepository<ApparelImages, Integer>{

	  @Query(value = "SELECT DISTINCT c FROM ApparelImages c")
	    List<ApparelImages> getAllData();
}
