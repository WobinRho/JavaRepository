package Projekt;
import java.io.PrintStream;
import java.util.ArrayList;

import Event.EventListe;
import Event.Geldbetrag;

public class PersonenListe {
    private ArrayList<Person> personenListe;
    public PersonenListe() {
	this.personenListe= new ArrayList<Person>();
    }
    public void addPerson(Person person) {
	personenListe.add(person);
    }
    protected BetragListe berechneBetragsListe(PrintStream out, EventListe events) {
	BetragListe betragListe = new BetragListe();
	Person tempPerson;
	Geldbetrag tempBetrag;
	out.println();
	for(int i = 0;i<personenListe.size();i++) {
	    tempPerson = personenListe.get(i);
	    tempPerson.printName(out);
	    tempBetrag = events.berechneBetragfuerPerson(out,tempPerson,this);
	    betragListe.fuegeBetragHinzu(tempBetrag);
	}
	return betragListe;
    }
    public boolean beinhaltetPerson(Person person) {
	return personenListe.contains(person);
    }
    public void printNameAnIndex(PrintStream out, int j) {
	personenListe.get(j).printName(out);

    }
    public int zieheGroesseAb(PersonenListe nichtTeilgenommen) {
	return personenListe.size() - nichtTeilgenommen.personenListe.size();
    }
    public void printBekommtVon(PrintStream out, int index1, int index2) {
	this.printNameAnIndex(out,index1);
	out.print(" bekommt von ");
	this.printNameAnIndex(out,index2);
	out.println(" : ");
    }
    public void remove(int index2) {
	personenListe.remove(index2);
    }
    public PersonenListe klon() {
	PersonenListe klon = new PersonenListe();
	for(Person i : personenListe) klon.addPerson(i);
	return klon;
    }
}