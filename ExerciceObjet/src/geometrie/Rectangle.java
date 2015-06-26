package geometrie;

public class Rectangle {

	private int x1, x2, y1, y2;
	
	public Rectangle(int x1, int y1, int longueur, int hauteur)
	{
		this.x1=x1;
		this.x2=x1+longueur;
		this.y1=y1;
		this.y2=y1+hauteur;
		ordonner();
	}
	
	public Rectangle (Rectangle r)
	{
		this.x1=r.x1;
		this.x2=r.x2;
		this.y1=r.y1;
		this.y2=r.y2;
		ordonner();
	}
	

	public int getAire(){
		return (x2-x1)*(y2-y1);
	}
	
	public String toString()
	{		
		StringBuilder sb = new StringBuilder();
		
		for (int y = 0 ; y < y1 ; y++)
		{
			sb.append('\n');
		}
		for (int y = y1 ; y < y2 ; y++)
		{
			for (int x = 0 ; x < x1 ; x++)
				sb.append(' ');
			
			for (int x = x1 ; x < x2 ; x++)
				sb.append('#');
			
			sb.append('\n');
		}
		return sb.toString();
	}
	
	public void deplacer(int x, int y)
	{
		this.x1 += x;
		this.x2 += x;
		this.y1 += y;
		this.y2 += y;
	}
	
	
	public static boolean collision(Rectangle r1, Rectangle r2)
	{
		return (r1.coinDansRectangle(r2) || r2.coinDansRectangle(r1));
	}
	
	//Le rectangle en paramètre a-t-il un coin à l'intérieur de moi
	public boolean coinDansRectangle(Rectangle r)
	{
		return (pointDansRectangle(r.getX1(), r.getY1()) ||
				pointDansRectangle(r.getX1(), r.getY2()) ||
				pointDansRectangle(r.getX2(), r.getY2()) ||
				pointDansRectangle(r.getX2(), r.getY1())
				);
	}
	
	//Le point de coordonnées x,y est t-il à l'interieur de moi
	public boolean pointDansRectangle(int x, int y)
	{
		ordonner();
		return (x >= x1 && x <= x2 && y >= y1 && y <= y2);
	}
	
	//Faire en sorte que x1 < x2 et y1 < y2
	private void ordonner()
	{
		int x, y;
		
		if (x1 > x2)
		{
			x = x1;
			x1 = x2;
			x2 = x;				
		}
		
		if (y1 > y2)
		{
			y = y1;
			y1 = y2;
			y2 = y;	
		}
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
}
