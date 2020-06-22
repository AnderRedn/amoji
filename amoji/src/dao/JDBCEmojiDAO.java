package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import datos.IEmojiDAO;
import modelo.Emoji;

@Repository
public class JDBCEmojiDAO extends JdbcDaoSupport implements IEmojiDAO {

	private DataSource ds;

	@Autowired
	public void setDs(DataSource ds) {
		this.ds = ds;
		setDataSource(ds);
	}

	@Override
	public void createEmoji(Emoji e) {
		String sql = "insert into emoticon(name,emoticon,idType) values(?,?,?)";
		getJdbcTemplate().update(sql, e.getName(), e.getEmoticon(), e.getIdType());
	}

	@Override
	public List<Emoji> listEmojis() {
		String sql = "select * from emoticon";
		return getJdbcTemplate().query(sql, new EmojiRowMapper());
	}

	@Override
	public Emoji getEmojiById(int idEmoticon) {
		String sql = "select * from emoticon where idEmoticon=?";
		Emoji p = (Emoji) getJdbcTemplate().queryForObject(sql, new Object[] { idEmoticon }, new EmojiRowMapper());
		return p;
	}

	@Override
	public void deleteEmoji(int idEmoticon) {
		String sql = "delete from emoticon where idEmoticon=?";
		getJdbcTemplate().update(sql, idEmoticon);
	}

	@Override
	public void updateEmoji(Emoji e) {
		String sql = "update emoticon set idEmoticon=?,nameEmoticon=?,emoticon=?,idType=? where idEmoticon=?";
		getJdbcTemplate().update(sql, e.getIdEmoticon(), e.getName(), e.getEmoticon(), e.getIdType(), e.getIdEmoticon());
	}

	@Override
	public List<Emoji> getEmojisByType(int idType) {
		String sql = "select * from emoticon where idType=?";
		return getJdbcTemplate().query(sql, new Object[] { idType }, new EmojiRowMapper());
	}

}
