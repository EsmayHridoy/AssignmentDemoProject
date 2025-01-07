package UtilsDao;

import Connector.MysqlConnect;
import Model.UserModel;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {





    /* Add User to the database user_table */

    public boolean addUser(UserModel userModel) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        boolean flag = false;

        if (!isExist(userModel, mysqlConnect)) {
            String QUERY = "INSERT INTO user_table (user_id, user_mail, user_name, user_password, user_role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement Statement = mysqlConnect.connect().prepareStatement(QUERY)) {

                Statement.setInt(1, userModel.getUserId());
                Statement.setString(2, userModel.getUserMail());
                Statement.setString(3, userModel.getUserName());
                Statement.setString(4, userModel.getUserPassword());
                Statement.setString(5, userModel.getUserRole());

                int rowsAffected = Statement.executeUpdate();
                if (rowsAffected > 0) {
                    flag = true;
                    System.out.println("User inserted successfully.");
                } else {
                    System.out.println("Failed to insert user.");
                }
            } catch (SQLException e) {
                System.out.println("Error while inserting user: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("User already exists.");
        }

        return flag;
    }

    private boolean isExist(UserModel userModel, MysqlConnect mysqlConnect) {
        String QUERY = "SELECT COUNT(*) FROM user_table WHERE user_id = ? OR user_mail = ?";
        try (PreparedStatement checkStatement = mysqlConnect.connect().prepareStatement(QUERY)) {
            checkStatement.setInt(1, userModel.getUserId());
            checkStatement.setString(2, userModel.getUserMail());
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0; // True if count > 0
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




    /*------------------------------------------------ Login Authentication -----------------------------------------*/
    public UserModel authenticateUser(String userMail, String userPassword) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String QUERY = "SELECT * FROM user_table WHERE user_mail = ? AND user_password = ?";

        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(QUERY)) {
            stmt.setString(1, userMail);
            stmt.setString(2, userPassword);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UserModel(
                            rs.getInt("user_id"),
                            rs.getString("user_mail"),
                            rs.getString("user_name"),
                            rs.getString("user_password"),
                            rs.getString("user_role")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public UserModel getUserByEmail(String email) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String query = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new UserModel(rs.getInt("user_id"), rs.getString("user_email"), rs.getString("user_name"),
                        rs.getString("user_password"), rs.getString("user_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public boolean updateUserName(String userEmail, String newName) {
        boolean isUpdated = false;
        MysqlConnect mysqlConnect = new MysqlConnect();
        String updateQuery = "UPDATE user_table SET user_name = ? WHERE user_mail = ?";
        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(updateQuery)) {
            stmt.setString(1, newName);
            stmt.setString(2, userEmail);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }



    public boolean updateUserPassword(String userEmail, String newPassword) {
        boolean isUpdated = false;
        MysqlConnect mysqlConnect = new MysqlConnect();
        String updateQuery = "UPDATE user_table SET user_password = ? WHERE user_mail = ?";
        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(updateQuery)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, userEmail);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    public List<UserModel> getAllUsers() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String query = "SELECT user_id, user_mail, user_name, user_role FROM user_table";
        List<UserModel> users = new ArrayList<>();

        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel(
                        rs.getInt("user_id"),
                        rs.getString("user_mail"),
                        rs.getString("user_name"),
                        "null",
                        rs.getString("user_role")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Retrieved " + users.size() + " users from the database.");
        return users;
    }



    public boolean changeUserRole(int userId, String newRole) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String updateQuery = "UPDATE user_table SET user_role = ? WHERE user_id = ?";
        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(updateQuery)) {
            stmt.setString(1, newRole);
            stmt.setInt(2, userId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
