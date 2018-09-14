package trng.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class LocaleExample {
	public static void main(String[] args) {
//		buildingLocale();
		localSensitiveAPIs();
	}
	
	public static void buildingLocale() {
		Locale[] availableLocales = Locale.getAvailableLocales();
		for(Locale availableLocale: availableLocales)
			System.out.println("availableLocales: " + availableLocale);
		
		// Creates a locale object using one parameter to constructor
		Locale locale = new Locale("fr");
		System.out.println("locale: " + locale);

		// Create a locale object using two parameters constructor
		Locale locale2 = new Locale("fr", "CANADA");
		System.out.println("locale2: " + locale2);

		// Create a locale object using three parameters constructor
		Locale locale3 = new Locale("no", "NORWAY", "NY");
		System.out.println("locale3: " + locale3);

		// A local object from Locale.Builder
		Locale localeFromBuilder = new Locale.Builder().setLanguage("en").setRegion("GB").build();
		System.out.println("localeFromBuilder: " + localeFromBuilder);

		// Locale from forLanguageTag method
		Locale forLangLocale = Locale.forLanguageTag("en-GB");
		System.out.println("forLangLocale: " + forLangLocale);

		// Using Locale Contant
		Locale localeCosnt = Locale.FRANCE;
		System.out.println("localeCosnt: " + localeCosnt);
	}
	
	private static void localSensitiveAPIs() {

		long number = 5000000L;
		
		NumberFormat numberFormatDefault = NumberFormat.getInstance();
		System.out.println("Number Format using Default Locale: "+numberFormatDefault.format(number));
		
		NumberFormat numberFormatLocale = NumberFormat.getInstance(Locale.ITALY);
		System.out.println("Number Format using ITALY Locale: "+numberFormatLocale.format(number));
		
		NumberFormat numberFormatDefaultCurrency = NumberFormat.getCurrencyInstance();
		System.out.println("Currency Format using Default Locale: "+numberFormatDefaultCurrency.format(number));
		
		NumberFormat numberFormatLocaleCurrency = NumberFormat.getCurrencyInstance(Locale.ITALY);
		System.out.println("Currency Format using ITALY Locale: "+numberFormatLocaleCurrency.format(number));
		
		Currency currency = Currency.getInstance(Locale.CHINA);
		System.out.println(currency.getDisplayName()+" ("+currency.getCurrencyCode()+") "+currency.getDisplayName());
		
		Date currentDate = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
		System.out.println("Date Format in German Locale: "+dateFormat.format(currentDate));		
	}
}
