import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKhachHang {
    static ArrayList<KhachHang> danhSach = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n--- MENU QUAN LY KHACH HANG ---");
            System.out.println("1 Nhap danh sach Khach Hang");
            System.out.println("2 Xuat danh sach Khach Hang");
            System.out.println("3. Luu danh sach vao o cung (TextFile)");
            System.out.println("4. Doc danh sach tu o cung (TextFile)");
            System.out.println("0 Thoat");
            System.out.print("Chon chuc nang ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: nhapKhachHang(); break;
                case 2: xuatKhachHang(); break;
                case 3: luuFileText(); break;
                case 4: docFileText(); break;
            }
        } while (chon != 0);
    }

    private static void nhapKhachHang() {
        System.out.print("Nhap ma ");
        String ma = sc.nextLine();
        System.out.print("Nhap ten ");
        String ten = sc.nextLine();
        System.out.print("Nhap nam sinh ");
        int namSinh = Integer.parseInt(sc.nextLine());
        danhSach.add(new KhachHang(ma, ten, namSinh));
        System.out.println("Them thanh cong");
    }

    private static void xuatKhachHang() {
        System.out.println("Danh sach Khach Hang");
        for (KhachHang kh : danhSach) {
            System.out.println(kh.toString());
        }
    }

    private static void luuFileText() {
        try {
            FileOutputStream fos = new FileOutputStream("d:/khachhang.txt"); // [cite: 32]
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8"); // [cite: 32]
            BufferedWriter bw = new BufferedWriter(osw); // [cite: 32]

            for (KhachHang kh : danhSach) {
                String line = kh.getMa() + ";" + kh.getTen() + ";" + kh.getNamSinh();
                bw.write(line); // [cite: 33]
                bw.newLine(); // [cite: 34]
            }
            bw.close(); // [cite: 38]
            osw.close(); // [cite: 39]
            fos.close(); // [cite: 40]
            System.out.println("Da luu vao d:/khachhang.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void docFileText() {
        try {
            danhSach.clear();
            FileInputStream fis = new FileInputStream("d:/khachhang.txt"); // [cite: 43]
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // [cite: 43]
            BufferedReader br = new BufferedReader(isr); // [cite: 43]

            String line = br.readLine(); // [cite: 44]
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 3) {
                    danhSach.add(new KhachHang(arr[0], arr[1], Integer.parseInt(arr[2])));
                }
                line = br.readLine();
            }
            br.close(); // [cite: 46]
            isr.close(); // [cite: 47]
            fis.close(); // [cite: 48]
            System.out.println("Doc du lieu thanh cong");
        } catch (Exception e) {
            System.out.println("Khong tim thay file hoac co loi xay ra");
        }
    }
}