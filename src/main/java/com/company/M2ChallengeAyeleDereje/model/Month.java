package com.company.M2ChallengeAyeleDereje.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;

public class Month {
   @NotEmpty(message = "You must supply a number")
    private int monthNumber;
    @NotEmpty(message = "You must supply a month")
    private String name;

    public Month() {}

    public Month(String name, int monthNumber) {
        this.name = name;
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return monthNumber == month.monthNumber && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthNumber, name);
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthNumber=" + monthNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
