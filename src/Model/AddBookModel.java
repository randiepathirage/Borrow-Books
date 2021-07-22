package Model;

import Connectivity.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBookModel {
    Connection conn;

    public AddBookModel() {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.getConnection();


        if (conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }
    }

    public boolean isBookAdded(String id, String title,String author,String publisher,String status) throws SQLException {

        PreparedStatement preparedStatement =null;
        boolean resultSet;
        String query= "INSERT INTO books VALUES(?,?,?,?,?)";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,author);
            preparedStatement.setString(4,publisher);
            preparedStatement.setString(5,status);

            resultSet = preparedStatement.execute();
            if(!resultSet) {
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
