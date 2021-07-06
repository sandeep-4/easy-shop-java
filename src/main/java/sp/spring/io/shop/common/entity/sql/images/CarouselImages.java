package sp.spring.io.shop.common.entity.sql.images;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class CarouselImages {

	  @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private int id;

	    private String link;

	    private String imageLocalPath;

	    private String imageURL;

	    public CarouselImages(String link, String imageLocalPath, String imageURL) {
	        this.link = link;
	        this.imageLocalPath = imageLocalPath;
	        this.imageURL = imageURL;
	    }
	    
	    
}
