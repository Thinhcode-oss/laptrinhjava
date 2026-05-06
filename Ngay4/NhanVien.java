public class NhanVien {
    private String ho;
    private String ten;
    private int soSP;

    // Ham khoi tao (Constructor)
    public NhanVien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        // Kiem tra so san pham, neu am thi gan bang 0
        if (soSP < 0) {
            this.soSP = 0;
        } else {
            this.soSP = soSP;
        }
    }

    // Cac ham Getter va Setter
    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public int getSoSP() { return soSP; }
    public void setSoSP(int soSP) {
        if (soSP >= 0) this.soSP = soSP;
        else this.soSP = 0;
    }

    // Ham tinh luong dua tren don gia luy tien
    public double getLuong() {
        double donGia;
        if (soSP >= 1 && soSP <= 199) {
            donGia = 0.5;
        } else if (soSP <= 399) {
            donGia = 0.55;
        } else if (soSP <= 599) {
            donGia = 0.6;
        } else {
            donGia = 0.65;
        }
        
        // Cong thuc: $Luong = SoSP \times don gia$
        return (double) soSP * donGia;
    }

    // Ham so sanh so san pham giua 2 nhan vien
    public boolean LonHon(NhanVien nv2) {
        return this.soSP > nv2.getSoSP();
    }
}