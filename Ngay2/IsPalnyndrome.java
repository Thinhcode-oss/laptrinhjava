import java.util.Scanner;

// Ten lop viet hoa chu cai dau theo quy tac Java
public class IsPalnyndrome {
    
    // Ham main phai co cau truc public static void moi co the khoi chay [cite: 63, 64, 89, 119]
    public static void main(String[] args) {
        // Khoi tao Scanner de doc du lieu tu ban phim [cite: 81]
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Nhap vao chuoi S: ");
            String S = scanner.nextLine(); // Doc mot dong van ban
            
            int len = S.length();
            boolean isPalnyndrome = true;
            
            // Duyet tu dau den giua chuoi de so sanh [cite: 10, 12]
            for (int i = 0; i < len / 2; i++) {
                // Su dung charAt(i) de truy cap ky tu tai vi tri i [cite: 13]
                // So sanh ky tu dau voi cuoi, thu 2 voi ap chot... [cite: 4, 7]
                if (S.charAt(i) != S.charAt(len - 1 - i)) {
                    isPalnyndrome = false;
                    
                    // In ra cap ky tu gay loi (tuy chon theo code goc cua ban)
                    System.out.println("Khac biet tai: " + S.charAt(i) + " va " + S.charAt(len - 1 - i));
                    break; // Thoat vong lap ngay khi thay khong doi xung
                }
            }
            
            if (isPalnyndrome) {
                System.out.println("Ket qua: La Palnyndrome");
            } else {
                System.out.println("Ket qua: Khong Palnyndrome");
            }
        } catch (Exception e) {
            System.out.println("Loi khi xu ly: " + e.getMessage());
        } finally {
            scanner.close(); // Luon dong Scanner de giai phong bo nho
        }
    }
}