package kr.pe.gujjy.sp4.jta.xa.hsqldb.service;

import java.util.List;

import javax.transaction.Transactional;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Bbs;

@Transactional
public interface BbsService {
 	List<Bbs> list();

	void write(Bbs bbs);
 	
}
