package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.Emoji;


public class EmojiRowMapper implements RowMapper<Emoji> {

	public Emoji mapRow(ResultSet rs, int arg1) throws SQLException {
		Emoji e=new Emoji();
		e.setIdEmoticon(rs.getInt("idEmoticon"));
		e.setName(rs.getString("name"));
		e.setEmoticon(rs.getString("emoticon"));
		e.setIdType(rs.getInt("idType"));
		return e;
	}
}
