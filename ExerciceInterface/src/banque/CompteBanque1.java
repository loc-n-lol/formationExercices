package banque;

public class CompteBanque1 implements ICompteBancaire {

	private double fonds;
	
	public CompteBanque1()
	{
		fonds = 0;
	}
	
	public CompteBanque1(double fonds_initial)
	{
		fonds = fonds_initial;
	}
	
	@Override
	public boolean depot(double valeur) {
		fonds += valeur;
		return true;
	}

	@Override
	public boolean retrait(double valeur) {
		if (fonds >= valeur)
		{
			fonds -= valeur;
			return true;
		}
		
		return false;
	}

	@Override
	public double consultation() {
		return fonds;
	}

	@Override
	public String toString() {
		return "CompteBanque1 [fonds=" + fonds + "]";
	}
	


	@Override
	public int compareTo(ICompteBancaire c) {
	
		return (this.consultation() - c.consultation() < 0 ? -1 : (this.consultation() - c.consultation() > 0 ? 1 : 0));
	}	

}
