package sp.spring.io.shop.common.dto;



import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BrandImagesDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

    private String imageLocalPath;

    private String imageURL;

    private BrandCategoryDTO brandInfo;

}

@Getter
@Setter
@NoArgsConstructor
@ToString
class BrandCategoryDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
}

