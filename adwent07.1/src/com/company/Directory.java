package com.company;

import java.util.ArrayList;

public class Directory {
    public final ArrayList<MyFile> files = new ArrayList<MyFile>();
    public ArrayList<Directory> subdirectories = new ArrayList<>();

    public String name;
    public Directory parent;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }
    public Directory(String name){
        this.name = name;
    }
    public void setParentDirectory(Directory directory){
        this.parent = directory;
    }
    public void addFile(MyFile file){
        files.add(file);
    }
    public void addSubdirectory(Directory directory, ArrayList<Directory> arrayList){
        subdirectories.add(directory);
        directory.setParentDirectory(this);
        //katalog.addSubdirectory(new Directory papiez); C://...//katalog//papiez
        arrayList.add(directory);

    }
    public int getSize(int size){

        for (MyFile file : files) {
            size += file.getSize();
        }
        for (Directory directory : subdirectories) {
            size += directory.getSize(size);
        }
        return size;
    }
}
