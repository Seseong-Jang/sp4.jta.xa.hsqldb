package kr.pe.gujjy.sp4.jta.xa.hsqldb.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.config.DaoTestMetaAnno;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Notice;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DaoTestMetaAnno
public class NoticeDaoTest {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	NoticeDao dao;
	
	@Test
	public void test_Di() {
		assertThat(dao, notNullValue());
	}
	
	@Test
	public void test_list() {
		int i = 0;
		dao.list();
		assertThat(++i, is(1));
	}
	
	@Test
	public void test_insert() {
		List<Notice> list = dao.list();
		dao.insert(new Notice("subject", "content"));
		List<Notice> list2 = dao.list();
		
		assertThat(list2.size(), is(list.size() +1));
		
		
	}

}
