package trng.json.domain.parser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import trng.json.domain.Address;
import trng.json.domain.Employee;
 
 
public class JacksonObjectMapperExample {
 
	private static String FILE_PATH = "C:\\Manohar\\workspace-training-advJava\\MyJSONApp\\src\\main\\resources\\employee.json";
	
    public static void main(String[] args) throws IOException {
//    	serialize();
//    	deserialize();
//    	deserializeToMap();
//        readNode();
		updateAndWriteToNewFile();
    }
    

	private static void serialize() throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //convert Object to json string
        Employee emp = createEmployee();
        
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
         
        //writing to console, can write to any output stream such as file
        objectMapper.writeValue(System.out, emp);
        objectMapper.writeValue(new PrintWriter("c:\\temp\\myjsondata.json"), emp);
	}

	public static void deserialize() throws IOException {
         
        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
         
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
         
        //convert json string to object
        Employee emp = objectMapper.readValue(jsonData, Employee.class);
         
        System.out.println("Employee Object\n"+emp);
    }

    private static void deserializeToMap() throws JsonParseException, JsonMappingException, IOException {
    	byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
    	ObjectMapper objectMapper = new ObjectMapper();
    	
        //Read JSON data into HashMap
        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap = objectMapper.readValue(jsonData, HashMap.class);
        System.out.println("Map is: "+ myMap);
	}
	
    
    private static void updateAndWriteToNewFile() throws JsonGenerationException, JsonMappingException, IOException {
    	//create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        
        //read JSON like DOM Parser
		System.out.println("Enter json file path");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine(); 
    	byte[] jsonData = Files.readAllBytes(Paths.get(path));
        JsonNode rootNode = objectMapper.readTree(jsonData);
        
        System.out.println("Enter json elment to update");
        String jsonElementName = scanner.nextLine();
        
		JsonNode elementData = rootNode.path(jsonElementName);
		if (elementData == null) {
			System.err.println("no elment exist with given element : " + jsonElementName);
			System.exit(1);
		}
		
    	//update JSON data
    	((ObjectNode) rootNode).put(jsonElementName, 500);
    	
    	//add new key value
    	System.out.println("Enter json element to add");
        jsonElementName = scanner.nextLine();
        
        System.out.println("Enter its value");
        String elementDataValue = scanner.nextLine();
        
    	((ObjectNode) rootNode).put(jsonElementName, elementDataValue);
    	
    	//remove existing key
    	System.out.println("Enter json element to remove");
        jsonElementName = scanner.nextLine();
    	((ObjectNode) rootNode).remove(jsonElementName);
    	
    	File file = new File("updated_emp.txt");
    	objectMapper.writeValue(file, rootNode);
	}


	private static Employee createEmployee() {
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("David");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[] { 123456, 987654 });
        emp.setRole("Manager");
 
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setCity("Bangalore");
        address.setStreet("BTM 1st Stage");
        address.setZipcode(560100);
        addresses.add(address);
        emp.setAddresses(addresses);
 
        List<String> cities = new ArrayList<String>();
        cities.add("Los Angeles");
        cities.add("New York");
        emp.setCities(cities);
 
        Map<String, Integer> salaryMap = new HashMap<String, Integer>();
        salaryMap.put("basic", 1000);
        salaryMap.put("gross", 1250);
        emp.setSalaryMap(salaryMap);
 
        return emp;
    }
	
	private static void readNode() throws JsonProcessingException, IOException {
        //read JSON like DOM Parser
		System.out.println("Enter json file path");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine(); 
    	byte[] jsonData = Files.readAllBytes(Paths.get(path));
    	ObjectMapper objectMapper = new ObjectMapper();		
        JsonNode rootNode = objectMapper.readTree(jsonData);
        System.out.println("Enter json elment to find");
        String jsonElementName = scanner.nextLine();
		JsonNode jsonNodes = rootNode.path(jsonElementName);
		Iterator<JsonNode> elements = jsonNodes.elements();
		while(elements.hasNext()) {
		    JsonNode jsonElement = elements.next();
		    System.out.println("Data is = " + jsonElement.asText());
		}
	}
 
}