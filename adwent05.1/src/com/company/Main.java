package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/company/input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.matches("[\\d *]*")) {
                System.out.println(line);
                Stack<String>[] arr = new Stack[Integer.parseInt(line.substring(line.length() - 1))];
                System.out.println(Integer.parseInt(line.substring(line.length() - 1)));
            }
        }
        Scanner scanner1 = new Scanner(file);
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            if(line.matches("[[[A-Z]] *]*")){
                System.out.println("Weszło");
                String[] arr = line.split(" *");
                for (int i = 0; i < arr.length; i++) {
                    System.out.println("Array: " + arr[i]);
                }
            }

        }

    }
}
