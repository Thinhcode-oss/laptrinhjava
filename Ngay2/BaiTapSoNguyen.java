import java.util.Scanner;

public class BaiTapSoNguyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Nhap so nguyen duong N
        int n;
        do {
            System.out.print("Nhap vao so nguyen duong N: ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("Vui long nhap so > 0!");
        } while (n <= 0);

        System.out.println("--- KET QUA ---");

        // 2. Kiem tra N co phai so nguyen to khong
        if (isPrime(n)) {
            System.out.println(n + " la so nguyen to.");
        } else {
            System.out.println(n + " khong phai la so nguyen to.");
        }

        // 3. Xuat cac so nguyen to nho hon N
        System.out.print("Cac so nguyen to nho hon " + n + ": ");
        boolean coSNT = false;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                coSNT = true;
            }
        }
        System.out.println(coSNT ? "" : "Khong co");

        // 4. Tinh tong cac so le <= N
        int tongLe = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                tongLe += i;
            }
        }
        System.out.println("Tong cac so le nho hon hoac bang " + n + " la: " + tongLe);
        
        sc.close();
    }

    /**
     * Ham ho tro kiem tra so nguyen to
     * Tra ve true neu n la so nguyen to, nguoc lai tra ve false
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}