import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySinhVien {
    public static void main(String[] args) {
        ArrayList<String> dsSinhVien = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n--- MENU QUAN LY SINH VIEN ---");
            System.out.println("a. Them sinh vien");
            System.out.println("b. Xuat danh sach sinh vien");
            System.out.println("c. Sua sinh vien");
            System.out.println("d. Xoa sinh vien");
            System.out.println("e. Tim sinh vien co chu 'an'");
            System.out.println("f. Sap xep danh sach sinh vien tang dan theo ten");
            System.out.println("g. Xuat so luong sinh vien");
            System.out.println("0. EXIT");
            System.out.print("Moi ban chon (0-g): ");
            
            // Doc lua chon duoi dang chuoi de tranh loi troi dong
            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;
            char option = input.charAt(0);

            switch (option) {
                case 'a':
                    System.out.print("Nhap ten sinh vien can them: ");
                    String tenMoi = scanner.nextLine();
                    dsSinhVien.add(tenMoi);
                    System.out.println("Da them thanh cong!");
                    break;

                case 'b':
                    System.out.println("Danh sach sinh vien:");
                    for (String sv : dsSinhVien) {
                        System.out.println("- " + sv);
                    }
                    break;

                case 'c':
                    System.out.print("Nhap ten sinh vien can sua: ");
                    String tenCanSua = scanner.nextLine();
                    int indexSua = dsSinhVien.indexOf(tenCanSua);
                    if (indexSua != -1) {
                        System.out.print("Nhap ten moi: ");
                        dsSinhVien.set(indexSua, scanner.nextLine());
                        System.out.println("Da cap nhat thanh cong!");
                    } else {
                        System.out.println("Khong tim thay sinh vien nay.");
                    }
                    break;

                case 'd':
                    System.out.print("Nhap ten sinh vien can xoa: ");
                    String tenXoa = scanner.nextLine();
                    if (dsSinhVien.remove(tenXoa)) {
                        System.out.println("Da xoa thanh cong!");
                    } else {
                        System.out.println("Khong tim thay sinh vien de xoa.");
                    }
                    break;

                case 'e':
                    System.out.println("Sinh vien co ten chua chu 'an':");
                    boolean timThay = false;
                    for (String sv : dsSinhVien) {
                        if (sv.toLowerCase().contains("an")) {
                            System.out.println("- " + sv);
                            timThay = true;
                        }
                    }
                    if (!timThay) System.out.println("Khong tim thay sinh vien nao.");
                    break;

                case 'f':
                    Collections.sort(dsSinhVien);
                    System.out.println("Da sap xep danh sach tang dan theo ten.");
                    break;

                case 'g':
                    System.out.println("So luong sinh vien hien co: " + dsSinhVien.size());
                    break;

                case '0':
                    System.out.println("Tam biet!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (true);
    }
}