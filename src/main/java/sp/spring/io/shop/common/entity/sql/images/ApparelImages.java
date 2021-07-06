package sp.spring.io.shop.common.entity.sql.images;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sp.spring.io.shop.common.entity.sql.categories.ApparelCategory;
import sp.spring.io.shop.common.entity.sql.categories.GenderCategory;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class ApparelImages {

	 @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private int id;

	    private String title;

	    private String imageLocalPath;

	    private String imageURL;

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "apparel_id", referencedColumnName = "id")
	    @JsonIgnore
	    private ApparelCategory apparelCategory;

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "gender_id")
	    @JsonIgnore
	    private GenderCategory genderCategory;

	    public ApparelImages(String title, String imageLocalPath, String imageURL) {
	        this.title = title;
	        this.imageLocalPath = imageLocalPath;
	        this.imageURL = imageURL;
	    }
}
