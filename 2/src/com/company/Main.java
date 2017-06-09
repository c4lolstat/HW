package com.company;

public class Main {

    public static void main(String[] args) {
        DirectoryPrinter printer = new DirectoryPrinter();

        Directory root = new Directory("/");
        root.add(new File("readme.txt", 180));

        Directory pictures = new Directory("pictures");
        pictures.add(new File("family.jpeg", 900));
        pictures.add(new File("car.jpeg", 1024));

        Directory cats = new Directory("cats");
        cats.add(new File("cat.png", 700));
        cats.add(new File("kitty.png", 564));

        Directory dogs = new Directory("dogs");
        dogs.add(new File("dog.jpg", 800));
        dogs.add(new File("puppy.jpg", 953));

        pictures.add(cats);
        pictures.add(dogs);
        root.add(pictures);

        Directory letters = new Directory("letters");
        letters.add(new File("price.xls", 2564));
        letters.add(new File("Rent.rtf", 547));
        root.add(letters);


        printer.print(root);

        System.out.println("Remove cats folder.");

        pictures.remove(cats);
        printer.print(root);
    }
}
