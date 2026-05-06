import java.util.Scanner;

public class BaiTapSoNguyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Nhập số nguyên dương N
        int n;
        do {
            System.out.print("Nhập vào số nguyên dương N: ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("Vui lòng nhập số > 0!");
        } while (n <= 0);

        System.out.println("--- KẾT QUẢ ---");

        // 2. Kiểm tra N có phải số nguyên tố không
        if (isPrime(n)) {
            System.out.println(n + " là số nguyên tố.");
        } else {
            System.out.println(n + " không phải là số nguyên tố.");
        }

        // 3. Xuất các số nguyên tố nhỏ hơn N
        System.out.print("Các số nguyên tố nhỏ hơn " + n + ": ");
        boolean coSNT = false;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                coSNT = true;
            }
        }
        System.out.println(coSNT ? "" : "Không có");

        // 4. Tính tổng các số lẻ <= N
        int tongLe = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                tongLe += i;
            }
        }
        System.out.println("Tổng các số lẻ nhỏ hơn hoặc bằng " + n + " là: " + tongLe);
        
        sc.close();
    }

    /**
     * Hàm hỗ trợ kiểm tra số nguyên tố
     * Trả về true nếu n là số nguyên tố, ngược lại trả về false
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}