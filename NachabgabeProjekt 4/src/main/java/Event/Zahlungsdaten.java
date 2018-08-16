package Event;

import java.io.PrintStream;

import Projekt.Person;
import Projekt.PersonenListe;

class Zahlungsdaten {
    private Zahlung zahlung;
    private PersonenListe nichtTeilgenommen;
    public Zahlungsdaten(Person zahler, Geldbetrag bezahlt) {
	this.zahlung = new Zahlung(zahler,bezahlt);
	this.nichtTeilgenommen = new PersonenListe();
    }
    public void addNichtTeilgenommen(Person person) {
	nichtTeilgenommen.addPerson(person);
    }
    public Geldbetrag hatBezahlt(PrintStream out, Person person) {
	return zahlung.hatBezahlt(out,person);
    }
    public Geldbetrag mussBezahlen(PrintStream out, Person person,PersonenListe projektTeilnehmer) {
	if(nichtTeilgenommen.beinhaltetPerson(person)) {
	    return new Geldbetrag();
	}
	return zahlung.mussBezahlen(out,person,new Geldbetrag(zieheNichtTeilgenommenAb(projektTeilnehmer)));
    }
    protected int zieheNichtTeilgenommenAb(PersonenListe projektGruppe) {
	return projektGruppe.zieheGroesseAb(nichtTeilgenommen);
    }
    protected void printBetrag(PrintStream out) {
	zahlung.printBetrag(out);
    }
}
