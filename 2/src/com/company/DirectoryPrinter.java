package com.company;

/**
 * Created by Zoltan_Biro on 6/7/2017.
 */
public class DirectoryPrinter {
    public void print(Directory directory) {
        print(directory, "");
    }

    private void print(Directory directory, String offset) {
        directory.getSiblings().forEach(entity -> {
            System.out.println(offset + entity.name() + " " + entity.size() + "kB" + " ");
            if (entity instanceof Directory) {
                print((Directory) entity, offset + "  ");
            }
        });
    }
}
