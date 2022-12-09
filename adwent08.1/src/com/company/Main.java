package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/company/input.txt");
        Scanner scanner = new Scanner(file);

        //creating the arrays -done
        int numberOfComulns = 0;
        int numberOfRows = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            numberOfComulns = line.length();
            numberOfRows++;
        }
        System.out.println("Number of rows: " + numberOfRows);
        System.out.println("Number of columns: " + numberOfComulns);

        Tree[][] trees = new Tree[numberOfRows][numberOfComulns];
        /*
      0   -    0 1 2 3 4 5 6
      1   -    0 1 2 3 4 5 6
      2   -    0 1 2 3 4 5 6
         */
        //filling the array - done
        scanner = new Scanner(file);
        int row = 0;
        while (scanner.hasNextLine()) {
           String line = scanner.nextLine();
            for (int column = 0; column < line.length(); column++) {
                char character = line.charAt(column);
                    trees[row][column] = new Tree(Integer.parseInt(String.valueOf(character)));
            }
            row++;
        }
        //checking
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfComulns; j++) {
                System.out.print(trees[i][j].value);
                if(j == numberOfComulns - 1){
                    System.out.println();
                }
            }
        }

        //setting the visible trees
        //from the north
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfComulns; j++) {
                if(i == 0){
                    trees[i][j].setVisible();
                }
                else if(trees[i][j].value > trees[i-1][j].value ){
                    trees[i][j].setVisible();
                }
            }
        }

        //from the east
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfComulns; j++) {
                if(j == numberOfComulns - 1){
                    trees[i][j].setVisible();
                }
                else if(trees[i][j].value > trees[i][j+1].value ){
                    trees[i][j].setVisible();
                }
            }
        }

        //from the south
        for (int i = numberOfRows - 1; i >= 0; i--) {
            for (int j = 0; j < numberOfComulns; j++) {
                if(i == numberOfRows - 1){
                    trees[i][j].setVisible();
                }
                else if(trees[i][j].value > trees[i+1][j].value){
                    trees[i][j].setVisible();
                }
            }
        }

        //from the west
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfComulns; j++) {
                if(j == 0){
                    trees[i][j].setVisible();
                }
                else if(trees[i][j].value > trees[i][j-1].value ){
                    trees[i][j].setVisible();
                }
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfComulns; j++) {
                System.out.print(trees[i][j].visible  + " ");
                if(j == numberOfComulns - 1){
                    System.out.println();
                }
            }
        }

        //counting all the visible trees
        int visibleTrees = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfComulns; j++) {
                if(trees[i][j].visible){
                    visibleTrees++;
                }
            }
        }
        System.out.println("Number of trees visible off the grid: " + visibleTrees);

    }


}
