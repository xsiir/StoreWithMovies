package pl.sienkiewicz.services;

import org.springframework.stereotype.Service;

import pl.sienkiewicz.api.CurrencyConverter;

@Service
public class BuiltInConverter implements CurrencyConverter {

	@Override
	public double convertEURToPLN(double amount) {
		return Math.round(amount * 4.20);
	}

	@Override
	public double convertPLNtoEUR(double amount) {
		return Math.round(amount/4.20);
	}

}
