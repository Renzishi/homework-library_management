package model;

public class Message {
    public String name;
    public int number;
    public boolean borrowed;
    public int remain;
    public Message(String n, int num, boolean b, int r) {
        name = n;
        number = num;
        borrowed = b;
        remain = r;
    }

    public void print() {
        System.out.println(name + ' ' + number + ' ' + remain + ' ' + borrowed);
    }

    public String get() {
        return name + ' ' + number + ' ' + remain + ' ' + borrowed;
    }
}
