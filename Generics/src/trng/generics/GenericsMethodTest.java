package trng.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsMethodTest {
	public static void main(String[] args) {
		IKeyValue<String, Integer> kv1 = new KeyValue<>("Sunday", 2);
		IKeyValue<String, Integer> kv2 = new KeyValue<>("Sunday", 2);
		
		boolean result = Util.compare(kv1, kv2);
		System.out.println("Result is: " + result);
		
		kv2 = new KeyValue<>("Monday", 2);
		result = Util.compare(kv1, kv2);
		System.out.println("Result is: " + result);
		
		List<IKeyValue<String, Integer>> iKeyValues = new ArrayList<>();
		iKeyValues.add(kv1);
		IKeyValue<String, Integer> resultVal = Util.find(iKeyValues, "Sunday");
		System.out.println("Value is: " + resultVal.getValue());
		
		
	}
}


class Util {
    public static <K, V> boolean compare(IKeyValue<K, V> p1, IKeyValue<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
        p1.getValue().equals(p2.getValue());
    }
    
    public static <K, V> IKeyValue<K, V> find(List<IKeyValue<K, V>> items, K key) {
        for (IKeyValue<K, V> iKeyValue : items) {
        	if (key.equals(iKeyValue.getKey())) {
        		return iKeyValue;
        	}
		}
        
        return null;
    }
    
    public static <T> void display(YourValue<T> value) {
    	System.out.println(value.toString());
    }
    
    public static <TT> void display(TT x) {
    	System.out.println(x.toString());
    }

}

class YourValue<T> {
	private T value;
	
	public T get() {
		return value;
	}
	
	public void set(T value) {
		this.value = value;;
	}
}