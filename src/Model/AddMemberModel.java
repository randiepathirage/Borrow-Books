package Model;

import Connectivity.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMemberModel {
    Connection conn;

    public AddMemberModel() {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.getConnection();


        if (conn == null) {
            System.out.print("connection unsuccessful");
            System.exit(1);
        }
    }

    public boolean isMemberAdded(String name, String id,String mobile,String email) throws SQLException {

        PreparedStatement preparedStatement =null;
        boolean resultSet;
        String query= "INSERT INTO member VALUES(?,?,?,?)";

        try {
            preparedStatement  =conn.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,mobile);
            preparedStatement.setString(4,email);

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
