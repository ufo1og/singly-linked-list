package task.duplicate;

import java.util.*;

/**
 * Удаление дубликатов.
 *
 * Удалить из строки повторные слова:
 * Пример:
 * А В А АА В ВВ А ВВ
 *
 * Результат:
 * А В АА ВВ
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class DuplicateRemoving {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>(List.of("А", "В", "А", "АА", "В", "ВВ", "А", "ВВ"));
        Collection<String> result = removeDuplicates(input);
        System.out.println(result);

        List<String> input1 = new ArrayList<>(List.of("А", "В", "А", "АА", "В", "ВВ", "А", "ВВ"));
        duplicatesRemoving(input1);
        System.out.println(input1);
    }

    private static Collection<String> removeDuplicates(List<String> input) {
        return new LinkedHashSet<>(input);
    }

    private static void duplicatesRemoving(List<String> input) {
        int i = 0;
        for (Iterator<String> iterator = input.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (s.equals(input.get(j))) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                iterator.remove();
            } else {
                i++;
            }
        }
    }
}
