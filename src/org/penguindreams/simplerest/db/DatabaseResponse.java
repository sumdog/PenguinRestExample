package org.penguindreams.simplerest.db;

import java.sql.Connection;
import java.sql.ResultSet;

public class DatabaseResponse {

	private Connection connection;
	
	private ResultSet resultSet;
	
	public DatabaseResponse(Connection connection, ResultSet resultSet) {
		this.connection = connection;
		this.resultSet = resultSet;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public void dispose() {
		try {
			resultSet.close();
			connection.close();
		}
		catch(Exception e) {
			//We don't care about these exceptions
		}
	}
	
	protected void finalize() throws Throwable {
		dispose();
	}
	
}
