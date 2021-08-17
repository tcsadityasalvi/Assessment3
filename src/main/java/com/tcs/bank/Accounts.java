package com.tcs.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Accounts {
	private static Logger logger = LoggerFactory.getLogger(Accounts.class);
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/assessment3";
		String DB_USER  = "root";
		String DB_PASSWORD = "Nuvelabs123$";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
			//create(statement); //create
			retrieve(statement);
			//update(statement);
			deposit(statement);
			//delete(statement);
			//List<String> regions = retrieveWithCondition(statement, "A");
			//logger.debug(regions.toString());
			//sort(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO ACCOUNTS VALUES(23,'',6543,'17-03-2021','ACTIVE','SAVINGS',56);");
		statement.execute("INSERT INTO ADDRESS VALUES(23,'Mumbai','MAHARASHTRA',400034,13574,114,'Vile Parle',56);");
		logger.debug("USER CREATED");
	}
	
	private static void update(Statement statement) throws SQLException {
		statement.executeUpdate("Update ACCOUNTS set BALANCE_AMOUNT = 17000 where ACCOUNT_ID = 32");
	}
	
	private static void retrieve(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * from ACCOUNTS");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) +"\t");
			System.out.println(resultSet.getString(2) + "\t");
			System.out.println(resultSet.getInt(3));
			System.out.println("\n");
			
		}
	}
	
	private static void deposit(Statement statement) throws SQLException {
		statement.executeUpdate("Update Accounts set balance_amount = balance_amount + 15000 where ACCOUNT_ID = 1001");
	}
	private static void withdraw(Statement statement) throws SQLException {
		
		statement.executeUpdate("Update Accounts set balance_amount=balance_amount-5000 where balance_amount>=5000 and Account_id = 1" );
		logger.debug("Updated");
	}

	}
