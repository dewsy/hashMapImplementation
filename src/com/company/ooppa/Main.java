package com.company.ooppa;

public class Main {

    public static void main(String[] args) {
    HashMap<Integer, String> myHashMap = new HashMap<>();
    myHashMap.add(2,"alma");
    myHashMap.add(18,"korte");
    System.out.println(myHashMap.getValue(2));
    System.out.println(myHashMap.getValue(18));
    myHashMap.add(5, "buborek");
    System.out.println(myHashMap.getValue(5));
    }
}
