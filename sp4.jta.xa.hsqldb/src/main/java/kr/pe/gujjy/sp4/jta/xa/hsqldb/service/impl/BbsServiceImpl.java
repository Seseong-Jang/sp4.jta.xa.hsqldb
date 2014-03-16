package kr.pe.gujjy.sp4.jta.xa.hsqldb.service.impl;

import java.util.List;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.dao.BbsDao;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Bbs;
import kr.pe.gujjy.sp4.jta.xa.hsqldb.service.BbsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired BbsDao bbsDao;
	
	@Override
	public List<Bbs> list() {
		return bbsDao.list();
	}

	@Override
	public void write(Bbs bbs) {
		bbsDao.insert(bbs);
		
	}

}
