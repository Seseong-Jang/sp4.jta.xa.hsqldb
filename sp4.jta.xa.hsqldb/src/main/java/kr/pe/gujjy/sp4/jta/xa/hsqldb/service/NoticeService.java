package kr.pe.gujjy.sp4.jta.xa.hsqldb.service;

import java.util.List;

import kr.pe.gujjy.sp4.jta.xa.hsqldb.model.Notice;

public interface NoticeService {
	
	List<Notice> list();
	
	void write(Notice notice);
}
