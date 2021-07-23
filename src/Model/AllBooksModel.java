package Model;

import Connectivity.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllBooksModel {

    Connection conn;
    public AllBooksModel() {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.getConnection();


        if (conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }
    }

    public boolean getBook(String id) throws SQLException {
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String query= "SELECT * FROM books WHERE code=?";

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

    public ObservableList loadTable(ObservableList details){
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM books");
            while (rs.next()){
                details.add(new Book(
                        rs.getString("code"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getString("status")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return details;
    }

}
