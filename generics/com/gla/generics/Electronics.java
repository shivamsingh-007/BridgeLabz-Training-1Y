package com.gla.generics;

public class Electronics extends Cart<String> {
    public void addElectronics(String item) {
        addItem(item);
    }
}
