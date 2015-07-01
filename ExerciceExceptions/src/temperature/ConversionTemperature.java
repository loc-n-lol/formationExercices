package temperature;

public class ConversionTemperature {

	public static boolean debug = false;
	
	public static final int uniteKelvin = 0;
	public static final int uniteCelsius = 1;
	public static final int uniteFahrenheit = 2;
	
	public static double conversionGenerale(double valeur, int unit1, int unit2) throws TemperatureNegativeException
	{
		double valRet = valeur;
		
		switch (unit1)
		{
		case ConversionTemperature.uniteKelvin:
			switch (unit2)
			{
				case ConversionTemperature.uniteKelvin:
					valRet = valeur; break;
				case ConversionTemperature.uniteCelsius:
					valRet = kelvin2Celsius(valeur); break;
				case ConversionTemperature.uniteFahrenheit:
					valRet = kelvin2Fahrenheit(valeur); break;
			}
			break;
		case ConversionTemperature.uniteCelsius:
			switch (unit2)
			{
				case ConversionTemperature.uniteKelvin:
					valRet = celsius2Kelvin(valeur); break;
				case ConversionTemperature.uniteCelsius:
					valRet = valeur; break;
				case ConversionTemperature.uniteFahrenheit:
					valRet = celsius2Fahrenheit(valeur); break;
			}
			break;
		case ConversionTemperature.uniteFahrenheit:
			switch (unit2)
			{
				case ConversionTemperature.uniteKelvin:
					valRet = fahreneit2Kelvin(valeur); break;
				case ConversionTemperature.uniteCelsius:
					valRet = fahreneit2Celsius(valeur); break;
				case ConversionTemperature.uniteFahrenheit:
					valRet = valeur; break;
			}
			break;
		}
		
		return valRet;
	}
	
	public static double celsius2Kelvin(double celsius) throws TemperatureNegativeException
	{
		if (debug)
			System.out.println("celsius2Kelvin" + celsius);
		double ret = celsius+273.15;
		if (ret < 0)
			throw new TemperatureNegativeException();
		return ret;
	}
	
	public static double kelvin2Celsius(double kelvin) throws TemperatureNegativeException
	{
		if (debug)
			System.out.println("kelvin2Celsius" + kelvin);
		if (kelvin < 0)
			throw new TemperatureNegativeException();
		
		double ret = kelvin-273.15;
		return ret;
	}
	
	public static double celsius2Fahrenheit(double celsius) throws TemperatureNegativeException
	{
		if (debug)
			System.out.println("celsius2Fahreneit" + celsius);
		celsius2Kelvin(celsius) ;
		
		double ret = celsius*1.8 + 32;
		return ret;
	}
	
	public static double fahreneit2Celsius(double fahrenheit) throws TemperatureNegativeException
	{
		if (debug)
			System.out.println("fahreneit2Celsius" + fahrenheit);
		double ret = (fahrenheit-32)/1.8;
		celsius2Kelvin(ret) ;
		return ret;
	}
	
	public static double kelvin2Fahrenheit(double kelvin) throws TemperatureNegativeException
	{
		if (debug)
			System.out.println("kelvin2Fahreneit" + kelvin);
		double ret = celsius2Fahrenheit(kelvin2Celsius(kelvin));
		return ret;
	}
	
	public static double fahreneit2Kelvin(double fahrenheit) throws TemperatureNegativeException
	{
		if (debug)
			System.out.println("fahreneit2Kelvin" + fahrenheit);
		double ret = celsius2Kelvin(fahreneit2Celsius(fahrenheit));
		return ret;
	}
	
}
