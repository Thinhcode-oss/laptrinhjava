public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor khởi tạo các giá trị
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        
        // Ràng buộc số lượng không dương thì đặt thành 0
        this.quantity = Math.max(quantity, 0);
        
        // Ràng buộc giá không dương thì đặt thành 0.0
        this.pricePerItem = Math.max(pricePerItem, 0.0);
    }

    // Getters và Setters
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0); // Kiểm tra khi set
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = Math.max(pricePerItem, 0.0); // Kiểm tra khi set
    }

    // Phương thức tính tổng tiền hóa đơn
    public double getInvoiceAmount() {
        return this.quantity * this.pricePerItem;
    }

    // Phương thức in thông tin hóa đơn cho đẹp
    @Override
    public String toString() {
        return String.format("Mã MH: %-10s | Mô tả: %-20s | Số lượng: %-5d | Giá: %-10.2f | Tổng tiền: %.2f", 
                partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
}