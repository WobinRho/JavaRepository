package Projekt;
import java.io.PrintStream;
import java.util.ArrayList;
import Event.Geldbetrag;
class BetragListe {
    private ArrayList<Geldbetrag> betragListe;
    protected BetragListe() {
	this.betragListe = new ArrayList<Geldbetrag>();
    }
    protected void fuegeBetragHinzu(Geldbetrag betrag) {
	betragListe.add(betrag);
    }
    protected void berechneUeberweisungen(PrintStream out, PersonenListe projektTeilnehmer) {
	PersonenListe projektTeilnehmerKlon = projektTeilnehmer.klon();
	Inidizies indizies = new Inidizies(this);
	while(indizies.nichtAmEnde()) {
	    indizies.fuehreBerechnungAus(out, projektTeilnehmerKlon, this);
	}
    }
    protected void fuehreBerechnungAus(PrintStream out, PersonenListe projektTeilnehmerKlon, int index1, int index2) {
	betragListe.get(index2).printBetrag(out);
	betragListe.set(index1, betragListe.get(index1).addBetrag(betragListe.get(index2)));
	projektTeilnehmerKlon.remove(index2);
	betragListe.remove(index2);
    }
    protected boolean vergleicheBetraege(int index1, int index2) {
	if(betragListe.get(index1).groesserNegativBetrag(betragListe.get(index2)) || index2 == -1) return true;
	return false;
    }
    protected int findePersonBekommtGeld() {
	for(int i = 0;i<betragListe.size(); i++) if(betragListe.get(i).groesserNegativBetrag(new Geldbetrag(0))) return i;
	return -1;
    }
    protected int findePersonGibtGeld() {
	for(int i = 0;i<betragListe.size(); i++) if((new Geldbetrag(0)).groesserNegativBetrag(betragListe.get(i)) == false) return i;
	return -1;
    }
}