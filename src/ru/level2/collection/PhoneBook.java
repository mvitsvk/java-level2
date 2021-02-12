package ru.level2.collection;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String,String> abonent = new HashMap();


    public void add(String phone, String name){
        this.abonent.put(phone, name);
    }

    public void get(String name){
        System.out.println("Name " +name);
        for(Map.Entry entry:this.abonent.entrySet()){
            if (entry.getValue() == name) System.out.println("phone: " + entry.getKey());
        }
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "abonent=" + abonent +
                '}';
    }
}
