package kr.pe.gujjy.sp4.jta.xa.hsqldb.service.impl;

import java.util.List;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.dao.NoticeDao;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Notice;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired NoticeDao bbsDao;
	
	@Override
	public List<Notice> list() {
		return bbsDao.list();
	}

	@Override
	public void write(Notice bbs) {
		bbsDao.insert(bbs);
		
	}

}
