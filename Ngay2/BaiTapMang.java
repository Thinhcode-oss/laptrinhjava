import java.util.Arrays;
import java.util.Scanner;

public class BaiTapMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Sử dụng Scanner tiêu chuẩn [cite: 115]

        // 1. Nhap so luong phan tu N va khoi tao mang ngau nhien
        System.out.print("Nhap so luong phan tu N: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            // Tao so ngau nhien trong khoang tu 0 den 100
            arr[i] = (int) (Math.random() * 100);
        }

        // 2. Xuat toan bo mang [cite: 134, 144]
        System.out.print("\nMang vua tao: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        // 3. Tinh tong mang
        int tong = 0;
        for (int x : arr) tong += x;
        System.out.println("- Tong mang: " + tong);

        // 4. Dem so lan xuat hien cua K
        System.out.print("- Nhap so K can dem: ");
        int k = sc.nextInt();
        int demK = 0;
        for (int x : arr) {
            if (x == k) demK++;
        }
        System.out.println("  => So " + k + " xuat hien " + demK + " lan.");

        // 5 & 6. Tim phan tu lon nhat va nho nhat
        int max = arr[0], min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("- Phan tu lon nhat: " + max);
        System.out.println("- Phan tu nho nhat: " + min);

        // 7. Xuat cac so nguyen to
        System.out.print("- Cac so nguyen to trong mang: ");
        for (int x : arr) {
            if (isNguyenTo(x)) System.out.print(x + " ");
        }
        System.out.println();

        // 8. Sap xep mang tang dan
        Arrays.sort(arr);
        System.out.println("- Mang tang dan: " + Arrays.toString(arr));

        // 9. Sap xep mang giam dan
        System.out.print("- Mang giam dan: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        sc.close(); // Dong Scanner sau khi dung xong [cite: 92]
    }

    // Ham ho tro kiem tra so nguyen to
    public static boolean isNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}