package kr.pe.gujjy.sp4.jta.xa.hsqldb.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Bbs;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDao extends JdbcTemplate {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="dataSource")
	public void setDS(DataSource ds) {
		setDataSource(ds);
	}
	
	public List<Bbs> list() {
		DataSource dataSource = getDataSource();
		log.debug(dataSource);
		
		return query("SELECT idx, subject, content FROM BBS", new RowMapper<Bbs>(){
			@Override
			public Bbs mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bbs bbs = new Bbs();
				bbs.setIdx(rs.getInt(1));
				bbs.setSubject(rs.getString(2));
				bbs.setContent(rs.getString(3));
				return bbs;
			}
			
		});
	}

	public void insert(Bbs bbs) {
		//update("INSERT INTO BBS SELECT ISNULL(MAX(idx), 0)+1, :subject, :content FROM BBS"
		update("INSERT INTO BBS SELECT ISNULL(MAX(idx), 0)+1, ?, ? FROM BBS"		
				, new Object[]{bbs.getSubject(), bbs.getContent()}
				);
		
	}
	
}
