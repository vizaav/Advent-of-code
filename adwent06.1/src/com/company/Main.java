package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	File file = new File("src/com/company/input.txt");
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
        System.out.println("Liczba znaków: " + fourDifferent(line));
    }

    public static int fourDifferent(String e){
        char[] chars = e.toCharArray();
       int counter = 4;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != chars[i+1] && chars[i] != chars[i+2] && chars[i] != chars[i+3] && chars[i+1] != chars[i+2] && chars[i+1] != chars[i+3] && chars[i+2] != chars[i+3]){
                return counter;
            }else{
                counter++;
            }

            }
        return -1;
        }
    }

