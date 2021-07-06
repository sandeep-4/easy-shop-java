package sp.spring.io.shop.common.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sp.spring.io.shop.common.dto.ApparelImagesDTO;
import sp.spring.io.shop.common.dto.BrandImagesDTO;
import sp.spring.io.shop.common.entity.sql.images.CarouselImages;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MainScreenResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BrandImagesDTO> brands;
    private List<ApparelImagesDTO> apparels;
    private List<CarouselImages> carousels;

    public MainScreenResponse(List<BrandImagesDTO> brands,
                              List<ApparelImagesDTO> apparels,
                              List<CarouselImages> carousels) {
        this.brands = brands;
        this.apparels = apparels;
        this.carousels = carousels;
    }
}
