package sp.spring.io.shop.common.utils;

import java.util.List;

import org.hibernate.transform.ResultTransformer;
@FunctionalInterface
public interface IListResultTransformer extends ResultTransformer{

	@Override
	default List transformList(List tuples) {
		return tuples;
	}

	
	
}
