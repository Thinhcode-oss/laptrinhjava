public class HinhChuNhat extends Hinh {
    protected double chieudai, chieurong;

    public HinhChuNhat(String mau, double chieudai, double chieurong) {
        super(mau);
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    @Override
    public double tinhDienTich() { return chieudai * chieurong; }

    @Override
    public double tinhChuVi() { return (chieudai + chieurong) * 2; }

    @Override
    public String layThongTin() {
        return super.layThongTin() + ", Dài: " + chieudai + ", Rộng: " + chieurong;
    }
}