package kr.pe.gujjy.sp4.jta.xa.hsqldb.service.impl;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import javax.transaction.Transactional;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.config.DaoTestMetaAnno;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Bbs;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.service.BbsService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DaoTestMetaAnno
public class BbsServiceImplTest {

	@Autowired BbsService service;
	
	@Test
	public void test_di() {
		assertThat(service, notNullValue());
	}
	
	@Test
	public void test_list() {
		int i = 0;
		service.list();
		assertThat(++i, is(1));
	}
	
	

	@Test
	public void test_write() {
		List<Bbs> list_before = service.list();
		service.write(new Bbs("bS'ub", "bCo'nt"));
		service.write(new Bbs("bSub1", "bCo1'nt"));
		service.write(new Bbs("bSub2", "bCo2'nt"));
		service.write(new Bbs("bSub3", "bCo3'nt"));
		service.write(new Bbs("bSub4", "bCo4'nt"));
		List<Bbs> list_after = service.list();
		assertThat(list_after.size(), is(list_before.size() +5));
	}

	
}
