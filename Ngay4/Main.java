import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập liệu cho nhân viên 1
        System.out.println("Nhap thong tin nhan vien 1:");
        System.out.print("Ho: "); String ho1 = sc.nextLine();
        System.out.print("Ten: "); String ten1 = sc.nextLine();
        System.out.print("So san pham: "); int sp1 = sc.nextInt();
        sc.nextLine(); // Xóa bộ nhớ đệm
        NhanVien nv1 = new NhanVien(ho1, ten1, sp1);

        // Nhập liệu cho nhân viên 2
        System.out.println("\nNhap thong tin nhan vien 2:");
        System.out.print("Ho: "); String ho2 = sc.nextLine();
        System.out.print("Ten: "); String ten2 = sc.nextLine();
        System.out.print("So san pham: "); int sp2 = sc.nextInt();
        NhanVien nv2 = new NhanVien(ho2, ten2, sp2);

        // Xuất lương
        System.out.println("\n--- KET QUA ---");
        System.out.printf("Luong nhan vien 1 (%s %s): %.2f\n", nv1.getHo(), nv1.getTen(), nv1.getLuong());
        System.out.printf("Luong nhan vien 2 (%s %s): %.2f\n", nv2.getHo(), nv2.getTen(), nv2.getLuong());

        // So sánh hiệu suất
        int chenhLech = Math.abs(nv1.getSoSP() - nv2.getSoSP());

        // CÁCH 1: Dùng hàm LonHon
        System.out.println("\n[Cach 1: Dung ham LonHon]");
        if (nv1.LonHon(nv2)) {
            System.out.println(nv1.getTen() + " lam nhieu hon " + nv2.getTen() + " la " + chenhLech + " san pham.");
        } else if (nv2.LonHon(nv1)) {
            System.out.println(nv2.getTen() + " lam nhieu hon " + nv1.getTen() + " la " + chenhLech + " san pham.");
        } else {
            System.out.println("Ca hai nhan vien co so san pham bang nhau.");
        }

        // CÁCH 2: Không dùng hàm LonHon (So sánh trực tiếp thuộc tính)
        System.out.println("\n[Cach 2: So sanh truc tiep]");
        if (nv1.getSoSP() > nv2.getSoSP()) {
            System.out.println("Nhan vien " + nv1.getTen() + " vuot troi hon.");
        } else if (nv1.getSoSP() < nv2.getSoSP()) {
            System.out.println("Nhan vien " + nv2.getTen() + " vuot troi hon.");
        } else {
            System.out.println("Nang suat ngang nhau.");
        }
    }
}