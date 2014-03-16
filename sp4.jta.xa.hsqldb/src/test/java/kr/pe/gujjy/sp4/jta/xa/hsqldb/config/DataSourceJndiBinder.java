package kr.pe.gujjy.sp4.jta.xa.hsqldb.config;

import org.hsqldb.jdbc.pool.JDBCXADataSource;
import org.jdbcdslog.ConnectionPoolXADataSourceProxy;
import org.jdbcdslog.XADataSourceProxy;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

public class DataSourceJndiBinder {

	private static SimpleNamingContextBuilder builder;
	
	public static void bind() throws Exception {
		if(builder ==null){
			bindDataSourceWithNetSfSpyDriverAndSimpleNameContextBuilder();
		}
		
	}
	
	
	
	static void bindDataSourceWithNetSfSpyDriverAndSimpleNameContextBuilder() throws Exception{
		if(builder ==null){
			
			JDBCXADataSource xds = new JDBCXADataSource();
			xds.setUrl("jdbc:hsqldb:hsql://localhost:9001/");
			xds.setUser("sa");
			
			JDBCXADataSource xds2 = new JDBCXADataSource();
			xds2.setUrl("jdbc:hsqldb:hsql://localhost:12312/");
			xds2.setUser("sa");
			
			XADataSourceProxy p = new XADataSourceProxy();
			p.setTargetDSDirect(xds);
			
			ConnectionPoolXADataSourceProxy p2 = new ConnectionPoolXADataSourceProxy();
			p2.setTargetDSDirect(xds2);
			

			builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
			builder.bind("jdbc/sp4.tx.hsqldb", p);//xds);
			builder.bind("jdbc/sp4.tx.hsqldb2", p2);//xds2);
		}

	}
}
