package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/company/input.txt");
        Directory root = new Directory("root");
        Scanner scanner = new Scanner(file);
        Directory currentDirectory = root;
        ArrayList<Directory> allDirectories = new ArrayList<>();
        allDirectories.add(root);


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.startsWith("$ cd")) {
                line = line.replace("$ cd ", "");
            if (line.equals("..")) {
                    currentDirectory = currentDirectory.parent;
            } else if (line.equals("/")) {
                    currentDirectory = root;
            } else {
                    for (Directory directory : currentDirectory.subdirectories) {
                        if (directory.name.equals(line)) {
                            currentDirectory = directory;
                        }else{

                            allDirectories.add(new Directory(line));
                        }
                    }
                }
            //making contents
                addContents(currentDirectory, scanner, allDirectories);

            }
        }//end of reading
        int sum = 0;

        for (int i = 0; i < allDirectories.size(); i++) {
            if(allDirectories.get(i).getSize(0) <= 100000) {
                System.out.println("The size of directory " + allDirectories.get(i).name + " is " + allDirectories.get(i).getSize(0));
                sum += allDirectories.get(i).getSize(0);
            }
        }

        System.out.println("The sum of directories with size smaller than 100000: " + sum);


    }

    public static String addContents(Directory currentDirectory, Scanner scanner, ArrayList<Directory> allDirectories){
        String line = "";
        while(!line.startsWith("$ cd")){
            line = scanner.nextLine();
            if(line.matches("\\d* .*")){
                String[] splitLine = line.split(" ");
                currentDirectory.addFile(new MyFile(splitLine[1], Integer.parseInt(splitLine[0])));
            }else if(line.startsWith("dir")){
                String[] splitLine = line.split(" ");
                currentDirectory.addSubdirectory(new Directory(splitLine[1]), allDirectories);
            }else if(line.startsWith("$ls")){
                //do nothing ig
            }else if(line.startsWith("$ cd")){
                return line;
            }
        }
        return line;
    }
}
