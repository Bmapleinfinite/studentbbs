package com.example.studentbbs.dto;

import java.util.ArrayList;
@Deprecated
public class CommonDataArrDto {
    private ArrayList<String> names;

    private ArrayList<Integer> count;

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<Integer> getCount() {
        return count;
    }

    public void setCount(ArrayList<Integer> count) {
        this.count = count;
    }
}
