package Datum;

import java.io.PrintStream;

public class Datum {
    MonatTag monatTag;
    Jahr jahr;
    public Datum(int tag,int monat, int jahr) {
	this.monatTag = new MonatTag(new Monat(monat),new Tag(tag));
	this.jahr = new Jahr(jahr);
    }
    public void printDatum(PrintStream out) {
	monatTag.printMonatTag(out);
	jahr.printJahr(out);
    }
}
