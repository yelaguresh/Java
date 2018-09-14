package trng.generics;

public class GenericInterfaceUsage {
	public static void main(String[] args) {
		IKeyValue<String, Integer> keyValue = new KeyValue<>("Sunday", 1);
		System.out.println(" Key: " + keyValue.getKey());
		System.out.println(" Value: " + keyValue.getValue());
		
		
		IKeyValue<String, String> keyValue2 = new KeyValue<>("Sunday", "Holiday");
		System.out.println(" Key: " + keyValue2.getKey());
		System.out.println(" Value: " + keyValue2.getValue());
	}
}

interface IKeyValue <K, V> {
	K getKey();
	V getValue();
}

class KeyValue<K, V> implements IKeyValue<K, V> {

	K key;
	V value;
	
	KeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}
}