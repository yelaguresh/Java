package trng.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		java.util.Properties properties = new Properties();
		InputStream inStream = PropertiesTest.class.getResourceAsStream("/Resource.properties");
		properties.load(inStream);
		System.out.println(properties.getProperty("user.name"));
		System.out.println(properties.getProperty("user.password"));
	}

}
