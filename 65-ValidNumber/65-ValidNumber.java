// Last updated: 22/05/2026, 11:26:00
import java.util.regex.Pattern;
class Solution {
    private static final String NUMBER_REGEX = 
        "^[+-]?((\\d*\\.\\d+)|(\\d+\\.?))(e[+-]?\\d+)?$";

    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX, Pattern.CASE_INSENSITIVE);

    public boolean isNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        return NUMBER_PATTERN.matcher(s.trim()).matches();
    }
}