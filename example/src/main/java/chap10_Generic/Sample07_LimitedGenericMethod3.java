package chap10_Generic;

public class Sample07_LimitedGenericMethod3 {
	
	public static void main(String[] args) {
		// 내 지갑
		Wallet MyWallet = new Wallet();
		
		// Pocket Money
		Money<Integer> m1 = new Money<>();
		m1.getMoney(10000);
		
		// Part time job
		Money<Integer> m2 = new Money<>();
		m2.getMoney(600000);
		
		// 금액 입력
		MyWallet.insertMoney(m1);
		MyWallet.insertMoney(m2);
		
		// 지갑 확인
		System.out.println(MyWallet.checkWalletMoney());
	}
	
}

class Wallet {
	double totalMoney = 0;
	
	// 와일드 카드 제네릭 타입 (Generic Unbounded wildcard)
	// 제네릭에서 와일드 카드는 메서드의 인자 중에 제네릭 타입으로 넘어올 때 어떤 제네릭 타입이
	// 들어올지 알 수 없을 때 사용하는 타입을 '?'를 통해서 작성함.
	
	// Money는 Number 클래스를 상속받는 숫자 자료형만 들어올 수 있음.
	// Wallet에서는 Money의 자료형이 Integer인지 Float인지 알 수가 없으므로 와일드카드를 사용하였음.
	public void insertMoney(Money<?> myMoney) {
		totalMoney += myMoney.getMyMoney();
	}
	
	public void insertMon(Money<?> money) {
		totalMoney += money.getMyMoney();
	}

	public double checkWalletMoney() {
		return totalMoney;
	}

}

class Money<E extends Number> {
	double myMoney;

	public void getMoney(E info) {
		this.myMoney += info.doubleValue();
	}

	public double getMyMoney() {
		return myMoney;
	}
}