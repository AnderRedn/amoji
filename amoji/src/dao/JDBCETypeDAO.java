package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import datos.IETypeDAO;
import modelo.EType;

@Repository
public class JDBCETypeDAO extends JdbcDaoSupport implements IETypeDAO{
	
	private DataSource ds;
	
	@Autowired
	public void setDs(DataSource ds) {
		this.ds = ds;
		setDataSource(ds);
	}

	@Override
	public void createEType(EType t) {
		String sql = "insert into emoticon_type(nameType) values(?)";
		getJdbcTemplate().update(sql, t.getNameType());
	}

	@Override
	public List<EType> listEType() {
		String sql = "select * from emoticon_type";
		return getJdbcTemplate().query(sql, new ETypeRowMapper());
	}

}
