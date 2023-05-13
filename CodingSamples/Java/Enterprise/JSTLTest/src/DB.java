package db.web.app;

import java.sql.*;
import oracle.jdbc.pool.*;

class DB {

	private static OracleConnectionPoolDataSource pool;

	public static Connection connect() throws SQLException {
		if(pool == null){
			pool = new OracleConnectionPoolDataSource();
			pool.setURL("jdbc:oracle:thin:@//iitdac.met.edu/xe");
			pool.setUser("scott");
			pool.setPassword("tiger");
		}
		return pool.getConnection();
	}
}

