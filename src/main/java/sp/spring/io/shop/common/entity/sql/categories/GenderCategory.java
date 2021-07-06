package sp.spring.io.shop.common.entity.sql.categories;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sp.spring.io.shop.common.entity.sql.images.ApparelImages;
import sp.spring.io.shop.common.entity.sql.info.ProductInfo;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class GenderCategory implements Serializable {
    @Id
    private int id;

    private String type;

    @OneToMany(mappedBy = "genderCategory")
    @JsonIgnore
    private List<ProductInfo> productInfos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "genderCategory")
    @JsonIgnore
    private List<ApparelImages> apparelImages;

    public GenderCategory(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
