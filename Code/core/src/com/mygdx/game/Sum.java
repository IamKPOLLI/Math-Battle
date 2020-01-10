package com.mygdx.game;

import java.util.Random;

public class Sum {
    public String Sum;
    public int[] answers;
    public int rightAns;

    public Sum(int diff){
        Random random = new Random(System.currentTimeMillis());
        int range=0;
        switch(diff) {
            case 0:{
                range=11;
                break;
            }
            case 1:{
                range=21;
                break;
            }
            case 2:{
                range=101;
                break;
            }
            case 3:{
                range = 201;
                break;
            }
        }

        int a = random.nextInt(range);
        int b = random.nextInt(range);
        rightAns=a+b;
        Sum = ""+a+'+'+b;
        answers = new int[9];
        boolean flag = true;
        answers[0]= rightAns;
        for (int i = 1; i < 9; i++) {
            int num = random.nextInt(range*2 + 10);
            for (int j = 0; j < i+1; j++) {
                if(answers[j] == num) {
                    flag = false;
                }
            }
            if(flag) {
                answers[i] = num;
            }else {
                i--;
                flag = true;
            }
        }
        shuffleArray(answers);

    }
    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }


}
