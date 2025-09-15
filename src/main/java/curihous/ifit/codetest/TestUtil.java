package curihous.ifit.codetest;

import java.util.List;

public class TestUtil {
    
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
    
    public static String formatString(String input) {
        if (isEmpty(input)) {
            return "";
        }
        return input.trim().toLowerCase();
    }
    
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }
    
    public static boolean isValidIndex(List<?> list, int index) {
        return list != null && index >= 0 && index < list.size();
    }
}
