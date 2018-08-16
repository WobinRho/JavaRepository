package Event;
import java.io.PrintStream;
import java.util.ArrayList;
import Projekt.Person;
import Projekt.PersonenListe;

public class EventListe {
    private ArrayList<Event> events;
    public EventListe() {
	this.events = new ArrayList<Event>();
    }
    public void fuegeEventHinzu(Event event) {
	events.add(event);
    }
    public Geldbetrag berechneBetragfuerPerson(PrintStream out, Person tempPerson, PersonenListe personenListe) {
	out.println(" Hat bezahlt:");
	Geldbetrag hatBezahlt = hatBezahlt(out,tempPerson);
	out.println();
	out.println(" Muss zahlen:");
	Geldbetrag  mussBezahlen = mussBezahlen(out,tempPerson,personenListe);
	mussBezahlen = hatBezahlt.subBetrag(mussBezahlen);
	out.println();
	return mussBezahlen;
    }
    private Geldbetrag hatBezahlt(PrintStream out, Person person) {
	Geldbetrag hatBezahlt = new Geldbetrag();
	Geldbetrag tempBetrag;
	for(int i = 0;i<events.size();i++) {
	    Event tempEvent = events.get(i);
	    tempBetrag = tempEvent.hatBezahlt(out,person);
	    tempEvent.printWennTeilgenommen(out, tempBetrag);
	    hatBezahlt = hatBezahlt.addBetrag(tempBetrag);
	}
	return hatBezahlt;
    }
    private Geldbetrag mussBezahlen(PrintStream out, Person person,PersonenListe projektTeilnehmer) {
	Geldbetrag mussBezahlen = new Geldbetrag();
	Geldbetrag tempBetrag;
	for(int i = 0;i<events.size();i++) {
	    Event tempEvent = events.get(i);
	    tempBetrag = tempEvent.mussBezahlen(out,person,projektTeilnehmer);
	    tempEvent.printWennTeilgenommen(out, tempBetrag);
	    mussBezahlen = mussBezahlen.addBetrag(tempBetrag);
	}
	return mussBezahlen;
    }
}
