package kr.pe.gujjy.sp4.jta.xa.hsqldb.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Notice;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao extends JdbcTemplate {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="dataSource2")
	public void setDS(DataSource ds) {
		setDataSource(ds);
	}
	
	public List<Notice> list() {
		DataSource dataSource = getDataSource();
		log.debug(dataSource);
		
		return query("SELECT idx, subject, content FROM NOTICE", new RowMapper<Notice>(){
			@Override
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				Notice notice = new Notice();
				notice.setIdx(rs.getInt(1));
				notice.setSubject(rs.getString(2));
				notice.setContent(rs.getString(3));
				return notice;
			}
			
		});
	}

	public void insert(Notice notice) {
		update("INSERT INTO NOTICE SELECT ISNULL(MAX(idx), 0) +1, :subject, :content FROM NOTICE"
				, new Object[]{notice.getSubject(), notice.getContent()}
				);
	}
	
}
