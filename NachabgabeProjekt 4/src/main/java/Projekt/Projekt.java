package Projekt;

import java.io.PrintStream;
import Event.Event;

class Projekt {
    private ProjektDaten projektDaten;
    private Name projektName;
    protected Projekt(PersonenListe projektTeilnehmer,Name projektName) {
	this.projektDaten = new ProjektDaten(projektTeilnehmer);
	this.projektName = projektName;
    }
    protected void fuegeEventHinzu(Event event) {
	projektDaten.fuegeEventHinzu(event);
    }
    protected void berechneUeberweisungen(PrintStream out) {
	out.println("Abrechnung fuer: ");
	projektName.printName(out);
	projektDaten.berechneUeberweisungen(out);
    }
}
