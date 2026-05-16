public class HinhVuong extends HinhChuNhat {
    public HinhVuong(String mau, double canh) {
        super(mau, canh, canh); // Hình vuông là trường hợp đặc biệt của HCN
    }

    @Override
    public String layThongTin() {
        return "Hình vuông - Màu: " + mau + ", Cạnh: " + chieudai;
    }
}
