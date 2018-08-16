package Projekt;

import Datum.Datum;
import Event.Event;
import Event.Geldbetrag;
class Test {

    public static void main(String[] args) {
	Person thomas = new Person("Thomas");
	Person christoph = new Person("Christoph");
	Person markus = new Person("Markus");

	PersonenListe wgBewohner = new PersonenListe();
	wgBewohner.addPerson(thomas);
	wgBewohner.addPerson(markus);
	wgBewohner.addPerson(christoph);
	Projekt wG = new Projekt(wgBewohner,new Name("WG"));

	Geldbetrag wgMieteChristoph = new Geldbetrag(1275.80);
	Datum datumMiete1 = new Datum(1,1,2018);
	Datum datumMiete2 = new Datum(1,2,2018);
	Event mietZahlung1 = new Event(christoph,wgMieteChristoph,datumMiete1,"Miete bezahlen: ");
	Event mietZahlung2 = new Event(christoph,wgMieteChristoph,datumMiete2,"Miete bezahlen: ");

	Geldbetrag wgBierThomas = new Geldbetrag(63.80);
	Datum datumBier = new Datum(2,1,2018);
	Event bierZahlung = new Event(thomas,wgBierThomas,datumBier,"Bier bezahlen: ");
	bierZahlung.addNichtTeilgenommen(markus);

	Geldbetrag wgInternetMarkus = new Geldbetrag(29.99);
	Datum datumInternet1 = new Datum(3,1,2018);
	Event internetZahlung1 = new Event(markus,wgInternetMarkus,datumInternet1,"Internet bezahlen: ");

	Geldbetrag wgKuehlschrankThomas = new Geldbetrag(104.88);
	Datum datumKuehlschrank = new Datum(4,1,2018);
	Event kuehlschrankZahlung = new Event(thomas,wgKuehlschrankThomas,datumKuehlschrank,"Kuehlschrank fuellen: ");

	Person jessica = new Person("Jessica");
	Person sina = new Person("Sina");
	Person jens = new Person("Jens");
	Person gerd = new Person("Gerd");
	Person kathrin = new Person("Kathrin");
	Person simon = new Person("Simon");

	PersonenListe staedtereiseTeilnehmer = new PersonenListe();
	staedtereiseTeilnehmer.addPerson(jessica);
	staedtereiseTeilnehmer.addPerson(sina);
	staedtereiseTeilnehmer.addPerson(jens);
	staedtereiseTeilnehmer.addPerson(gerd);
	staedtereiseTeilnehmer.addPerson(kathrin);
	staedtereiseTeilnehmer.addPerson(thomas);
	staedtereiseTeilnehmer.addPerson(christoph);
	staedtereiseTeilnehmer.addPerson(simon);
	Projekt staedtereise = new Projekt(staedtereiseTeilnehmer,new Name("Staedtereise"));
	Datum datumStaedtereise = new Datum(30,10,2017);

	Geldbetrag rundfahrtJens = new Geldbetrag(148.0);
	Event rundfahrtZahlung = new Event(jens,rundfahrtJens,datumStaedtereise,"Rundfahrt bezahlen: ");

	Geldbetrag musicalSina = new Geldbetrag(500.0);
	Event musicalZahlungSina = new Event(sina,musicalSina,datumStaedtereise,"Musical: ");
	musicalZahlungSina.addNichtTeilgenommen(simon);
	musicalZahlungSina.addNichtTeilgenommen(thomas);
	musicalZahlungSina.addNichtTeilgenommen(jens);

	Geldbetrag musicalKathrin= new Geldbetrag(384.5);
	Event musicalZahlungKathrin = new Event(kathrin,musicalKathrin,datumStaedtereise,"Musical: ");
	musicalZahlungKathrin.addNichtTeilgenommen(simon);
	musicalZahlungKathrin.addNichtTeilgenommen(thomas);
	musicalZahlungKathrin.addNichtTeilgenommen(jens);

	Geldbetrag rundfahrtBierThomas = new Geldbetrag(66.0);
	Event bierZahlungRundfahrt = new Event(thomas,rundfahrtBierThomas,datumStaedtereise,"Bier bezahlen: ");
	bierZahlungRundfahrt.addNichtTeilgenommen(simon);

	wG.fuegeEventHinzu(mietZahlung1);
	wG.fuegeEventHinzu(internetZahlung1);
	wG.fuegeEventHinzu(bierZahlung);
	wG.fuegeEventHinzu(kuehlschrankZahlung);
	staedtereise.fuegeEventHinzu(rundfahrtZahlung);
	staedtereise.fuegeEventHinzu(musicalZahlungSina);
	staedtereise.fuegeEventHinzu(musicalZahlungKathrin);
	staedtereise.fuegeEventHinzu(bierZahlungRundfahrt);
	staedtereise.berechneUeberweisungen(System.out);

	Geldbetrag wgInternetMarkus2 = new Geldbetrag(29.99);
	Datum datumInternet2 = new Datum(3,2,2018);
	Event internetZahlung2 = new Event(markus,wgInternetMarkus2,datumInternet2,"Internet bezahlen 2: ");

	wG.berechneUeberweisungen(System.out);
	wG.fuegeEventHinzu(mietZahlung2);
	wG.fuegeEventHinzu(internetZahlung2);
	wG.berechneUeberweisungen(System.out);
    }

}
