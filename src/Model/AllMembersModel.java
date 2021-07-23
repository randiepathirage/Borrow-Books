package Model;

import Connectivity.DBConnection;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllMembersModel {
    Connection conn;
    public AllMembersModel() {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.getConnection();


        if (conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }
    }

    public ObservableList loadTable(ObservableList details){
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM member");
            while (rs.next()){
                details.add(new Member(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("mobile"),
                        rs.getString("email")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return details;
    }

    public boolean getBook(String id) throws SQLException {
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String query= "SELECT * FROM member WHERE id=?";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,id);

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
