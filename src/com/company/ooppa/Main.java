package com.company.ooppa;

public class Main {

    public static void main(String[] args) {
    HashMap<String, String> myHashMap = new HashMap<>();
    myHashMap.add("fruit","Apple");
    myHashMap.add("otherFruit","Pear");
    System.out.println(myHashMap.getValue("fruit"));
    System.out.println(myHashMap.getValue("otherFruit"));
    myHashMap.add("other", "bubble");
    System.out.println(myHashMap.getValue("other"));
    }
}
