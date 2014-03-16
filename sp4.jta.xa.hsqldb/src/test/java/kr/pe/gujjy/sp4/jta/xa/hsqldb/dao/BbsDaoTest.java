package kr.pe.gujjy.sp4.jta.xa.hsqldb.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import javax.transaction.Transactional;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.config.DaoTestMetaAnno;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Bbs;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DaoTestMetaAnno
@Transactional
public class BbsDaoTest {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	BbsDao dao;
	
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
	public void test_insert () {
		List<Bbs> bbses = dao.list();
		int cntBefore = bbses.size();
		log.debug(cntBefore);
		dao.insert(new Bbs("bbsSub","bbsCont")); 
		assertThat(dao.list().size(), is(cntBefore+1));
		
	}

}
