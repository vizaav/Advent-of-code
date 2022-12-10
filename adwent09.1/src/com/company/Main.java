package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/company/input.txt");
        Scanner scanner = new Scanner(file);
        char[][] gridT = new char[6000][6000];
        for (int i = 0; i < 6000; i++) {
            for (int j = 0; j < 6000; j++) {
                if(i == 3000 && j == 3000){
                    gridT[i][j] = 'T';
                }else{
                    gridT[i][j] = '.';
                }
            }
        }

        char[][] gridH = new char[6000][6000];
        for (int i = 0; i < 6000; i++) {
            for (int j = 0; j < 6000; j++) {
                if(i == 3000 && j == 3000){
                    gridH[i][j] = 'H';
                }else{
                    gridH[i][j] = '.';
                }
            }
        }

    }
}
