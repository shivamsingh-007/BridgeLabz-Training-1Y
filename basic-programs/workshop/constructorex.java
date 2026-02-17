class constructorex{
    int id;
    String name;
    int age;
    public constructorex(){
        System.out.println("Default constructor");
    }
    public constructorex(int id, String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    void display(){
    System.out.println("ID: "+id);
    System.out.println("Name: "+name);
    System.out.println("Age: "+age);
}
public static void main(String[] args){
   constructorex c1 = new constructorex();
   constructorex c2 = new constructorex(1,"Shiva",18);
   c1.display();
   c2.display();
}
}
