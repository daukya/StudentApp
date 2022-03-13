package com.studentapp.utils;

import java.util.Random;

public class TestUtils {

    //Tạo phương thức getRandom ở đây để generate ra các giá trị khác nhau không bị lặp
    public static String getRandomValue(){
        Random random = new Random();
        int radomInt = random.nextInt(100000);
        return Integer.toString(radomInt);
    }
}
