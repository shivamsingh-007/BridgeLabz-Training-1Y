public class CloningPrototypeObjects {

    public static void main(String[] args) {
        ProductTemplate original = new ProductTemplate("Laptop", 999.99, "Electronics");

        try {
            ProductTemplate cloned = (ProductTemplate) original.clone();
            System.out.println("Original: " + original.getName() + ", Price: " + original.getPrice());
            System.out.println("Cloned: " + cloned.getName() + ", Price: " + cloned.getPrice());

            cloned.setPrice(899.99);
            System.out.println("After price change:");
            System.out.println("Original price: " + original.getPrice());
            System.out.println("Cloned price: " + cloned.getPrice());
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
        }
    }
}

class ProductTemplate implements Cloneable {
    private String name;
    private double price;
    private String category;

    public ProductTemplate(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
