package Phonebook03.ex;

// Controller 인터페이스
// 동작 정의하기 전에 ' 동작 설계 '
public interface Pb {
	
	public static final String VERSION = "전화번호부 3.0";
	// 만들고자 하는 응용프로그램의
	// '동작' 을 설계하는 것이 인터페이스다.
	// 이 인터페이스는 View 와 Controller 의 연결고리 역할을 하여. 모듈단위 유지관리를 용이하게 해준다.

	// [동작 설계]
	// 1. 이름(name) 과 전화번호(phoneNum) 과 (memo) 값이 주어지면 전화번호 데이터(PhonebookModel) 를 생성하여
	// 저장,
	// 날짜(regDate) 는 생성한 날짜로, uid 값은 자동 증가 값으로
	// 성공하면 1, 실패하면 0 리턴
	// 2. 현재 전화번호부에 저장된 전화번호 데이터(PhonebookModel) 들을 전부 불러들여서 리턴 (PhonebookModel 배열로)
	// 3. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 리턴
	// 없으면 null 리턴
	// 4. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서
	// 주어진 이름(name) 과 전화번호(phoneNum) 과 (memo) 값 으로 변경. 성공하면 1, 실패하면 0 리턴
	// 5. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 삭제. 성공하면 1, 실패하면 0 리턴
	
	
	
	public abstract int insert(String name, String phoneNum, String memo); // 1
	public abstract PhonebookModel[] selectAll(); // 2
	public abstract PhonebookModel selectByUid(int uid); // 3
	public abstract int updateByUid(int uid, String name, String phoneNum , String memo); // 4
	public abstract int deleteByUid(int uid); // 5
	
	
//	public static final int QUERY_FAIL = 0;
	
	
	// 에러코드 상수
	public static final int ERR_GENERIC = 0; // 일반 오류
	public static final int ERR_INDEXOUTOFRANGE = 1;// 인덱스 범위 벗어남
	public static final int ERR_EMPTY_STRING = 2; // 입력 문자열이 empty(혹은 null)인 경우
	public static final int ERR_UID = 3; // uid 가 없는 경우
	
	//에러 문자열
	public static final String[] ERR_STR = {
			"일반오류", // 0
			"인덱스오류", // 1
			"문자열오류", // 2
			"UID 오류", // 3
	};
	
	
	
	
	
}
