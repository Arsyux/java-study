package chap10_Generic;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Sample08_LimitedGenericMethod4 {

	public static void main(String[] args) {
		Group<Animal> animalGroup = new Group<>();
		animalGroup.add(new Animal("토끼"));
		animalGroup.add(new Animal("호랑이"));
		
		Group<Pet> petGroup = new Group<>();
		petGroup.add(new Pet("앵무새"));
		petGroup.add(new Pet("십자매"));
		
		Group<Wild> wildGroup = new Group<>();
		wildGroup.add(new Wild("까치"));
		wildGroup.add(new Wild("비둘기"));

		// Wild와 Pet은 Animal을 상속받았음.
		// getAnimalList() 함수는 상위 클래스 제한이므로
		// Animal, Wild, Pet 클래스가 사용가능.
		System.out.println("상위 클래스 제한");
		getAnimalList(animalGroup);
		getAnimalList(petGroup);
		getAnimalList(wildGroup);
		// getPetList() 함수는 하위 클래스 제한이므로
		// Pet, Animal 클래스만 사용 가능
		System.out.println("하위 클래스 제한");
		getPetList(petGroup);
		getPetList(animalGroup);
		// getPetList(wildGroup);
	}

	/**
	 * 상위 클래스 제한
	 * -> 제네릭 타입이 특정 클래스나 그 클래스를 상속한 클래스만 사용할 수 있도록 제한하는 방법
	 * @param group
	 */
	public static void getAnimalList(Group<? extends Animal> group) {
		Object[] g = group.getGroup();
		for (int i = 0; i < g.length; i++) {
			Animal animal = (Animal) g[i];
			System.out.println(animal.getName());
		}
	}

	/**
	 * 하위 클래스 제한
	 * -> 제네릭 타입이 특정 클래스나 그 클래스의 상위 클래스만 사용할 수 있도록 제한하는 방법
	 * @param group
	 */
	public static void getPetList(Group<? super Pet> group) {
		Object[] g = group.getGroup();
		for (int i = 0; i < g.length; i++) {
			Animal pet = (Animal) g[i];
			System.out.println(pet.getName());
		}
	}
}

@AllArgsConstructor
@Getter
class Animal {
	private String name;
}

class Pet extends Animal {
	public Pet(String name) {
		super(name);
	}
}

class Wild extends Animal {
	public Wild(String name) {
		super(name);
	}
}

class Group<G> {
	
	private int listCount = 0;
	
	// Sub가 Super를 상속받는 상황에서
	// 배열의 경우 Sub가 Super의 하위 타입일 때 Sub[]은 Super[]의 하위 타입이 됨. (공변)
	// 즉, 배열은 공변성이므로 Sub[]을 Super[]로 할당할 수 있음.
	// 그러나, 런타임에서 타입 불일치가 발생할 수 있어 주의해야 함.
	// 반면 제네릭 타입의 경우 Sub가 Super의 하위 타입이어도,
	// ArrayList<Sub>는 ArrayList<Super>의 하위 타입이 아니므로 불공변.
	// 제네릭은 불공변하므로 ArrayList와 같은 제네릭 타입 객체를 생성할 수 없음.

	// 따라서 제네릭 배열을 생성할 수 없으므로 Object[]로 배열을 생성하고,
	// 이를 제네릭 타입으로 형변환하는 방식이 사용됨.
	@SuppressWarnings("unchecked")
	private G[] group = (G[]) new Object[listCount];

	public void add(G g) {
		// add 함수가 호출될 시 전위 증감 연산자로 listCount의 값을 1 늘려주고,
		// copyOf()함수로 한칸 큰 배열을 만들고 복사함.(빈 공간엔 null값 또는 기본값(0, false, 0.0)등을 채워서 반환함)
		group = Arrays.copyOf(group, ++listCount);
		// group 배열의 마지막 공간에 값 g를 넣음.
		group[listCount - 1] = g;
	}

	public G[] getGroup() {
		return group;
	}
}
