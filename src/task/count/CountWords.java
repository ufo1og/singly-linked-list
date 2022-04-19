package task.count;

import java.util.*;

/**
 * Подсчет количества повторений слов.
 *
 * Пример:
 * А В АА ВВ А ВВ А
 *
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
        List<String> input = List.of("А", "В", "АА", "ВВ", "А", "ВВ", "А");
        Map<String, Integer> result = countWords(input);
        System.out.println(result);
    }

    private static Map<String, Integer> countWords(List<String> input) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (String value : input) {
            int count = result.getOrDefault(value, 0);
            count++;
            result.put(value, count);
        }
        return result;
    }
}
