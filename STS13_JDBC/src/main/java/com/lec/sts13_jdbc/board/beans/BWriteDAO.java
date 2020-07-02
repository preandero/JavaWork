package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.*;

import com.lec.sts13_jdbc.board.C;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.ui.Model;

public class BWriteDAO {
	JdbcTemplate template;

	public BWriteDAO() {
		this.template = C.template;
	}

	// 전체 SELECT
	public List<BWriteDTO> select() {

		// 이렇게나 간단해진다!
		return template.query(C.SQL_WRITE_SELECT,
				new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));

	}

	public int insert(final BWriteDTO dto) {

//		return
//		template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement preparedStatement) throws SQLException {
//				preparedStatement.setString(1,dto.getSubject());
//				preparedStatement.setString(2,dto.getContent());
//				preparedStatement.setString(3,dto.getName());
//
//			}
//		});

		return
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

						PreparedStatement ps = connection.prepareStatement(C.SQL_WRITE_INSERT);
						ps.setString(1, dto.getSubject());
						ps.setString(2, dto.getContent());
						ps.setString(3, dto.getName());

						return ps;
					}
				});

	}


	public List<BWriteDTO> readByUid(int uid) {


		template.update(C.SQL_WRITE_INC_VIEWCNT, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1,uid);
			}
		});

		return (List<BWriteDTO>) template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, uid);
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));

	}


	public List<BWriteDTO> selectByUid(int uid){

		return template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, uid);
			}
		}, new BeanPropertyRowMapper<BWriteDTO>());

	}

	public int update(BWriteDTO dto){

		return
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

						PreparedStatement ps = connection.prepareStatement(C.SQL_WRITE_UPDATE);
						ps.setString(1, dto.getSubject());
						ps.setString(2, dto.getContent());
						ps.setInt(3, dto.getUid());

						return ps;
					}
				});

	}


	public int deleteByUid(int uid){

		return
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

						PreparedStatement ps = connection.prepareStatement(C.SQL_WRITE_DELETE_BY_UID);
						ps.setInt(1, uid);

						return ps;
					}
				});

	}


}












