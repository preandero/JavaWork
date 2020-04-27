package mypractice;

import java.util.ArrayList;
import java.util.Arrays;

// CONTROLLER 객체
//  어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

public class PhonebookManager implements Pb {

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	int count = 0;
	// singleton적용
	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: " + Pb.ERR_EMPTY_STRING);
		}

		PhonebookModel irt = new PhonebookModel(name, phoneNum, memo);

		pbList.add(irt);
		for (int i = 0; i < pbList.size(); i++) {
			if (pbList.get(i) != null) {
				pbList.get(i).setUid(i+1);
			}
		}
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {

		PhonebookModel[] people = new PhonebookModel[pbList.size()];
		for (int i = 0; i < pbList.size(); i++) {
			if (pbList.get(i) != null)
				people[i] = pbList.get(i);

		}

		return people;

	}
	// 특정 uid 의 데이터 검색 리턴
	// 못 찾으면 null return

	@Override
	public PhonebookModel selectByUid(int uid) {
		
		for(int i = 0 ; i < pbList.size(); i++) {
		if (pbList.get(i).getUid() == uid) {
			return pbList.get(i);
		}
		}

		return null; // 못 찾으면 Null return

	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: " + Pb.ERR_EMPTY_STRING); // 이름 필수
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("update() 없는 uid: " + Pb.ERR_UID);

		PhonebookModel update = new PhonebookModel( name, phoneNum, memo );
		
			for(int i = 0; i< pbList.size(); i++) {
				if(pbList.get(i).getUid() == uid) {
			pbList.set(i, update);
			pbList.get(i).setUid(uid);}
			}

		return 1;
		
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + Pb.ERR_UID);
		
		for(int i = 0 ; i < pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) {
		pbList.remove(i);
		}}
		return 1;
	}

	private int getMaxUid() {
		int maxUid = 0;

		for (int i = 0; i < pbList.size(); i++) {
			if(pbList.get(i).getUid() >maxUid) {
				maxUid = pbList.get(i).getUid();
			}
		}

		return maxUid;
	}

	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못 찾으면 -1 리턴
	private int findIndexByUid(int uid) {

		for(int i = 0 ; i< pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) {
				return i;
			}
		}

		return -1;
	}

}

// 예외 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.

class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}
}
