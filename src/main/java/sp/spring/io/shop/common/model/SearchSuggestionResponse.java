package sp.spring.io.shop.common.model;


import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sp.spring.io.shop.common.dto.SearchSuggestionForThreeAttrDTO;
import sp.spring.io.shop.common.dto.SearchSuggestionForTwoAttrDTO;
import sp.spring.io.shop.common.entity.sql.categories.ApparelCategory;
import sp.spring.io.shop.common.entity.sql.categories.GenderCategory;
import sp.spring.io.shop.common.entity.sql.categories.ProductBrandCategory;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SearchSuggestionResponse implements Serializable {
    List<GenderCategory> genderKeywords;
    List<ProductBrandCategory> brandKeywords;
    List<ApparelCategory> apparelKeywords;
    List<SearchSuggestionForTwoAttrDTO> genderApparelKeywords;
    List<SearchSuggestionForTwoAttrDTO> genderBrandKeywords;
    List<SearchSuggestionForTwoAttrDTO> apparelBrandKeywords;
    List<SearchSuggestionForThreeAttrDTO> threeAttrKeywords;
    List<String> productKeywords;
}
