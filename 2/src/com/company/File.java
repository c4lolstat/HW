package com.company;

/**
 * Created by Zoltan_Biro on 6/7/2017.
 */
public class File implements FSEntity {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int size() {
        return size;
    }
}
