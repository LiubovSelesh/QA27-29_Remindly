package com.telran.remindly.model;

public class Reminder {
    private  String title;
    private  String type;
    private  int number;
    private  String month;
    private  int index;
    private  String type1;
    private  String year;
    private  String td;
    private  int x;
    private  int y;
    private  String repeat;
    private  double start;
    private  double stop;
    private  String type2;

    public Reminder setTitle(String title) {
        this.title = title;
        return this;
    }

    public Reminder setType(String type) {
        this.type = type;
        return this;
    }

    public Reminder setNumber(int number) {
        this.number = number;
        return this;
    }

    public Reminder setMonth(String month) {
        this.month = month;
        return this;
    }

    public Reminder setIndex(int index) {
        this.index = index;
        return this;
    }

    public Reminder setType1(String type1) {
        this.type1 = type1;
        return this;
    }

    public Reminder setYear(String year) {
        this.year = year;
        return this;
    }

    public Reminder setTd(String td) {
        this.td = td;
        return this;
    }

    public Reminder setX(int x) {
        this.x = x;
        return this;
    }

    public Reminder setY(int y) {
        this.y = y;
        return this;
    }

    public Reminder setRepeat(String repeat) {
        this.repeat = repeat;
        return this;
    }

    public Reminder setStart(double start) {
        this.start = start;
        return this;
    }

    public Reminder setStop(double stop) {
        this.stop = stop;
        return this;
    }

    public Reminder setType2(String type2) {
        this.type2 = type2;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public String getMonth() {
        return month;
    }

    public int getIndex() {
        return index;
    }

    public String getType1() {
        return type1;
    }

    public String getYear() {
        return year;
    }

    public String getTd() {
        return td;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getRepeat() {
        return repeat;
    }

    public double getStart() {
        return start;
    }

    public double getStop() {
        return stop;
    }

    public String getType2() {
        return type2;
    }
}
