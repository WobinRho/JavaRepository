package Datum;

import java.io.PrintStream;

class MonatTag {
    private Monat monat;
    private Tag tag;
    protected MonatTag(Monat monat, Tag tag) {
	this.monat = monat;
	this.tag = tag;
    }
    protected void printMonatTag(PrintStream out) {
	tag.printTag(out);
	monat.printMonat(out);
    }
}
