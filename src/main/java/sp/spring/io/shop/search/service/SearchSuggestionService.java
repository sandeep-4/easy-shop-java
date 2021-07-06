package sp.spring.io.shop.search.service;

import java.util.List;

import sp.spring.io.shop.search.dto.SearchSuggestionKeywordInfo;

public interface SearchSuggestionService {

	void loadSearchSuggestionToMap();

	List<SearchSuggestionKeywordInfo> searchKeywordFromMap(String q);

	List<SearchSuggestionKeywordInfo> getDefaultSearchSuggestions();
}
