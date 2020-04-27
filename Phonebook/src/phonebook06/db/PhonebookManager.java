package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

// CONTROLLER 객체
//  어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

public class PhonebookManager implements Pb, Closeable {

	// DB 를 위한 변수들 선언

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	// singleton적용

	private PhonebookManager() {

		// JDBC 프로그래밍
		// 클래스 로딩
		// 연결 Connection
		// statement (필요하다면) 생성

		try {
			Class.forName(DRIVER);

			conn = DriverManager.getConnection(URL, USER, PASSWD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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

		int cnt = 0;

		// PreparedStatement 사용.. (close해줘야함)
		try {

			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, name);
			if(phoneNum.equals("")) pstmt.setString(2, phoneNum = " ");
			else pstmt.setString(2, phoneNum);
			
			if(memo.equals("")) pstmt.setString(3, memo = " ");
			else pstmt.setString(3, memo);
			

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {

		// SQL_SELECT_ALL 사용
		PhonebookModel[] pb = new PhonebookModel[getMaxUid()];

		int i = 0;
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(COL_LABEL_NAME);
				String phonenum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);
				int uid = rs.getInt(COL_LABEL_UID);

				Date date = rs.getDate(COL_LABEL_REGDATE);
				Time time = rs.getTime(COL_LABEL_REGDATE);

				String my = new SimpleDateFormat("yyyy-MM-dd").format(date) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(time);

				SimpleDateFormat convert = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				java.util.Date pd = null;
				try {
					pd = convert.parse(my);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				pb[i] = new PhonebookModel(uid, name, phonenum, memo, pd);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pb;

	}
	// 특정 uid 의 데이터 검색 리턴
	// 못 찾으면 null return

	@Override
	public PhonebookModel selectByUid(int uid) {

		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_UID);

			pstmt.setInt(1, uid);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new PhonebookModel();
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		int cnt = 0;

		// SQL_UPDATE_BY_UID
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);

			cnt = pstmt.executeUpdate();
			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		// SQL_DELETE_BY_UID

		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	private int getMaxUid() {
		int maxUid = 0;

		try {
			pstmt = conn.prepareStatement(SQL_COUNT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				maxUid = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maxUid;
	}

	@Override
	public void close() throws IOException {

		// ResultSet
		// Statement
		// Connection
		// 들 close()..

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

