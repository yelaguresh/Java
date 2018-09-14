package trng.json.domain.parser;
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import trng.json.domain.Address;
import trng.json.domain.Employee;
 
public class JacksonStreamingReadExample {
 
    public static void main(String[] args) throws JsonParseException, IOException {
         
        //create JsonParser object
        JsonParser jsonParser = new JsonFactory().createParser(new File("C:/Users/Manohar/workspace-training-advJava/MyJSONApp/src/main/resources/employee.json"));
         
        //loop through the tokens
        Employee emp = new Employee();
        List<Address> addresses = new ArrayList<Address>();
        emp.setAddresses(addresses);
        emp.setCities(new ArrayList<String>());
        emp.setSalaryMap(new HashMap<String, Integer>());
        List<Long> phoneNums = new ArrayList<Long>();
        boolean insidePropertiesObj=false;
         
        parseJSON(jsonParser, emp, phoneNums, insidePropertiesObj);
         
        long[] nums = new long[phoneNums.size()];
        int index = 0;
        for(Long l :phoneNums){
            nums[index++] = l;
        }
        emp.setPhoneNumbers(nums);
         
        jsonParser.close();
        //print employee object
        System.out.println("Employee Object\n\n"+emp);
    }
 
    private static void parseJSON(JsonParser jsonParser, Employee emp,
            List<Long> phoneNums, boolean insidePropertiesObj) throws JsonParseException, IOException {
         
        //loop through the JsonTokens
        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
            String name = jsonParser.getCurrentName();
            if("id".equals(name)){
                jsonParser.nextToken();
                emp.setId(jsonParser.getIntValue());
            }else if("name".equals(name)){
                jsonParser.nextToken();
                emp.setName(jsonParser.getText());
            }else if("permanent".equals(name)){
                jsonParser.nextToken();
                emp.setPermanent(jsonParser.getBooleanValue());
            }else if("address".equals(name)){
                jsonParser.nextToken();
                //nested object, recursive call
                parseJSON(jsonParser, emp, phoneNums, insidePropertiesObj);
            } else if("phoneNumbers".equals(name)){
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    phoneNums.add(jsonParser.getLongValue());
                }
            }else if("role".equals(name)){
                jsonParser.nextToken();
                emp.setRole(jsonParser.getText());
            }else if("cities".equals(name)){
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    emp.getCities().add(jsonParser.getText());
                }
            }else if("properties".equals(name)){
                jsonParser.nextToken();
                while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                    String key = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    Integer value = jsonParser.getIntValue();
                    emp.getSalaryMap().put(key, value);
                }
            }
        }
    }
 
}