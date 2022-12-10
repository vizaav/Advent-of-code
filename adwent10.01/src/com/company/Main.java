package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/company/input.txt");
        Scanner scanner = new Scanner(file);
        int X = 1;
        int cycle = 0;
        int strength = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.startsWith("addx")){

                cycle++;
                strength += calculateSignalStrength(cycle, X);

                cycle++;
                strength += calculateSignalStrength(cycle, X);

                String[] split = line.split(" ");
                if(split[1].startsWith("-")){
                    split[1] = split[1].replace("-", "");
                    X -= Integer.parseInt(split[1]);
                }else{
                    X += Integer.parseInt(split[1]);
                }


            }else if(line.startsWith("noop")){

                cycle++;
                strength += calculateSignalStrength(cycle, X);

            }else{
                System.out.println("Wait, what?");
            }
        }
        System.out.println("Strength: " + strength);

    }

    public static int calculateSignalStrength(int cycle, int x){
        int result = 0;
        int[] milestones = {20, 60, 100, 140, 180, 220};
        if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
            result = cycle*x;
        }
        return result;
    }
}
