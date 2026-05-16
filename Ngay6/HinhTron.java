public class HinhTron extends Hinh {
    private double bankinh;

    public HinhTron(String mau, double bankinh) {
        super(mau);
        this.bankinh = bankinh;
    }

    @Override
    public double tinhDienTich() { return Math.PI * bankinh * bankinh; }

    @Override
    public double tinhChuVi() { return 2 * Math.PI * bankinh; }

    @Override
    public String layThongTin() {
        return super.layThongTin() + ", Bán kính: " + bankinh;
    }
}