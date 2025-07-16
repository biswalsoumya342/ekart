package com.soumya.ekart.util;

public class ProductUtil {

    public static String slugGenerate(String name){
        return name.toLowerCase()
                .replaceAll("[^a-z0-9]","-")
                .replaceAll("+_","-")
                .replaceAll("^-|-$","-");
    }
}
