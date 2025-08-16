package com.palakgupta.ex_01_RA_Basics;

public class APITesting_Lab03_NP {

    public void step1(){
        System.out.println("Step1");
    }

    public void step2(){
        System.out.println("Step 2");
    }

    public void step3(String param1){
        System.out.println("Step 3");

    }

    public static void main(String[] args) {
        APITesting_Lab03_NP nbp = new APITesting_Lab03_NP();
        nbp.step1();
        nbp.step2();
        nbp.step3("palak");
    }
}
