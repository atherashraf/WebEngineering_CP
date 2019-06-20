package org.pucit.utils;

import org.pucit.enumerators.ResponseType;

import java.sql.*;
import java.util.List;

public class DBConnection {
    private boolean isError = false;
    private String msg;
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;

    public DBConnection() {
        final String DB_URL = "jdbc:mysql://localhost:3306/pucit";
        final String USER = "root";
        final String PASS = "mysqlroot";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            isError = true;
            msg = "Fail to connect to database";
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        if(this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isError() {
        return isError;
    }

    public ResponseType getResponseType() {
        if (this.isError) {
            return ResponseType.ERROR;
        } else {
            return ResponseType.SUCCESS;
        }
    }

    public String getMsg() {

        return msg;
    }


    public void createTable(String ddl) {
        String errorMsg = "Fail to create table";
        String successMsg = "Table created successfully";
        if (!this.isError()) {
            try {
                Statement stmt = conn.createStatement();
                isError = stmt.execute(ddl);
                if (isError) {
                    msg = errorMsg;
                } else {
                    msg = successMsg;
                }
            } catch (Exception e) {
                isError = true;
                msg = e.getMessage();
                e.printStackTrace();
            }
        }
    }

    public PreparedStatement preparedStatement(String stmt, List<String> values) {

        try {
            if (!this.isError) {
                this.preparedStatement = this.conn.prepareStatement(stmt);
                for (int i=0;  i < values.size(); i++) {
                    this.preparedStatement.setString(i+1, values.get(i));
                }
            }
        } catch (Exception e) {
            isError = true;
            msg = e.getMessage();
            e.printStackTrace();
        } finally {
            return this.preparedStatement;
        }

    }

    public void executeDMLOperation() {
        if (this.preparedStatement != null) {
            try {
                this.preparedStatement.executeUpdate();
            } catch (SQLException e) {
                isError = true;
                msg = e.getMessage();
                e.printStackTrace();
            }
        }
    }

}
