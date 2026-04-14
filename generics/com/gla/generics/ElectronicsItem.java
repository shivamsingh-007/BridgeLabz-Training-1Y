package com.gla.generics;

public class ElectronicsItem extends WarehouseItem {
    private int warrantyMonths;

    public ElectronicsItem(String itemId, String name, int warrantyMonths) {
        super(itemId, name);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public String toString() {
        return super.toString() + " (Warranty: " + warrantyMonths + " months)";
    }
}
