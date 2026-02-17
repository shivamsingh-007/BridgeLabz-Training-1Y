public class constructorchainex {
    int engineNo;
    String modelname;
    int price;

    public constructorchainex() {
        this(121,"suv",20000);
        System.out.println("Default constructor");
    }

    public constructorchainex(int engineNo, String modelname, int price) {
        this.engineNo = engineNo;
        this.modelname = modelname;
        this.price = price;
    }

    void display() {
        System.out.println("Engine No: " + engineNo);
        System.out.println("Model Name: " + modelname);
        System.out.println("Price: " + price);
        System.out.println();
    }

    public static void main(String[] args) {
        constructorchainex c1 = new constructorchainex();
        constructorchainex c2 = new constructorchainex(121,"suv",20000);
        c1.display();
        c2.display();}}