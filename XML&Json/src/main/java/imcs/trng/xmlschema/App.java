package imcs.trng.xmlschema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class App {
	private static String FILE_PATH = "C:\\Users\\yelag\\eclipse-workspace\\xmlschema\\src\\resources\\customer.json";
	private static String FILE_PATH1="C:\\Users\\yelag\\eclipse-workspace\\xmlschema\\src\\resources\\outputfile.xml";
	public static void main(String[] args) throws ParseException, DatatypeConfigurationException, JAXBException, JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		marshal();
		unmarshal();
		serialize();
		deserialize();
}

	private static void serialize() throws JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
			Customer customer=createCustomer();
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			objectMapper.writeValue(System.out, customer);
	        objectMapper.writeValue(new PrintWriter(FILE_PATH), customer);
		} catch (ParseException | DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	}  
        public static void deserialize() throws IOException {
        	try {
            byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
            ObjectMapper objectMapper = new ObjectMapper();
            Customer customer = objectMapper.readValue(jsonData, Customer.class);
            System.out.println("Customer Object\n"+customer.toString());
        }
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
	private static void unmarshal() throws JAXBException {
		File file = new File(FILE_PATH1);
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		System.out.println("unmarshall\n"+customer.toString());
	}

	private static void marshal() throws ParseException, DatatypeConfigurationException {
		try {
			File file = new File(FILE_PATH1);
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Customer customer = createCustomer();
			jaxbMarshaller.marshal(customer, file);
			}
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Customer createCustomer() throws ParseException, DatatypeConfigurationException {
		Customer customer=new Customer();
		PaymentType paymentType=new PaymentType();
		Address address=new Address();
		XMLGregorianCalendar DateFrom=stringToXMLGregorianCalendar("2012-10-15T00:00:00");
		XMLGregorianCalendar ToFrom=stringToXMLGregorianCalendar("2018-10-15T00:00:00");
		XMLGregorianCalendar bday=stringToXMLGregorianCalendar("1989-10-15T00:00:00");
		paymentType.setCardNumber("12345");
		paymentType.setCardName("Visa");
		paymentType.setCardtype("Creditcard");
		paymentType.setDateFrom(DateFrom);
		paymentType.setDateTo(ToFrom);
		address.setAptNo("1");
		address.setCity("Irving");
		address.setState("Texas");
		address.setCountry("USA");
		address.setZip("45420");
		customer.setId(1);
		customer.setName("Yelgu");
		customer.setDob(bday);
		customer.setAddress(address);
		customer.setPaymentInfo(paymentType);
		return customer;
	}
	public static XMLGregorianCalendar stringToXMLGregorianCalendar(String s) 
		     throws ParseException, 
		            DatatypeConfigurationException
		 {
		 XMLGregorianCalendar result = null;
		 Date date;
		 SimpleDateFormat simpleDateFormat;
		 GregorianCalendar gregorianCalendar;
		 
		 simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		                date = simpleDateFormat.parse(s);        
		                gregorianCalendar = 
		                    (GregorianCalendar)GregorianCalendar.getInstance();
		                gregorianCalendar.setTime(date);
		                result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		                return result;
		 }
}