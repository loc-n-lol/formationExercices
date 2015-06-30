package temperature;

public class TemperatureNegativeException extends Exception {


	public TemperatureNegativeException() {
		super("Temperature Inférieure à 0 absolu");
	}

}
