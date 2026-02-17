class superkeywordex {
    int x =10;
    public superkeywordex(){
        System.out.println("Default constructor");
    }
    void display(){
        System.out.println("working");
    }
}

class child extends superkeywordex{
    int x =20;
    public child(){
        super();
        System.out.println("Child class constructor"+super.x);
        super.display();
    }
    public static void main(String[] args){
        child c1 = new child();
    }
}