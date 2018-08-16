package Projekt;

import java.io.PrintStream;

class Name {
    private String name;
    protected Name(String name) {
	this.name = name;
    }
    protected void printName(PrintStream out) {
	out.print(name);
    }
}
