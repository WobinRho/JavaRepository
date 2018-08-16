package Event;

import java.io.PrintStream;

import Datum.Datum;

class EventDetails {
    private Datum datum;
    private EventBeschreibung eventname;
    protected EventDetails(Datum datum, EventBeschreibung eventname) {
	this.datum = datum;
	this.eventname = eventname;
    }
    protected void printEventDetails(PrintStream out) {
	eventname.printEventBeschreibung(out);
	out.print(" am: ");
	datum.printDatum(out);
    }
}
