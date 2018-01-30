package com.john;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National");

        bank.addBranch("Patra");
        bank.addCust("Patra", "Takis", 1000.23);
        bank.addCust("Patra", "Makis", 1001.55);
        bank.addCust("Patra", "Anna", 10330.3);

        bank.addBranch("Athens");
        bank.addCust("Athens", "Giorgos", 1898.33);

        bank.addCustTransaction("Patra", "Makis", 10.4);
        bank.addCustTransaction("Patra", "Makis", 1988.99);
        bank.addCustTransaction("Patra", "Makis", 2881.0);

        bank.addCustTransaction("Athens", "Giorgos", 102192384.2);
        bank.addCustTransaction("Athens", "Giorgos", 28.0);


        bank.listCust("Patra", true);
        bank.listCust("Athens", true);
    }
}
