package characteristic;

public class GenericParadigmTest {

	public static void main(String[] args) {

		Box<String> name = new Box<String>("corn");
		Box<Integer> age = new Box<Integer>(712);

		System.out.println("name class:" + name.data.getClass().getName());
		System.out.println("age class:" + age.data.getClass().getName());
		System.out.println(name.getClass() == age.getClass());

	}

}

class Box<T> {

	public T data;

	public Box() {

	}

	public Box(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}