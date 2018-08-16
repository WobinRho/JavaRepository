package Projekt;

import java.io.PrintStream;

import Event.Event;
import Event.EventListe;

class ProjektDaten {
    private PersonenListe projektTeilnehmer;
    private EventListe events;
    protected ProjektDaten(PersonenListe projektTeilnehmer) {
	this.projektTeilnehmer = projektTeilnehmer;
	this.events = new EventListe();
    }
    protected void fuegeEventHinzu(Event event) {
	events.fuegeEventHinzu(event);
    }
    protected void berechneUeberweisungen(PrintStream out) {
	BetragListe betragListe = projektTeilnehmer.berechneBetragsListe(out,events);
	betragListe.berechneUeberweisungen(out,projektTeilnehmer);
	loescheAlles();
    }
    protected void loescheAlles() {
	this.events = new EventListe();
    }
}
