package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	File file = new File("src/com/company/input.txt");
    Scanner scanner = new Scanner(file);
    int sum = 0;
    while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        int mid = line.length() / 2;
        String[] parts = {line.substring(0, mid),line.substring(mid)};
        System.out.println(parts[0]);
        System.out.println(parts[1]);
        char czarus = '♥';
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                if(parts[0].charAt(i) == parts[1].charAt(j)){
                    czarus = parts[0].charAt(i);
                }
            }
        }
        System.out.println("Czaruś: " + czarus);
        System.out.println("Priorytet Czarusia: " + getPriority(czarus));
        sum += getPriority(czarus);
        ;
    }
        System.out.println("Suma: " + sum);
    }




    public static int getPriority(char czarus){
        int err = -1;
        char[] arr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == czarus){
                return i + 1;
            }
        }
        return err;
    }


}
