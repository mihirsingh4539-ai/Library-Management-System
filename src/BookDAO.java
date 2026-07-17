import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

    // Add Book
    public void addBook(Book book) {

        String sql = "INSERT INTO books(title, author, category, quantity) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setInt(4, book.getQuantity());

            ps.executeUpdate();

            System.out.println("Book Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Books
    public void viewBooks() {

        String sql = "SELECT * FROM books";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("---------------------------");
                System.out.println("Book ID : " + rs.getInt("book_id"));
                System.out.println("Title   : " + rs.getString("title"));
                System.out.println("Author  : " + rs.getString("author"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Book
    public void searchBook(String title) {

        String sql = "SELECT * FROM books WHERE title = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Book not found!");
                return;
            }

            do {
                System.out.println("---------------------------");
                System.out.println("Book ID : " + rs.getInt("book_id"));
                System.out.println("Title   : " + rs.getString("title"));
                System.out.println("Author  : " + rs.getString("author"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
            } while (rs.next());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void updateBook(int id, int quantity) {
    System.out.println("Inside updateBook()");

    String sql = "UPDATE books SET quantity = ? WHERE book_id = ?";

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, quantity);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println("Rows affected: " + rows);

        if (rows > 0) {
            System.out.println("Book Updated Successfully!");
        } else {
            System.out.println("Book Not Found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void deleteBook(int id) {

    String sql = "DELETE FROM books WHERE book_id = ?";

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Book Deleted Successfully!");
        } else {
            System.out.println("Book Not Found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}