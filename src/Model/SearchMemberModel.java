package Model;

import Connectivity.DBConnection;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchMemberModel {

    Connection conn;
    public SearchMemberModel() {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.getConnection();


        if (conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }
    }

    public ArrayList getDetails(String id, ArrayList details) {
        try {

            PreparedStatement preparedStatement =null;
            ResultSet resultSet;
            String query= "SELECT * FROM member WHERE id=?";
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();




            while (resultSet.next()){
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

    public boolean isUpdate(String id, String name, String mobile, String email) {
        PreparedStatement preparedStatement =null;
        int resultSet;
        String query= "UPDATE member SET mobile=?,email=? WHERE id=?";

        try {
            preparedStatement  =conn.prepareStatement(query);
           //preparedStatement.setString(1,name);
            preparedStatement.setString(1,mobile);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,id);
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
        String query= "DELETE FROM member WHERE id=?";

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
