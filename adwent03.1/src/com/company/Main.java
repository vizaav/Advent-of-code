package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/company/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        while (scanner.hasNextLine()) {
            String[] arr = {scanner.nextLine(), scanner.nextLine(), scanner.nextLine()};
            char czarus = '♥';
            for (int i = 0; i < arr[0].length(); i++) {
                for (int j = 0; j < arr[1].length(); j++) {
                    for (int k = 0; k < arr[2].length(); k++) {
                        if(arr[0].charAt(i) == arr[1].charAt(j) && arr[1].charAt(j)== arr[2].charAt(k)){
                            czarus = arr[0].charAt(i);
                        }
                    }
                }
            }//end of that loop straight from hell
            int priority = getPriority(czarus);
            sum += priority;
        }
        System.out.println("Suma: " + sum);
    }
    public static int getPriority(char czarus) {
        int err = -1;
        char[] arr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == czarus) {
                return i + 1;
            }
        }
        return err;
    }
}
