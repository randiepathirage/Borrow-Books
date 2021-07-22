package Model;

import Connectivity.DBConnection;

import java.sql.*;

public class LoginModel {
    Connection conn;
    public LoginModel() {
        DBConnection dbConnection = new DBConnection();
        conn =dbConnection.getConnection();


        if(conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }

    }

    public boolean isDbConnected() {
        try {
            return !conn.isClosed();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLogin(String user, String pass) throws SQLException {

        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String query= "SELECT * FROM login WHERE username=? and password=?";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }finally{
            preparedStatement.close();
            //resultSet.close();
        }
    }


}
