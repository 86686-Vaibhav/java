class Invoice{
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;


    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;


        if (quantity < 0) {
            this.quantity = 0;
        }
        if (pricePerItem < 0) {
            this.pricePerItem = 0.0;
        }
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription()
 {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem < 0) {
            this.pricePerItem = 0.0;
        } else {
            this.pricePerItem = pricePerItem; 

        }
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    public void displayInvoice() {
        System.out.println("Part Number: " + partNumber);
        System.out.println("Part Description: " + partDescription);
        System.out.println("Quantity:" + quantity);
        System.out.println("Price Per Item: $" + pricePerItem);

        System.out.println("Invoice Amount: $" + getInvoiceAmount());
    }
}

public class Assignmet3Q1{
    public static void main(String[] args) {
        Invoice invoice = new Invoice("12345", "Hammer", 5, 19.99);

        invoice.displayInvoice();

        invoice.setQuantity(-2);
        invoice.setPricePerItem(-5.0);

        System.out.println("\nAfter setting negative values:");
        invoice.displayInvoice();
    }
}