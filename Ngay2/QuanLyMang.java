import java.util.Arrays;
import java.util.Scanner;

public class QuanLyMang {
    static int[] arr;
    static int n;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n MENU QUAN LY MANG");
            System.out.println("1. Nhap mang (Ngau nhien 0-100)");
            System.out.println("2. Xuat mang");
            System.out.println("3. Tinh tong mang");
            System.out.println("4. Dem so lan xuat hien cua K");
            System.out.println("5. Tim Max - 6. Tim Min");
            System.out.println("7. Xuat cac so nguyen to");
            System.out.println("8. Sap xep tang dan");
            System.out.println("9. Sap xep giam dan");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang (0-9): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: nhapMang(); break;
                case 2: xuatMang(); break;
                case 3: tinhTong(); break;
                case 4: demK(); break;
                case 5: findMaxMin(true); break;
                case 6: findMaxMin(false); break;
                case 7: xuatSNT(); break;
                case 8: sapXepTang(); break;
                case 9: sapXepGiam(); break;
                case 0: System.out.println("Tam biet!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // 1. Nhap mang ngau nhien
    static void nhapMang() {
        System.out.print("Nhap so luong phan tu N: ");
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        System.out.println("=> Da khoi tao mang ngau nhien thanh cong.");
    }

    // 2. Xuat mang
    static void xuatMang() {
        if (arr == null) { System.out.println("Mang trong!"); return; }
        System.out.println("Mang hien tai: " + Arrays.toString(arr));
    }

    // 3. Tinh tong
    static void tinhTong() {
        long sum = 0;
        for (int x : arr) sum += x;
        System.out.println("Tong cac phan tu: " + sum);
    }

    // 4. Dem so lan xuat hien cua K
    static void demK() {
        System.out.print("Nhap so K: ");
        int k = sc.nextInt();
        int count = 0;
        for (int x : arr) if (x == k) count++;
        System.out.println("So " + k + " xuat hien " + count + " lan.");
    }

    // 5 & 6. Tim Max/Min
    static void findMaxMin(boolean isMax) {
        int res = arr[0];
        for (int x : arr) {
            if (isMax ? x > res : x < res) res = x;
        }
        System.out.println((isMax ? "Max: " : "Min: ") + res);
    }

    // 7. So nguyen to
    static void xuatSNT() {
        System.out.print("Cac so nguyen to: ");
        for (int x : arr) {
            if (isPrime(x)) System.out.print(x + " ");
        }
        System.out.println();
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    // 8. Sap xep tang
    static void sapXepTang() {
        Arrays.sort(arr);
        System.out.println("Da sap xep tang dan.");
    }

    // 9. Sap xep giam
    static void sapXepGiam() {
        Arrays.sort(arr);
        System.out.print("Mang giam dan: ");
        for (int i = n - 1; i >= 0; i--) System.out.print(arr[i] + " ");
        System.out.println();
    }
}