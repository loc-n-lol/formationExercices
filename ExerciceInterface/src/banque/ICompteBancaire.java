package banque;

public interface ICompteBancaire extends Comparable<ICompteBancaire> {

	boolean depot(double valeur);
	boolean retrait(double valeur);
	double consultation();
	//boolean transfert(double valeur, ICompteBancaire autreCompte);
}
