import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiTapChuoi {
    public static void negativeNumberInStrings(String str) {
        // Regex tìm dấu trừ đứng trước các chữ số
        Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(str);
        
        System.out.print("Các số nguyên âm trong chuỗi: ");
        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }
        if (!found) System.out.print("Không tìm thấy số âm nào.");
        System.out.println();
    }

    public static void main(String[] args) {
        String input = "abc-5xyz-12k9l--p";
        negativeNumberInStrings(input); // Kết quả: -5 và -12
    }
}