package Event;

import java.io.PrintStream;

class EventBeschreibung {
    private String beschreibung;
    protected EventBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
    }
    protected void printEventBeschreibung(PrintStream out) {
	out.print(beschreibung);
    }
}
