package kr.pe.gujjy.sp4.jta.xa.hsqldb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.dao.BbsDao;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.dao.NoticeDao;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Bbs;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Notice;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.service.CombineInsertTestService;

@Service
public class CombineInsertTestServiceImpl implements CombineInsertTestService {

	@Autowired BbsDao bbsDao;
	@Autowired NoticeDao noticeDao;
	
	@Override
	public void insert(String subject, String content, int loopCnt) {
		for (int i = 0; i < loopCnt ; i ++) {
			bbsDao.insert(new Bbs(subject +"_"+ loopCnt +"_" +i, content+"_"+ loopCnt +"_" +i));
			
			Notice notice = new Notice(subject+"_"+ loopCnt +"_" +i, content+"_"+ loopCnt +"_" +i);
			if(i==5) notice.setSubject(null);
			
			noticeDao.insert(notice);
			
		}
		
	}

}
