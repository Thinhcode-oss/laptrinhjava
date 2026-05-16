import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceTest {
    private static ArrayList<Invoice> invoiceList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Tạo dữ liệu giả (Mocked data) ít nhất 10 Invoice
        generateMockData();

        int choice;
        do {
            showMenu();
            System.out.print("Vui lòng chọn chức năng (0-5): ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputNewInvoice();
                    break;
                case 2:
                    displayAllInvoices();
                    break;
                case 3:
                    sortInvoices();
                    break;
                case 4:
                    searchInvoice();
                    break;
                case 5:
                    deleteInvoice();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n========== QUẢN LÝ HÓA ĐƠN ==========");
        System.out.println("1. Nhập thêm một Invoice mới vào danh sách");
        System.out.println("2. Xuất thông tin danh sách Invoice");
        System.out.println("3. Sắp xếp danh sách (Tăng dần theo Mã MH và Số lượng)");
        System.out.println("4. Tìm kiếm Invoice theo Mã mặt hàng");
        System.out.println("5. Xóa một Invoice theo Mã mặt hàng");
        System.out.println("0. Thoát chương trình");
        System.out.println("=====================================");
    }

    // Khởi tạo 10 dữ liệu giả
    private static void generateMockData() {
        invoiceList.add(new Invoice("MH05", "Chuột Logitech", 5, 250000));
        invoiceList.add(new Invoice("MH01", "Bàn phím cơ", 2, 850000));
        invoiceList.add(new Invoice("MH09", "Màn hình Dell 24 inch", 1, 3500000));
        invoiceList.add(new Invoice("MH02", "Tai nghe Sony", 10, 450000));
        invoiceList.add(new Invoice("MH07", "Lót chuột RGB", 15, 120000));
        invoiceList.add(new Invoice("MH03", "Cáp mạng 5m", -5, 50000)); // Qty âm sẽ auto thành 0
        invoiceList.add(new Invoice("MH06", "RAM 8GB DDR4", 4, 600000));
        invoiceList.add(new Invoice("MH08", "Ổ cứng SSD 256GB", 3, 750000));
        invoiceList.add(new Invoice("MH10", "Webcam HD", 2, 550000));
        invoiceList.add(new Invoice("MH04", "USB 32GB", 8, -100000)); // Giá âm sẽ auto thành 0.0
        // Thêm một mã trùng để test sắp xếp theo số lượng
        invoiceList.add(new Invoice("MH05", "Chuột Logitech V2", 2, 280000)); 
    }

    // 1. Nhập thêm Invoice (Kiểm tra trùng lặp)
    private static void inputNewInvoice() {
        System.out.print("Nhập Mã mặt hàng: ");
        String id = scanner.nextLine();

        // Kiểm tra trùng mã mặt hàng
        for (Invoice inv : invoiceList) {
            if (inv.getPartNumber().equalsIgnoreCase(id)) {
                System.out.println("Lỗi: Mã mặt hàng đã tồn tại trong danh sách!");
                return;
            }
        }

        System.out.print("Nhập Mô tả: ");
        String desc = scanner.nextLine();
        System.out.print("Nhập Số lượng: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập Giá bán: ");
        double price = Double.parseDouble(scanner.nextLine());

        Invoice newInvoice = new Invoice(id, desc, qty, price);
        invoiceList.add(newInvoice);
        System.out.println("Đã thêm thành công!");
    }

    // 2. Xuất danh sách
    private static void displayAllInvoices() {
        if (invoiceList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\n--- DANH SÁCH HÓA ĐƠN ---");
        for (Invoice inv : invoiceList) {
            System.out.println(inv.toString());
        }
    }

    // 3. Sắp xếp danh sách (Dùng thuật toán Bubble Sort - Sắp xếp nổi bọt)
    private static void sortInvoices() {
        int n = invoiceList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Invoice inv1 = invoiceList.get(j);
                Invoice inv2 = invoiceList.get(j + 1);

                // Ưu tiên 1: So sánh Mã mặt hàng (Tăng dần)
                int idCompare = inv1.getPartNumber().compareToIgnoreCase(inv2.getPartNumber());
                
                // Ưu tiên 2: Nếu Mã giống nhau, so sánh Số lượng (Tăng dần)
                boolean shouldSwap = false;
                if (idCompare > 0) {
                    shouldSwap = true;
                } else if (idCompare == 0 && inv1.getQuantity() > inv2.getQuantity()) {
                    shouldSwap = true;
                }

                // Hoán đổi vị trí
                if (shouldSwap) {
                    invoiceList.set(j, inv2);
                    invoiceList.set(j + 1, inv1);
                }
            }
        }
        System.out.println("Đã sắp xếp danh sách thành công! (Dùng Bubble Sort)");
        displayAllInvoices();
    }

    // 4. Tìm kiếm tuyến tính theo Mã mặt hàng
    private static void searchInvoice() {
        System.out.print("Nhập Mã mặt hàng cần tìm: ");
        String searchId = scanner.nextLine();
        boolean found = false;

        for (Invoice inv : invoiceList) {
            if (inv.getPartNumber().equalsIgnoreCase(searchId)) {
                System.out.println("Đã tìm thấy:");
                System.out.println(inv.toString());
                found = true;
                break; // Xóa break nếu có thể có nhiều mã giống nhau (nhưng đề yêu cầu ko trùng)
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy hóa đơn nào với mã: " + searchId);
        }
    }

    // 5. Xóa Invoice theo Mã mặt hàng
    private static void deleteInvoice() {
        System.out.print("Nhập Mã mặt hàng cần xóa: ");
        String deleteId = scanner.nextLine();
        boolean removed = false;

        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getPartNumber().equalsIgnoreCase(deleteId)) {
                invoiceList.remove(i);
                removed = true;
                System.out.println("Đã xóa thành công hóa đơn có mã: " + deleteId);
                break;
            }
        }

        if (!removed) {
            System.out.println("Không tìm thấy mã " + deleteId + " để xóa!");
        }
    }
}