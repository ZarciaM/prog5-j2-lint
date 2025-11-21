package org.zarcia.model;

public class Wallet {

    private String color;
    private int size;
    private int amount;
    private boolean open;
    private boolean lost;

    public Wallet(String color, int size) {
        this.color = color;
        this.size = size;
        this.amount = 0;
        this.open = false;
        this.lost = false;
    }

    public void addMoney(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        if (!open) {
            throw new IllegalStateException("Wallet must be open to add money");
        }
        this.amount += value;
    }

    public int getAmount() {
        if (!open) {
            throw new IllegalStateException("Wallet must be open to view the amount");
        }
        return this.amount;
    }

    public void open() {
        if (lost) {
            throw new IllegalStateException("Cannot open a lost wallet");
        }
        this.open = true;
    }

    public void close() {
        this.open = false;
    }

    public boolean isLost() {
        return this.lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
        this.open = false;
    }

    public boolean checkAmount(int requiredAmount) {
        if (!open) {
            throw new IllegalStateException("Wallet must be open to check the amount");
        }
        return this.amount >= requiredAmount;
    }

    public String getColor() {
        return this.color;
    }

    public int getSize() {
        return this.size;
    }
}
