public class Hinh {
    protected String mau;

    public Hinh(String mau) {
        this.mau = mau;
    }

    public double tinhDienTich() { return 0; }
    public double tinhChuVi() { return 0; }

    public String layThongTin() {
        return "Màu sắc: " + mau;
    }
}