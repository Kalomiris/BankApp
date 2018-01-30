package com.john;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName)==null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCust(String branchName,String custName,double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.newCust(custName,initialAmount);
        }

        return false;
    }

    public boolean addCustTransaction(String branchName,String custName,double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addNewCustTransaction(custName,amount);
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for (int i=0;i<this.branches.size();i++){
            Branch check = this.branches.get(i);
            if (check.getName().equals(branchName)){
                return check;
            }
        }
        return null;
    }

    public boolean listCust(String branchName,boolean showTransaction){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Customer details " + branch.getName());
            System.out.println("-------------------------");
            ArrayList<Customer> branchCust = branch.getCustomers();
            for (int i=0;i<branchCust.size();i++){
                Customer branchCustomer = branchCust.get(i);
                System.out.println("*Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransaction){
                    System.out.println("*Transactions:");
                    ArrayList<Double> transaction = branchCustomer.getTransaction();
                    if (transaction.size()==0){
                        System.out.println("There is not transaction");
                    }
                    for (int j=0;j<transaction.size();j++){
                        System.out.println("[" + (j+1) + "] Amount " + transaction.get(j));
                    }
                    System.out.println("\n");
                }
            }
            System.out.println("\n\n");
            return true;
        }else {
            return false;
        }

    }

}
