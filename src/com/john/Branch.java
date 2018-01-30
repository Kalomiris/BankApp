package com.john;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCust(String custName, double initialAmount){
        if (findCust(custName)==null){
            this.customers.add(new Customer(custName,initialAmount));
            return true;
        }
        return false;
    }

    public boolean addNewCustTransaction(String custName,double amount){
        Customer existing = findCust(custName);
        if (findCust(custName)!=null){
            existing.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCust(String custName){
        for (int i=0;i<this.customers.size();i++){
            Customer check = this.customers.get(i);
            if (check.getName().equals(custName)){
                return check;
            }
        }
        return null;
    }
}
