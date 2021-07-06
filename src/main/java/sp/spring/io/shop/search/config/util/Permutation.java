package sp.spring.io.shop.search.config.util;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Permutation {

	private List<String> output;

	public Permutation(String[] input) {
		if (input.length == 0) {
			return;
		}
		output = new LinkedList<>();
		permute(input, 0, input.length - 1);
	}

	public void permute(String[] input, int l, int r) {
		if (l == r) {
			output.add(String.join(" ", input));
		} else {
			for (int i = l; i <= r; i++) {
				input = swap(input, l, i);
				permute(input, l + 1, r);
				input = swap(input, l, i);
			}
		}
	}

	public String[] swap(String[] stringArr, int i, int j) {
		String temp = stringArr[i];
		stringArr[i] = stringArr[j];
		stringArr[j] = temp;
		return stringArr;
	}

}
