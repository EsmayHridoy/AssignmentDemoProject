package UtilsDao;

import Connector.MysqlConnect;
import Model.BookModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {



    public boolean addBook(BookModel book) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String selectQuery = "SELECT book_count FROM book_list WHERE book_name = ? AND book_author = ?";
        String updateQuery = "UPDATE book_list SET book_count = book_count + ? WHERE book_name = ? AND book_author = ?";
        String insertQuery = "INSERT INTO book_list (book_id, book_name, book_author, book_price, book_count) VALUES (?, ?, ?, ?, ?)";

        boolean flag = false;

        try (PreparedStatement selectStatement = mysqlConnect.connect().prepareStatement(selectQuery)){
            selectStatement.setString(1, book.getBookName());
            selectStatement.setString(2, book.getBookAuthor());
            ResultSet resultSet = selectStatement.executeQuery();

            if(resultSet.next()){
                try (PreparedStatement updateStatement = mysqlConnect.connect().prepareStatement(updateQuery)){
                    updateStatement.setInt(1,book.getBookCount());
                    updateStatement.setString(2,book.getBookName());
                    updateStatement.setString(3,book.getBookAuthor());
                    int rowsUpdated = updateStatement.executeUpdate();
                    if(rowsUpdated > 0)flag=true;


                }
            }
            else{
                try (PreparedStatement insertStatement = mysqlConnect.connect().prepareStatement(insertQuery)){
                    insertStatement.setInt(1,book.getBookId());
                    insertStatement.setString(2,book.getBookName());
                    insertStatement.setString(3,book.getBookAuthor());
                    insertStatement.setDouble(4,book.getBookPrice());
                    insertStatement.setInt(5,book.getBookCount());
                    int rowsInserted = insertStatement.executeUpdate();
                    if(rowsInserted > 0)flag=true;


                }

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return flag;
    }

    // Method to decrement the book count in the database
    public boolean decrementBookCount(int bookId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String updateQuery = "UPDATE book_list SET book_count = book_count - 1 WHERE book_id = ? AND book_count > 0";
        String deleteQuery = "DELETE FROM book_list WHERE book_id = ?";

        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(updateQuery)) {
            stmt.setInt(1, bookId);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                // After decrementing, check if the count is 0, and delete the book
                String checkCountQuery = "SELECT book_count FROM book_list WHERE book_id = ?";
                try (PreparedStatement checkStmt = mysqlConnect.connect().prepareStatement(checkCountQuery)) {
                    checkStmt.setInt(1, bookId);
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt("book_count") == 0) {
                        try (PreparedStatement deleteStmt = mysqlConnect.connect().prepareStatement(deleteQuery)) {
                            deleteStmt.setInt(1, bookId);
                            deleteStmt.executeUpdate();
                        }
                    }
                }
                return true;  // Return true if the update and possible delete were successful
            }
            return false;  // Return false if the update didn't affect any rows
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if there was an error
        }
    }


    // Method to retrieve all books from the database
    public List<BookModel> getAllBooks() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String query = "SELECT book_id, book_name, book_author, book_price, book_count FROM book_list";
        List<BookModel> books = new ArrayList<>();

        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                BookModel book = new BookModel(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("book_author"),
                        rs.getDouble("book_price"),
                        rs.getInt("book_count")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }



    public boolean updateBookPrice(int bookId, double updatedPrice) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String updateQuery = "UPDATE book_list SET book_price = ? WHERE book_id = ?";

        try (PreparedStatement stmt = mysqlConnect.connect().prepareStatement(updateQuery)) {
            stmt.setDouble(1, updatedPrice);
            stmt.setInt(2, bookId);
            int rowsUpdated = stmt.executeUpdate();

            return rowsUpdated > 0;  // Return true if the update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if there was an error
        }
    }

}
