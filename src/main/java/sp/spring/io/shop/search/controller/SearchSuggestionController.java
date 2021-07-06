package sp.spring.io.shop.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sp.spring.io.shop.search.dto.SearchSuggestionKeywordInfo;
import sp.spring.io.shop.search.service.SearchSuggestionService;

@RestController
public class SearchSuggestionController {

	@Autowired
	SearchSuggestionService searchSuggestionService;

	@Autowired
	Environment environment;

	public void loadSearchSuggestion() {
		searchSuggestionService.loadSearchSuggestionToMap();
	}

	@GetMapping("/search-suggestion")
	public ResponseEntity<?> searchKeyword(@RequestParam String q) {
		return ResponseEntity.ok(searchSuggestionService.searchKeywordFromMap(q));
	}

	@GetMapping("/default-search-suggestion")
	public ResponseEntity<?> defaultSearchSuggestions() {
		List<SearchSuggestionKeywordInfo> resultList = searchSuggestionService.getDefaultSearchSuggestions();
		return ResponseEntity.ok(resultList);
	}

}
