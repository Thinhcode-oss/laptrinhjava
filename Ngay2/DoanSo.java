import java.util.Scanner;

public class DoanSo {
    // 1. Ham main BAT BUOC phai co dung cau truc nay de chay duoc [cite: 41, 63, 91]
    public static void main(String[] args) {
        int MIN_NUMBER = 0;
        int MAX_NUMBER = 100;
        // Tao so ngau nhien tu 0 den 99
        int NUMBER = (int)(Math.random() * (MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER);
        int LIMIT_TRY = 7;

        int n;
        int curr = 1; // Bat dau tu lan thu thu 1
        
        System.out.println("Chao mung ban den voi tro choi Doan So!");
        System.out.println("Toi da nghi mot so trong khoang 0 - 99. Ban co " + LIMIT_TRY + " lan thu.");

        // Tao Scanner mot lan duy nhat de dung chung cho ca chuong trinh
        Scanner in = new Scanner(System.in);

        while (curr <= LIMIT_TRY) {
            System.out.print("\nLan thu " + curr + "/" + LIMIT_TRY + ": ");
            n = nhapSo(in); // Truyen Scanner vao ham de nhap so

            if (n > NUMBER) {
                System.out.println("=> Bi mat BE HON so ban vua nhap.");
            } else if (n < NUMBER) {
                System.out.println("=> Bi mat LON HON so ban vua nhap.");
            } else {
                System.out.println("✨ CHUC MUNG! Ban da doan dung roi!!!");
                in.close(); // Dong Scanner truoc khi ket thuc
                return;
            }
            curr++;
        }
        
        System.out.println("\n💀 Ban da het lan thu! So bi mat la: " + NUMBER);
        in.close();
    }

    // 2. Chuyen ham nhap so thanh static de ham main co the goi truc tiep
    // Doi ten thanh nhapSo (viet thuong chu dau) theo quy tac dat ten phuong thuc
    public static int nhapSo(Scanner in) {
        int n = -1;
        boolean isValid = false;
        
        while (!isValid) {
            try {
                System.out.print("Nhap mot so (0 - 99): ");
                String input = in.next(); // Doc du lieu duoi dang chuoi
                n = Integer.parseInt(input); // Chuyen doi chuoi sang so
                
                if (n >= 0 && n < 100) {
                    isValid = true;
                } else {
                    System.out.println("⚠️ Vui long chi nhap so trong khoang 0 den 99!");
                }
            } catch (NumberFormatException e) {
                // Xu ly khi nguoi dung nhap chu thay vi so
                System.out.println("❌ Loi: Ban phai nhap vao mot con so hop le.");
            }
        }
        return n;
    }
}