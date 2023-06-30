package C_W.main;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringToSetConverter {
    public static String toString(List<Integer> numbers) {
        /**
         *
         * 1, 2, 3, 4, 5, 6, 7, 8, 9, 0
         * [1][2][3][4][5][6][7][8][9][0]
         *
         *
         **/

        if (numbers == null || numbers.isEmpty()) {
            return null;
        }

        return numbers.stream()
                .map(number -> "[" + number + "]")
                .collect(Collectors.joining());

    }

    public static List<Integer> toSet(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        String[] parts = value.split("]");
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            part.replace("[", "");
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }

}
