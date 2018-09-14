package trng.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {
	public static void main(String[] args) {
		String baseName = "trng.util.messages";
		
		// en_US
		System.out.println("Current Locale: " + Locale.getDefault());
		ResourceBundle mybundle = ResourceBundle.getBundle(baseName);

		// read MyLabels_en_US.properties
		System.out.println("Say how are you in US English: " + mybundle.getString("greeting.msg"));

		//Locale.setDefault(new Locale("ms", "MY"));
		Locale malaysiaLocale = new Locale("ms", "MY");

		// read MyLabels_ms_MY.properties
		System.out.println("malysiaLocale : " + malaysiaLocale);
		mybundle = ResourceBundle.getBundle(baseName, malaysiaLocale);
		System.out.println("Say how are you in Malaysian Malaya language: " + mybundle.getString("greeting.msg"));
	}
}
