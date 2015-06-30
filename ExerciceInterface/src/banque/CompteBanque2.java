package banque;

public class CompteBanque2 implements ICompteBancaire {

	private double solde;
	private double decouvert_autorise;
	
	public CompteBanque2()
	{
		this(0);
	}
	
	public CompteBanque2(double fonds_initial)
	{
		solde = fonds_initial;
		decouvert_autorise = 1000;
	}
	
	@Override
	public boolean depot(double valeur) {
		solde += valeur;
		return true;
	}

	@Override
	public boolean retrait(double valeur) {
		if (solde + decouvert_autorise >= valeur)
		{
			solde -= valeur;
			return true;
		}
		
		return false;
	}

	@Override
	public double consultation() {
		return solde;
	}


	@Override
	public String toString() {
		return "CompteBanque2 [solde=" + solde + ", decouvert_autorise="
				+ decouvert_autorise + "]";
	}

	
	@Override
	public int compareTo(ICompteBancaire c) {

		return (this.consultation() - c.consultation() < 0 ? -1 : (this.consultation() - c.consultation() > 0 ? 1 : 0));
	}	

}
