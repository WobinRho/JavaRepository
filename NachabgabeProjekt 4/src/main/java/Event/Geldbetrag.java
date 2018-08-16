package Event;

import java.io.PrintStream;

public class Geldbetrag {
    private double betrag;
    protected Geldbetrag() {
	this.betrag = 0;
    }
    public Geldbetrag(double startbetrag) {
	this.betrag = startbetrag;
    }
    private void round() {
	this.betrag = Math.round((betrag*100.0))/100.0;
    }
    protected Geldbetrag divBetrag(Geldbetrag betrag) {
	return new Geldbetrag(this.betrag / betrag.betrag);
    }
    protected boolean istNull() {
	this.round();
	return betrag == 0.0;
    }
    public boolean groesserNegativBetrag(Geldbetrag tempBetrag2) {
	this.round();
	tempBetrag2.round();
	return betrag >= -tempBetrag2.betrag;
    }
    public void printBetrag(PrintStream out) {
	this.round();
	if(betrag <= 0)	out.println(-betrag);
	if(betrag>0) out.println(betrag);
    }
    public Geldbetrag subBetrag(Geldbetrag betrag) {
	return new Geldbetrag(this.betrag - betrag.betrag);
    }
    public Geldbetrag addBetrag(Geldbetrag betrag) {
	return new Geldbetrag(this.betrag + betrag.betrag);
    }
}
