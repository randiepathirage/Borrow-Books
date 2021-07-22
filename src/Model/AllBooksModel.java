package Model;

import Connectivity.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public void getBook(String id) throws SQLException {

    /*    ObservableList<Book> techList = FXCollections.observableArrayList();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String query= "SELECT * FROM books WHERE title=?";
        Book bookDetails;

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,id);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                bookDetails = new Book(resultSet.getString("code"),resultSet.getString("title"),resultSet.getString("author"),resultSet.getString("publisher"));
                techList.add(bookDetails);
            }
            return techList;
        } catch (SQLException e) {
           // Logger.getLogger(ViewTeachersController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            preparedStatement.close();
            //resultSet.close();
        }*/
    }



}
