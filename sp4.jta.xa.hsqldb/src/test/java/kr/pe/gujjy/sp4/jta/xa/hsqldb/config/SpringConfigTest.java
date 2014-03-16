package kr.pe.gujjy.sp4.jta.xa.hsqldb.config;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import javax.sql.XADataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DaoTestMetaAnno
public class SpringConfigTest {

	@Autowired ApplicationContext ctx;
	@Autowired List<XADataSource> dss;
	//@Autowired List<PlatformTransactionManager> txMngs;
	
	@Test
	public void testDi() {
		assertThat(ctx, notNullValue());
		assertThat(dss.size(), is(2));
		//assertThat(txMngs.size(), is(2));
	}
	
}
