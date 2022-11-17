
public class MyFirstClass {
	    public MyFirstClass() {
	    }

	    public static void main(String[] args) {
	        GenericInput<Integer> ob1 = new GenericInput();
	        ob1.setValue(67);
	        System.out.println(ob1.getValue());
	        GenericInput<String> ob2 = new GenericInput();
	        ob2.setValue("Sujata");
	        System.out.println((String)ob2.getValue());
	        GenericInput<Person> ob3 = new GenericInput();
	        ob3.setValue(new Person(111, "XYZ"));
	        System.out.println(ob3.getValue());
	    }
	}



