package Event;
import java.io.PrintStream;
import Datum.Datum;
import Projekt.Person;
import Projekt.PersonenListe;

public class Event {
    private Zahlungsdaten eventZahlungsdaten;
    private EventDetails eventDetails;
    public Event(Person teilnehmer,Geldbetrag bezahlt, Datum datum, String eventname) {
	this.eventZahlungsdaten = new Zahlungsdaten(teilnehmer,bezahlt);
	this.eventDetails = new EventDetails(datum, new EventBeschreibung(eventname));
    }
    public void addNichtTeilgenommen(Person person) {
	eventZahlungsdaten.addNichtTeilgenommen(person);
    }
    protected Geldbetrag hatBezahlt(PrintStream out, Person person) {
	return eventZahlungsdaten.hatBezahlt(out,person);
    }
    protected Geldbetrag mussBezahlen(PrintStream out, Person person,PersonenListe projektTeilnehmer) {
	return eventZahlungsdaten.mussBezahlen(out,person,projektTeilnehmer);
    }
    protected int zieheGroesseAb(PersonenListe projektGruppe) {
	return eventZahlungsdaten.zieheNichtTeilgenommenAb(projektGruppe);
    }
    protected void printBetrag(PrintStream out) {
	eventZahlungsdaten.printBetrag(out);
    }
    protected void printWennTeilgenommen(PrintStream out, Geldbetrag tempBetrag) {
	if(tempBetrag.istNull() == false) {
	    eventDetails.printEventDetails(out);
	    tempBetrag.printBetrag(out);
	}
    }
}
