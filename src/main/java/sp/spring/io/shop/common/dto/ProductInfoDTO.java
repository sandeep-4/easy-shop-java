package sp.spring.io.shop.common.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sp.spring.io.shop.common.entity.sql.info.ProductInfo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductInfoDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long totalCount;
    private List<ProductInfo> products;
}