package Datum;

import java.io.PrintStream;

class Tag {
    private int tag;
    protected Tag(int tag) {
	this.tag = tag;
    }
    protected void printTag(PrintStream out) {
	out.print(tag + ".");
    }
}
