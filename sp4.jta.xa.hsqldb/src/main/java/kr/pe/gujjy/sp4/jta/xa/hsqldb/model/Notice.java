package kr.pe.gujjy.sp4.jta.xa.hsqldb.model;

public class Notice extends Article {

	public Notice(){}
	public Notice(String subject, String content) {
		setSubject(subject);
		setContent(content);
	}
	
}
