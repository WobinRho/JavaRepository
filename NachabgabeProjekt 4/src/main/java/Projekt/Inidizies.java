package Projekt;

import java.io.PrintStream;

class Inidizies {
    private int index1;
    private int index2;
    protected Inidizies(BetragListe betragListe) {
	index1 = betragListe.findePersonBekommtGeld();
	index1 = betragListe.findePersonGibtGeld();
    }
    protected void fuehreBerechnungAus(PrintStream out,PersonenListe projektTeilnehmerKlon,BetragListe betragListe) {
	if(betragListe.vergleicheBetraege(index1,index2)) {
	    projektTeilnehmerKlon.printBekommtVon(out, index1, index2);
	    betragListe.fuehreBerechnungAus(out,projektTeilnehmerKlon,index1,index2);
	}
	erneuereIndizies(betragListe);
	if(betragListe.vergleicheBetraege(index1,index2) == false) {
	    projektTeilnehmerKlon.printBekommtVon(out, index1, index2);
	    betragListe.fuehreBerechnungAus(out,projektTeilnehmerKlon,index2,index1);
	}
	erneuereIndizies(betragListe);
    }
    protected void erneuereIndizies(BetragListe betragListe) {
	index1 = betragListe.findePersonBekommtGeld();
	index2 = betragListe.findePersonGibtGeld();
    }
    protected boolean vergleicheBetraege(BetragListe betragListe) {
	return betragListe.vergleicheBetraege(index1,index2);
    }
    protected boolean nichtAmEnde() {
	return index1 != -1 && index2 != -1;
    }
}
