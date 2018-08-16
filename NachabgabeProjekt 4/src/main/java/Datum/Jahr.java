package Datum;

import java.io.PrintStream;

class Jahr {
    private int jahr;
    protected Jahr(int jahr) {
	this.jahr = jahr;
    }
    protected void printJahr(PrintStream out) {
	out.println(jahr);
    }
}
