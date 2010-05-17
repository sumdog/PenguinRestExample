package org.penguindreams.simplerest.db;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.penguindreams.simplerest.general.SimpleRestException;

public class DatabaseHandler {
	
	private DataSource dataSource;
	
	private Map<String,String> statements;

	public DatabaseHandler() {
		statements = new HashMap<String,String>();
	}

	public void setJdbcName(String jdbcName) throws SimpleRestException {
		try {
			dataSource = (DataSource) (new InitialContext()).lookup(jdbcName);
		} catch (NamingException e) {
			throw new SimpleRestException("Invalid JDBC String " + jdbcName,e);
		}
	}
	
	public void runStatement(String sqlName, Object[] args) {
		
		try {
			String stmt = statements.get(sqlName);
			if(stmt == null) {
				stmt = "";
					
				//read SQL statement from file
				BufferedReader stmtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(
						"org/penguindreams.simplerest/db/statements/" + sqlName + ".sql")));
				
				String line;
				while( (line = stmtReader.readLine()) != null ) {
					stmt += line;	
				}
				
				//cache file I/O
				statements.put(sqlName, stmt);
			}
			
			PreparedStatement pStmt = prepareStatement(stmt, args);
			ResultSet rs = pStmt.executeQuery();			
		}
		catch(IOException io) {
			
		} 
		catch (SQLException e) {

		}
				
	}
	
    /**
	 * prepares a statement against the given SQL.
	 * 
	 * @param sql SQL query string
	 * @return PreparedStatement statement which is ready to execute
	 * @throws SQLException
	 */
	private PreparedStatement prepareStatement(String sql, Object[] params) throws SQLException {

		PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
		
		for (int i = 0; i < params.length; i++) {
			if (params[i] instanceof String) {
				preparedStatement.setString(i + 1, (String) params[i]);
			} 
			else if (params[i] instanceof Integer) {
				preparedStatement.setInt(i + 1, ((Integer) params[i]).intValue());
			} 
			else if (params[i] instanceof Boolean) {
				preparedStatement.setBoolean(i + 1, ((Boolean) params[i]).booleanValue());

			} 
			else if (params[i] instanceof Date) {
				preparedStatement.setDate(i + 1, new java.sql.Date(((java.util.Date) params[i]).getTime()));
			}
		}
		return preparedStatement;
	}

	
	
}
