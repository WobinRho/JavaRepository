package Event;

import java.io.PrintStream;

import Projekt.Person;


class Zahlung {
    private Person zahlendePerson;
    private Geldbetrag geldbetrag;
    protected Zahlung(Person zahlendePerson,Geldbetrag geldbetrag) {
	this.zahlendePerson = zahlendePerson;
	this.geldbetrag = geldbetrag;
    }
    protected Geldbetrag hatBezahlt(PrintStream out, Person person) {
	if(person.equals(zahlendePerson)) {
		return geldbetrag;
	}
	return new Geldbetrag();
    }
    protected Geldbetrag mussBezahlen(PrintStream out, Person person,Geldbetrag zieheGroesseAb) {
	return geldbetrag.divBetrag(zieheGroesseAb);
    }
    protected void printBetrag(PrintStream out) {
	geldbetrag.printBetrag(out);
    }
}
