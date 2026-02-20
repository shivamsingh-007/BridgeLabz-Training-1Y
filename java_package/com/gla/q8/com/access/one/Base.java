package com.access.one;

public class Base {

    public void publicMethod() {
        System.out.println("publicMethod()    - Accessible everywhere");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod() - Accessible in subclass and same package");
    }

    void defaultMethod() {
        System.out.println("defaultMethod()   - Accessible only in same package");
    }

    private void privateMethod() {
        System.out.println("privateMethod()   - Accessible only inside this class");
    }

    public void callPrivate() {
        System.out.println("Calling privateMethod from inside Base:");
        privateMethod();
    }
}
