package com.gla.generics;

public class ClothingCategory implements ProductCategory {
    private String size;

    public ClothingCategory(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public String getCategoryName() {
        return "Clothing - Size " + size;
    }
}
