package sp.spring.io.shop.common.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sp.spring.io.shop.common.dto.BrandsAndApparelsDTO;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HomeTabsDataResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BrandsAndApparelsDTO men;
    private BrandsAndApparelsDTO women;
    private BrandsAndApparelsDTO boys;
    private BrandsAndApparelsDTO girls;
    private BrandsAndApparelsDTO essentials;
    private BrandsAndApparelsDTO homeAndLiving;
}