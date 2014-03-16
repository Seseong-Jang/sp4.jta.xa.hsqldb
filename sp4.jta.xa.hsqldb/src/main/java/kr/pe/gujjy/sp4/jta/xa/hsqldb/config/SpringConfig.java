package kr.pe.gujjy.sp4.jta.xa.hsqldb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan(
		basePackages="kr.pe.gujjy.sp4.jta.xa.hsqldb"
		, useDefaultFilters=false
		, includeFilters={
				@Filter(Bean.class)
				, @Filter(Service.class)
				, @Filter(Repository.class)
		})
@EnableAspectJAutoProxy
public class SpringConfig {

	
}
