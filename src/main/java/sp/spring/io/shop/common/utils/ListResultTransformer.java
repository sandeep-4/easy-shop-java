package sp.spring.io.shop.common.utils;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sp.spring.io.shop.common.dto.FilterAttributesDTO;
import sp.spring.io.shop.common.dto.FilterAttributesWithTotalItemsDTO;
import sp.spring.io.shop.common.dto.SearchSuggestionForThreeAttrDTO;
import sp.spring.io.shop.common.dto.SearchSuggestionForTwoAttrDTO;

public class ListResultTransformer {

	public List<FilterAttributesWithTotalItemsDTO> getFilterAttributesWithTotalItemsResultTransformer(String queryStr,
			HashMap<Integer, Object> mapParams, EntityManager entityManager) {

		Query query = entityManager.createQuery(queryStr);
		if (mapParams != null) {
			mapParams.forEach(query::setParameter);
		}

		return query.unwrap(org.hibernate.query.Query.class).setResultTransformer(
				(IListResultTransformer) (tuples, aliases) -> new FilterAttributesWithTotalItemsDTO((Integer) tuples[0],
						(String) tuples[1], (Long) tuples[2]))
				.getResultList();

	}

	public List<FilterAttributesDTO> getFilterAttributesResultTransformer(String queryStr,
			HashMap<Integer, Object> mapParams, EntityManager entityManager) {

		Query query = entityManager.createQuery(queryStr);

		if (mapParams != null) {
			mapParams.forEach(query::setParameter);
		}

		return query.unwrap(org.hibernate.query.Query.class)
				.setResultTransformer((IListResultTransformer) (tuple,
						aliases) -> new FilterAttributesDTO((Integer) tuple[0], (String) tuple[1]))
				.setMaxResults(10).getResultList();
	}

	public List<SearchSuggestionForThreeAttrDTO> getSearchSuggestionForThreeAttrResultTransformer(String queryStr,
			EntityManager entityManager) {

		Query query = entityManager.createQuery(queryStr);
		return query.unwrap(org.hibernate.query.Query.class)
				.setResultTransformer((IListResultTransformer) (tuple, aliases) -> new SearchSuggestionForThreeAttrDTO(
						(Integer) tuple[0], (String) tuple[1], (Integer) tuple[2], (String) tuple[3],
						(Integer) tuple[4], (String) tuple[5]))
				.getResultList();
	}

	public List<SearchSuggestionForTwoAttrDTO> getSearchSuggestionForTwoAttrResultTransformer(String querStr,
			EntityManager entityManager) {
		Query query = entityManager.createQuery(querStr);
		return query.unwrap(org.hibernate.query.Query.class).setResultTransformer(
				(IListResultTransformer) (tuple, aliases) -> new SearchSuggestionForTwoAttrDTO((Integer) tuple[0],
						(String) tuple[1], (Integer) tuple[2], (String) tuple[3]))
				.getResultList();

	}

}
