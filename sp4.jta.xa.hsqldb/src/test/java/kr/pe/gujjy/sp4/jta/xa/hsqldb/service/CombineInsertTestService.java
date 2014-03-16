package kr.pe.gujjy.sp4.jta.xa.hsqldb.service;

import javax.transaction.Transactional;

@Transactional
public interface CombineInsertTestService {

	void insert(String string, String string2, int i);

}
