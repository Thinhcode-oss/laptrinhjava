public class bai1 {
    /**
     * Phuong thuc kiem tra chuoi doi xung
     * @param s Chuoi can kiem tra
     * @return true neu la chuoi doi xung, nguoc lai la false
     */
    public static boolean Palindrome(String s) {
        // Lay do dai cua chuoi
        int n = s.length();
        
        // Chung ta chi can chay vong lap den giua chuoi (n/2)
        // Vi cac cap ky tu da duoc so sanh doi xung voi nhau.
        for (int i = 0; i < n / 2; i++) {
            // So sanh ky tu tai vi tri i va vi tri doi dien (n - 1 - i)
            // Giong nhu logic M[i] so sanh M[5-1-i] trong hinh anh cua ban
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                // Neu co bat ky cap nao khong bang nhau, tra ve false ngay lap tuc
                return false;
            }
        }
        
        // Neu di het vong lap ma khong thay su khac biet, tra ve true
        return true;
    }

    public static void main(String[] args) {
        // Thu nghiem voi cac vi du trong de bai [cite: 19, 20]
        String str1 = "madam";
        String str2 = "radar";
        String str3 = "hello";

        System.out.println("Chuoi '" + str1 + "' la Palindrome: " + Palindrome(str1));
        System.out.println("Chuoi '" + str2 + "' la Palindrome: " + Palindrome(str2));
        System.out.println("Chuoi '" + str3 + "' la Palindrome: " + Palindrome(str3));
    }
}