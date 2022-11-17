public class MySecondDemo {
	  public MySecondDemo() {
	    }

	    public static void main(String[] args) {
	        int i = 10;
	        int j = 20;
	        if (i == j) {
	            System.out.println("i and j are same");
	        } else {
	            System.out.println("i and j are not same");
	        }

	        Person p1 = new Person(101, "QWERTY");
	        Person p2 = new Person(101, "QWERTY");
	        if (p1 == p2) {
	            System.out.println("p1 and p2 are same");
	        } else {
	            System.out.println("p1 and p2 are not same");
	        }

	        if (p1 == p1) {
	            System.out.println("p3 and p1 are same");
	        } else {
	            System.out.println("p3 and p1 are not same");
	        }

	        if (p1.equals(p2)) {
	            System.out.println("p1 and p2 are same");
	        } else {
	            System.out.println("p1 and p2 are not same");
	        }

	        System.out.println("p1 hashcode : " + p1.hashCode());
	        System.out.println("p2 hashcode : " + p2.hashCode());
	    }
}
