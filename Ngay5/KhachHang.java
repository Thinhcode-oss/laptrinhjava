public class KhachHang {
    private String ma;
    private String ten;
    private int namSinh;

    public KhachHang(String ma, String ten, int namSinh) {
        this.ma = ma;
        this.ten = ten;
        this.namSinh = namSinh;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public int getNamSinh() { return namSinh; }

    @Override
    public String toString() {
        return ma + " - " + ten + " - " + namSinh;
    }
}