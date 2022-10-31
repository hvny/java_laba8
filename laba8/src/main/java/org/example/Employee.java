package org.example;

public class Employee {
    private String name;
    private int age;
    private int money;


    public Employee(String Name, int Age, int Money){
        this.name = Name;
        this.age = Age;
        this.money = Money;
    }


    public int getMoney(){
        return money;
    }

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
}
