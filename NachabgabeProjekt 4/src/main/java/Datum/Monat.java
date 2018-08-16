package Datum;

import java.io.PrintStream;

class Monat {
    private int monat;
    protected Monat(int monat) {
	this.monat = monat;
    }
    protected void printMonat(PrintStream out) {
	out.print(monat + ".");
    }
}
