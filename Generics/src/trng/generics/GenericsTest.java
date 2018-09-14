package trng.generics;

public class GenericsTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		MyValue<String> myValue = new MyValue<String>();
		myValue.setValue("Raj");
//		myValue.setValue(100); //Invalid.
		System.out.println(myValue.getValue());
		
		MyValue<Integer> myIntValue = new MyValue<Integer>();
		myIntValue.setValue(100);
		System.out.println(myIntValue.getValue());
		
		//Diamond operator is possible  from jdk 7
		MyValue<Character> myCharValue = new MyValue<>();
		myCharValue.setValue('C');
		System.out.println(myCharValue.getValue());
		
		//Without specifying the type.
		MyValue value = new MyValue();
		value.setValue("Genric value");
		value.setValue(12);
	}
}

class MyValue <T> {
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
