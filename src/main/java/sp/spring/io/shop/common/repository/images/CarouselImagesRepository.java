package sp.spring.io.shop.common.repository.images;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sp.spring.io.shop.common.entity.sql.images.CarouselImages;

public interface CarouselImagesRepository extends JpaRepository<CarouselImages, Integer>{


    @Query(value = "SELECT DISTINCT c FROM CarouselImages c")
    List<CarouselImages> getAllData();
}
