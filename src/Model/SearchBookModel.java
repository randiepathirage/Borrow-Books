package Model;

import Connectivity.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchBookModel {
    Connection conn;
    public SearchBookModel() {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.getConnection();


        if (conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }
    }

    public ArrayList getDetails(String id, ArrayList details){


           PreparedStatement preparedStatement =null;
            ResultSet resultSet;
            String query= "SELECT * FROM books WHERE code=?";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //resultSet.first();
                details.add(resultSet.getString(1));
                details.add(resultSet.getString(2));
                details.add(resultSet.getString(3));
                details.add(resultSet.getString(4));
            }

            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return details;
    }

    public boolean isUpdate(String id,String title, String author,String publisher) {
        PreparedStatement preparedStatement =null;
        int resultSet;
        String query= "UPDATE books SET title=?,author=?,publisher=? WHERE code=?";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            preparedStatement.setString(3,publisher);
            preparedStatement.setString(4,id);
            resultSet=preparedStatement.executeUpdate();

            if(resultSet>=1) {
                return true;
            }else{
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean isDelete(String id) {
        PreparedStatement preparedStatement =null;
        boolean resultSet;
        String query= "DELETE FROM books WHERE code=?";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.execute();

            if(!resultSet) {
                return true;
            }else{
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
}
