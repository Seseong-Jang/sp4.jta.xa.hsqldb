package kr.pe.gujjy.sp4.jta.xa.hsqldb.model;

public class Bbs extends Article {
	public Bbs(){}
	public Bbs(String subject, String content) {
		setSubject(subject);
		setContent(content);
	}
}
