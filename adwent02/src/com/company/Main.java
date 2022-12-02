package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    THEM:
    A - rock
    B - paper
    C - scissors

    ME:
    X - rock
    Y - paper
    Z - scissors

    SHAPES:
    1 - rock
    2 - paper
    3 - scissors

    0 - lost
    3 - draw
    6 - win
     */

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src\\com\\company\\input.txt");
        Scanner scanner = new Scanner(file);
        int myScore = 0;
        int theirScore = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            //wins
            if(isAWin(line)){
                myScore += 6;
                if(line.matches("A Y")){
                    myScore += 2;
                    theirScore += 1;
                }else if(line.matches("B Z")){
                    myScore += 3;
                    theirScore += 2;
                }else if(line.matches("C X")){
                    myScore += 1;
                    theirScore += 3;
                }
            }

            //draws
            if(isADraw(line)){
                myScore += 3;
                theirScore += 3;

                if(line.matches("A X")){
                    theirScore += 1;
                    myScore += 1;
                }else if(line.matches("B Y")){
                    myScore += 2;
                    theirScore += 2;
                }else if(line.matches("C Z")){
                    myScore += 3;
                    theirScore += 3;
                }
            }

            //loses
            if(isALose(line)){
                theirScore += 6;

                if(line.matches("A Z")){
                    theirScore += 1;
                    myScore += 3;
                }else if(line.matches("B X")){
                    theirScore += 2;
                    myScore += 1;
                }else if(line.matches("C Y")){
                    theirScore += 3;
                    myScore += 2;
                }
            }

        }

        System.out.println("Their score: " + theirScore);
        System.out.println("My score: " + myScore);
    }//main end

    public static boolean isADraw(String line){
        ArrayList<String> draws = new ArrayList<>();
        draws.add("A X");
        draws.add("B Y");
        draws.add("C Z");

        for (int i = 0; i < draws.size(); i++) {
            if(line.equals(draws.get(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean isAWin(String line){
        ArrayList<String> wins = new ArrayList<>();
        wins.add("A Y");
        wins.add("B Z");
        wins.add("C X");

        for (int i = 0; i < wins.size(); i++) {
            if(line.equals(wins.get(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean isALose(String line){
        ArrayList<String> loses = new ArrayList<>();
        loses.add("A Z");
        loses.add("B X");
        loses.add("C Y");

        for (int i = 0; i < loses.size(); i++) {
            if(line.equals(loses.get(i))){
                return true;
            }
        }
        return false;
    }
}
