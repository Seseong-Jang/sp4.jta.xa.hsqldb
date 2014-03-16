package kr.pe.gujjy.sp4.jta.xa.hsqldb.config;

import javax.management.RuntimeErrorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import javax.transaction.SystemException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.J2eeUserTransaction;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	Logger log = Logger.getLogger(this.getClass());
	
	@Bean(name="dataSource")
	DataSource dataSource() {
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setUniqueResourceName("dataSource");
		atomikosDataSourceBean.setXaDataSource(lookUpDS());
		atomikosDataSourceBean.setMinPoolSize(1);
		return atomikosDataSourceBean;
	}

	@Bean(name="dataSource2")
	DataSource dataSource2() {
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setUniqueResourceName("dataSource2");
		atomikosDataSourceBean.setXaDataSource(lookUpDS2());
		atomikosDataSourceBean.setMinPoolSize(1);
		return atomikosDataSourceBean;
	}
	
	@Bean(name="xaDataSource")
	public XADataSource lookUpDS() {
		try {
			Context ctx = new InitialContext();
			XADataSource lookup = (XADataSource) ctx.lookup("jdbc/sp4.tx.hsqldb");
			return lookup;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeErrorException(new Error("DataSource lookup failed"));
		}
	}
	
	@Bean(name="xaDataSource2")
	public XADataSource lookUpDS2() {
		try {
			Context ctx = new InitialContext();
			XADataSource lookup = (XADataSource) ctx.lookup("jdbc/sp4.tx.hsqldb2");
			return lookup;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeErrorException(new Error("DataSource lookup failed"));
		}
	}
	
	@Bean(initMethod="init", destroyMethod="close")
	UserTransactionManager atomikosTransactionManager() throws SystemException {
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		userTransactionManager.setForceShutdown(false);
		userTransactionManager.setTransactionTimeout(30);
		return userTransactionManager;
	}
	
	@Bean
	J2eeUserTransaction atomikosUserTransaction() throws SystemException {
		J2eeUserTransaction j2eeUserTransaction = new J2eeUserTransaction();
		j2eeUserTransaction.setTransactionTimeout(30);
		return j2eeUserTransaction;
	}
	
	@Bean
	@DependsOn({"atomikosTransactionManager", "atomikosUserTransaction"})
	JtaTransactionManager transactionManager() throws SystemException {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
		jtaTransactionManager.setUserTransaction(atomikosUserTransaction());
		jtaTransactionManager.setAllowCustomIsolationLevels(true);
		
		return jtaTransactionManager;
	}
	
}
