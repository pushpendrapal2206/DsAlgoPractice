package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transactions {

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        Map<String, Integer> creditLimitByCustomer = new HashMap<>();
        List<String> rejectedTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            String[] parsedTransaction = transaction.split(",");
            String customerKey = parsedTransaction[0] + parsedTransaction[1] + parsedTransaction[2];
            int amount = Integer.parseInt(parsedTransaction[3]);
            int customerCreditLimit = creditLimitByCustomer.getOrDefault(customerKey, creditLimit);
            if (amount <= customerCreditLimit) {
                creditLimitByCustomer
                        .put(customerKey, customerCreditLimit - amount);
            } else {
                rejectedTransactions.add(parsedTransaction[4]);
            }
        }
        return rejectedTransactions;
    }

    public static void main(String[] s) {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,200,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);
    }

}
