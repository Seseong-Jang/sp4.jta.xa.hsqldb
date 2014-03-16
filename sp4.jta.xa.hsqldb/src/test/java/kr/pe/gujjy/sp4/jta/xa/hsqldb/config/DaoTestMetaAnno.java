package kr.pe.gujjy.sp4.jta.xa.hsqldb.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ContextConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes={SpringConfig.class, DataSourceConfig.class
		, TestDbConfig.class})
public @interface DaoTestMetaAnno {

}