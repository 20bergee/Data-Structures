package stacks;

public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBoundedStack<String> s = new ArrayBoundedStack<String>();
		String[] hello = "Hello, my name is Emily Berger. I am in Data Structures".split(" ");
		for (int x = 0; x < hello.length; x++) {
			s.push(hello[x]);
		}
		s.remove(4);
		System.out.println(s.top());
		s.clear();
		s.remove(5);
	}

}
