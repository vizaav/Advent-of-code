package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("src/com/company/data.txt");
        Scanner scanner = new Scanner(data);
        ArrayList<Elf> elves = new ArrayList<>();
        int elvesCounter = 0;
        elves.add(new Elf());

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.matches("")){
                elves.add(new Elf());
                elvesCounter++;
            }
            if(line.matches("[0-9]+")){
                elves.get(elvesCounter).addCalories(Integer.parseInt(line));
            }

        }

        for (int i = 0; i < elves.size(); i++) {
            System.out.println("Elf " + i + " ate " + elves.get(i).getCalories() + " calories");
        }

        Elf chadElf = new Elf();
        int index = 0;

        for (int i = 0; i < elves.size(); i++) {
            if(elves.get(i).getCalories() > chadElf.getCalories()){
                chadElf = elves.get(i);
                index = i;
            }
        }

        System.out.println("The baddest elf with most calories is elf " + elves.indexOf(chadElf) + " with " + chadElf.getCalories() + " calories");
        int caloriesFirst = chadElf.getCalories();
        elves.get(index).addCalories(-caloriesFirst);


        for (int i = 0; i < elves.size(); i++) {
            if(elves.get(i).getCalories() > chadElf.getCalories()){
                chadElf = elves.get(i);
                index = i;
            }
        }

        System.out.println("The baddest elf with most calories is elf " + elves.indexOf(chadElf) + " with " + chadElf.getCalories() + " calories");
        int caloriesSecond = chadElf.getCalories();
        elves.get(index).addCalories(-caloriesSecond);


        for (int i = 0; i < elves.size(); i++) {
            if(elves.get(i).getCalories() > chadElf.getCalories()){
                chadElf = elves.get(i);
                index = i;
            }
        }

        System.out.println("The baddest elf with most calories is elf " + elves.indexOf(chadElf) + " with " + chadElf.getCalories() + " calories");
        int caloriesThird = chadElf.getCalories();
        elves.get(index).addCalories(-caloriesThird);

        System.out.println("The sum is " + (caloriesFirst + caloriesSecond + caloriesThird));
        }



    }

