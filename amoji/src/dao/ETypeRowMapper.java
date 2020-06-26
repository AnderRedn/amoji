package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import modelo.EType;
import modelo.Emoji;

public class ETypeRowMapper implements RowMapper<EType> {

	public EType mapRow(ResultSet rs, int arg1) throws SQLException {
		EType t=new EType();
		t.setIdType(rs.getInt("idType"));
		t.setNameType(rs.getString("nameType"));
		return t;
	}
}
