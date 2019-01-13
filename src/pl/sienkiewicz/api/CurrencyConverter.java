package pl.sienkiewicz.api;

public interface CurrencyConverter {

	double convertEURToPLN(double amount);
	double convertPLNtoEUR(double amount);
}
