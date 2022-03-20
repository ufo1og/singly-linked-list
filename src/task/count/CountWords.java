package task.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Подсчет количества повторений слов.
 * <p>
 * Пример:
 * А В АА ВВ А ВВ А
 * <p>
 * Результат:
 * А - 3
 * В - 1
 * АА - 1
 * ВВ - 2
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class CountWords {
	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("A");
		input.add("B");
		input.add("AA");
		input.add("BB");
		input.add("A");
		input.add("BB");
		input.add("A");

		Map<String, Integer> output = countWord(input);

		System.out.println(output);
	}

	// алгоритмическая O (n)
	// память О (n)
	private static Map<String, Integer> countWord(List<String> input) {
		final Map<String, Integer> map = new LinkedHashMap<>();
		for (String value : input) {
			int count = map.getOrDefault(value, 0);
			count++;
			map.put(value, count);
		}
		return map;
	}

}
