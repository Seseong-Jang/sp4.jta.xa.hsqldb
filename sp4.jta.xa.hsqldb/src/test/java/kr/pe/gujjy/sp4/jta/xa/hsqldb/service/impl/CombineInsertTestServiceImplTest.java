package kr.pe.gujjy.sp4.jta.xa.hsqldb.service.impl;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.config.DaoTestMetaAnno;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Bbs;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Notice;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.service.BbsService;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.service.CombineInsertTestService;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.service.NoticeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DaoTestMetaAnno
@RunWith(SpringJUnit4ClassRunner.class)
public class CombineInsertTestServiceImplTest {

	@Autowired CombineInsertTestService service;
	@Autowired BbsService bbsService;
	@Autowired NoticeService noticeService;
	
	@Test
	public void test_di() {
		assertThat(service, notNullValue());
	}
	
	@Test
	public void test_insert() {
		List<Bbs> blist_before = bbsService.list();
		List<Notice> nlist_before = noticeService.list();
		
		try {
			service.insert("subject", "content", 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Bbs> blist_after1 = bbsService.list();
		List<Notice> nlist_after1 = noticeService.list();
		
		assertThat(blist_after1.size(), is(blist_before.size()+3));
		assertThat(nlist_after1.size(), is(nlist_before.size()+3));
		
		try { //for keep test session after rollback  
			service.insert("subject", "content", 6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Bbs> blist_after2 = bbsService.list();
		List<Notice> nlist_after2 = noticeService.list();
		
		assertThat(blist_after2.size(), is(blist_after1.size()));
		assertThat(nlist_after2.size(), is(nlist_after1.size()));
		
	}

}
