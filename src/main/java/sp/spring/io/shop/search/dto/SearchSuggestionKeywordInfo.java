package sp.spring.io.shop.search.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchSuggestionKeywordInfo {

	String keyword;
	StringBuilder link;
	Integer rank;

	public SearchSuggestionKeywordInfo(String keyword, StringBuilder link, Integer rank) {
		super();
		this.keyword = keyword;
		this.link = link;
		this.rank = rank;
	}

}
