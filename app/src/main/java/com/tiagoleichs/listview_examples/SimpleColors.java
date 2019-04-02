package com.tiagoleichs.listview_examples;

public class SimpleColors {

    public String label;
    public ColorValues color;

    public enum ColorValues {
        RED, BLUE, GREEN
    }

    public SimpleColors(String label, ColorValues color) {
        super();
        this.label = label;
        this.color = color;
    }


}
