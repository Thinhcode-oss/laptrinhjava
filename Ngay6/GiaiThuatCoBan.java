public class GiaiThuatCoBan {
    // 1. Tìm GCD (Ước số chung lớn nhất) dùng thuật toán Euclid
    public static int timGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 2. Kiểm tra số hoàn thiện
    public static boolean isPerfectNumber(int n) {
        if (n <= 1) return false;
        int tong = 1;
        // Tối ưu: chỉ chạy đến căn bậc hai của n [cite: 171, 189]
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                tong += i;
                if (i != n / i) tong += n / i;
            }
        }
        return tong == n;
    }

    // 3. Kiểm tra số có toàn chữ số chẵn
    public static boolean isToanChuSoChan(int n) {
        n = Math.abs(n);
        if (n == 0) return true;
        while (n > 0) {
            if ((n % 10) % 2 != 0) return false; // Thấy số lẻ là loại ngay
            n /= 10;
        }
        return true;
    }

    // 4. Tính S(x, n) = x + x^3/3! + ... + x^(2n+1)/(2n+1)!
    public static double tinhS(double x, int n) {
        double tong = 0;
        double tuSo = x;
        double mauSo = 1;
        for (int i = 0; i <= n; i++) {
            // Số hạng hiện tại: x^(2i+1) / (2i+1)!
            if (i > 0) {
                tuSo *= (x * x);
                mauSo *= (2 * i) * (2 * i + 1);
            }
            tong += tuSo / mauSo;
        }
        return tong;
    }

    public static void main(String[] args) {
        // Bạn có thể viết thêm code để nhập dữ liệu bằng Scanner tại đây
        System.out.println("GCD(12, 18): " + timGCD(12, 18));
        System.out.println("6 là số hoàn thiện? " + isPerfectNumber(6));
        System.out.println("2468 toàn chữ số chẵn? " + isToanChuSoChan(2468));
        System.out.println("S(2, 3): " + tinhS(2, 3));
    }
}