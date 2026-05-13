public class KiemTraHinh {
    public static void main(String[] args) {
        Hinh hcn = new HinhChuNhat("Đỏ", 5, 10);
        Hinh tron = new HinhTron("Xanh", 7);
        Hinh vuong = new HinhVuong("Vàng", 4);

        Hinh[] danhSach = {hcn, tron, vuong};

        for (Hinh h : danhSach) {
            System.out.println(h.layThongTin());
            System.out.println("Diện tích: " + h.tinhDienTich());
            System.out.println("Chu vi: " + h.tinhChuVi());
            System.out.println("-------------------------");
        }
    }
}