package temperature;

public class TemperatureNegativeException extends Exception {


	public TemperatureNegativeException() {
		super("Temperature Inf�rieure � 0 absolu");
	}

}
