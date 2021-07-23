package Model;

import Connectivity.DBConnection;
import javafx.collections.ObservableList;

import java.sql.*;

public class HomeModel {
    Connection conn;

    public HomeModel() {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.getConnection();


        if (conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }
    }


    public boolean isBookIssued(String bookId, String memberId,String date) throws SQLException {

        PreparedStatement preparedStatement =null;
        PreparedStatement preparedStatement2 =null;
        boolean resultSet,resultSet2;
        String query= "INSERT INTO issue VALUES(?,?,?)";
        String query2= "UPDATE books SET status ='issued' WHERE code =?";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,bookId);
            preparedStatement.setString(2,memberId);
            preparedStatement.setString(3,date);
            resultSet = preparedStatement.execute();

            preparedStatement2  =conn.prepareStatement(query2);
            preparedStatement2.setString(1,bookId);
            resultSet2 = preparedStatement2.execute();



            if(!resultSet && !resultSet2 ) {
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

    public boolean isReturnBook(String bookId, String memberId,String date) throws SQLException {

        PreparedStatement preparedStatement =null;
        PreparedStatement preparedStatement2 =null;
        boolean resultSet,resultSet2;
        String query= "DELETE FROM issue WHERE bookID=? and memberId=?";
        String query2= "UPDATE books SET status ='available' WHERE code =?";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,bookId);
            preparedStatement.setString(2,memberId);
            resultSet = preparedStatement.execute();

            preparedStatement2  =conn.prepareStatement(query2);
            preparedStatement2.setString(1,bookId);
            resultSet2 = preparedStatement2.execute();



            if(!resultSet && !resultSet2 ) {
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
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM books WHERE status ='issued'");
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
