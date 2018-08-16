package Projekt;

import java.io.PrintStream;
public class Person {
    private Name name;
    protected Person(String name) {
	this.name = new Name(name);
    }
    protected void printName(PrintStream out) {
	name.printName(out);
    }
}
