package com.cyc.collectyourcollections.data;

import java.time.LocalDate;

public abstract class Creator {
    private final String name;

    public Creator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
