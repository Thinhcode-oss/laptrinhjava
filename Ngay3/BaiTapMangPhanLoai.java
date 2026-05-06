public class BaiTapMangPhanLoai {

    public static void main(String[] args) {
        // Mảng đầu vào theo ví dụ trong hình
        int[] M = {3, 6, 7, 8, 11, 17, 2, 90, 2, 5, 4, 5, 8};

        // 1. Xử lý Số lẻ
        System.out.print("Dòng 1 (Số lẻ): ");
        int countLe = 0;
        for (int x : M) {
            if (x % 2 != 0) { // Kiểm tra số lẻ 
                System.out.print(x + " ");
                countLe++;
            }
        }
        System.out.println("-> Tổng cộng có " + countLe + " số lẻ.");

        // 2. Xử lý Số chẵn
        System.out.print("Dòng 2 (Số chẵn): ");
        int countChan = 0;
        for (int x : M) {
            if (x % 2 == 0) { // Kiểm tra số chẵn
                System.out.print(x + " ");
                countChan++;
            }
        }
        System.out.println("-> Total " + countChan + " so chan");

        // 3. Xử lý Số nguyên tố
        System.out.print("Dong 3 so nguyen to: ");
        for (int x : M) {
            if (isPrime(x)) {
                System.out.print(x + " ");
            }
        }
        System.out.println();

        // 4. Xử lý Số không phải nguyên tố
        System.out.print("Dong 4 khong phai so nguyen to: ");
        for (int x : M) {
            if (!isPrime(x)) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        // Tối ưu bằng cách chỉ chạy đến căn bậc hai của n 
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}