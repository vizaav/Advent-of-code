package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //reading the txt file
        File file = new File("src/com/company/input.txt");
        Scanner scanner = new Scanner(file);
        int counterContains = 0;
        int counterOverlaps = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] arr = line.split(",");
            System.out.println(arr[0] + " " + arr[1]);
            String[] firstElf = arr[0].split("-");
            String[] secondElf = arr[1].split("-");
            if (contains(firstElf, secondElf)) {
                counterContains++;
            }
            if (overlap(firstElf, secondElf)) {
                counterOverlaps++;
            }
        }
        System.out.println("Arrays that fully contain their partners: " + counterContains);
        System.out.println("Arrays that overlap with their partners: " + counterOverlaps);
    }

    public static boolean contains(String[] firstElfString, String[] secondElfString) {
        boolean isEqual = Integer.parseInt(firstElfString[0]) == Integer.parseInt(secondElfString[0]) && Integer.parseInt(firstElfString[1]) == Integer.parseInt(secondElfString[1]);
        if (isEqual) {
            return true;
        } else if (Integer.parseInt(firstElfString[0]) <= Integer.parseInt(secondElfString[0]) && Integer.parseInt(firstElfString[1]) >= Integer.parseInt(secondElfString[1])) {
            return true;
        } else if (Integer.parseInt(firstElfString[0]) >= Integer.parseInt(secondElfString[0]) && Integer.parseInt(firstElfString[1]) <= Integer.parseInt(secondElfString[1])) {
            return true;
        }
        return false;
    }

    public static boolean overlap(String[] firstElfString, String[] secondElfString) {
        boolean isEqual = Integer.parseInt(firstElfString[0]) == Integer.parseInt(secondElfString[0]) && Integer.parseInt(firstElfString[1]) == Integer.parseInt(secondElfString[1]);
        if (isEqual) {
            return true;
        } else if (contains(firstElfString, secondElfString)) {
            return true;
        } else if (Integer.parseInt(secondElfString[0]) <= Integer.parseInt(firstElfString[0]) && Integer.parseInt(firstElfString[0]) <= Integer.parseInt(secondElfString[1]) && Integer.parseInt(secondElfString[1]) <= Integer.parseInt(firstElfString[1])) {
            return true;
        } else if (Integer.parseInt(firstElfString[0]) <= Integer.parseInt(secondElfString[0]) && Integer.parseInt(secondElfString[0]) <= Integer.parseInt(firstElfString[1]) && Integer.parseInt(firstElfString[1]) <= Integer.parseInt(secondElfString[1])) {
            return true;
        }
        return false;
    }
}