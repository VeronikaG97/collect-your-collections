package com.cyc.collectyourcollections.data;

import java.time.LocalDate;

public abstract class Creator {
    private final String name;
    private final LocalDate birthday;
    private final String profession;

    public Creator(String name, LocalDate birthday, String profession) {
        this.name = name;
        this.birthday = birthday;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getProfession() {
        return profession;
    }
}
