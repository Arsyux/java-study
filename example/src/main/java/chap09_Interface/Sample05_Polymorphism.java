package chap09_Interface;

public class Sample05_Polymorphism {

	// 인터페이스를 활용한 다형성의 활용
	// 데이터베이스라는 자료형을 인터페이스로 만들고 Oracle이나 MS-SQL을 접속하는 클래스를 각각만들어서 똑같은 메서드로
	// 다양한 기능을 구현하여 인터페이스를 활용한 다형성을 구현함.
	
	// 구현체의 스펙을 정의해놓고 다양한 객체를 구현할 때 인터페이스를 활용하면 편리함.
	public static void main(String[] args) {
		// Oracle에 접속합니다.
		Database db1 = new OracleDatabase();
		db1.getConnection();
		System.out.println(db1.getDbInfo());
		// MySQL에 접속합니다.
		Database db2 = new MysqlDatabase();
		System.out.println(db2.getDbInfo());
	}
}

interface Database {

	public void getConnection();

	public String getDbInfo();
}

class OracleDatabase implements Database {

	boolean conn = false;

	@Override
	public void getConnection() {
		this.conn = true;
	}

	@Override
	public String getDbInfo() {
		String ret = "";
		if (conn)
			ret = "Orcle에 접속성공!";
		else
			ret = "Orcle에 접속실패!";
		return ret;
	}
}

class MysqlDatabase implements Database {

	boolean conn = false;

	@Override
	public void getConnection() {
		this.conn = true;
	}

	@Override
	public String getDbInfo() {
		String ret = "";
		if (conn)
			ret = "MySQL에 접속성공!";
		else
			ret = "MySQL에 접속실패!";
		return ret;
	}
}