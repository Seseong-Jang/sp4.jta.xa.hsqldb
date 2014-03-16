package kr.pe.gujjy.sp4.jta.xa.hsqldb.config;

import org.hsqldb.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDbConfig {
	static{
		//-Dexec.mainClass="org.hsqldb.Server" -Dexec.args="-database.0 file:hsqldb"
		Server.main(new String[]{"-database.0", "file:hsqldb1"});
		Server.main(new String[]{"-database.0", "file:hsqldb2"
				//, "-dbname.0", "hsqldb2"
				, "-port", "12312"});
		
		
		try {
			DataSourceJndiBinder.bind();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  static void main(String args[]) throws InterruptedException {
		Thread.sleep(1000*60*3);
	}
}
