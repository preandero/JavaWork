package practice.cardcompany;

import com.lec.java.static03.Test;

public class Company {
	public int serialNumber = 10001;

	// 필요한 변수, 메소드, 생성자 정의하기

	private Company() {
	}

	public Card createCard() {
		Card num = new Card(serialNumber);
		serialNumber++;
		return num;

	}

	private static Company instance = null;

	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}

} // end class
