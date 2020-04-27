package Phonebook02.mvc;

import java.util.Arrays;

// CONTROLLER 객체
//  어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

public class PhonebookManager implements PhonebookController {

	public static final int MAX_DATA = 3;// 최대 데이터 개수

	// 배열로 구현.
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];

	// 몇개의 데이터가 저장되었는지
	private int count = 0;

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

		int result = PhonebookController.QUERY_FAIL;

		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			return result;
		}

		// 만약 배열이 다 차있으면, MAX_DATA 만큼 추가된 새 배열 작성
		if (count == pbList.length) {
			pbList = Arrays.copyOf(pbList, pbList.length + MAX_DATA);
		}

		pbList[count] = new PhonebookModel(name, phoneNum, memo);
		pbList[count].setUid(getMaxUid() + 1); // 기존의 최대 uid 값보다 1 증가한 값. (Unique 한 값 보장)
		// uid와 배열 index는 다르다
		count++;

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {

		return Arrays.copyOfRange(pbList, 0, count);

	}
	// 특정 uid 의 데이터 검색 리턴
	// 못 찾으면 null return

	@Override
	public PhonebookModel selectByUid(int uid) {

		for (int index = 0; index < count; index++) {
			if (pbList[index].getUid() == uid) {
				return pbList[index]; // uid 값 발견하면 리턴
			}
		}

		return null; // 못 찾으면 Null return

	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		int result = PhonebookController.QUERY_FAIL;

		// 매개변수 검증
		if (uid < 1)
			return result;
		if (name == null || name.trim().length() == 0)
			return result; // 이름 필수
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if (index < 0)
			return result;

		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setmemo(memo);

		result = 1; // 수정성공
		return result;
	}

	@Override
	public int deleteByUid(int uid) {
		int result = PhonebookController.QUERY_FAIL;
		
		// 매개변수 검증
		if(uid< 1) return result;
		
		int index = findIndexByUid(uid);
		if(index<0) return result;
		
		// 배열 뒤의 원소들을 앞으로 이동
		for(int i = index, j = index +1; j < count; j++,i++) {
			pbList[i] = pbList[j];
		}
		
		// count 감소
		count--;
		result = 1;
		return result;
	}

	private int getMaxUid() {
		int maxUid = 0;

		for (int index = 0; index < count; index++) {
			if (maxUid < pbList[index].getUid()) {
				maxUid = pbList[index].getUid();
			}
		}

		return maxUid;
	}

	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못 찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for (int index = 0; index < count; index++) {
			if (pbList[index].getUid() == uid) {
				return index;
			}
		}
		return -1;
	}

}
