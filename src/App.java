import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Search Book");
        System.out.println("4. Update Book");
        System.out.println("5. Delete Book");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

switch (choice) {

    case 1:

    sc.nextLine();   // Clear the Enter key

    Book book = new Book();

    System.out.print("Enter Title: ");
    book.setTitle(sc.nextLine());

    System.out.print("Enter Author: ");
    book.setAuthor(sc.nextLine());

    System.out.print("Enter Category: ");
    book.setCategory(sc.nextLine());

    System.out.print("Enter Quantity: ");
    book.setQuantity(sc.nextInt());

    dao.addBook(book);
        break;

    case 2:
        dao.viewBooks();
        break;

    case 3:

    sc.nextLine();   // Clear Enter key

    System.out.print("Enter Book Title: ");
    String title = sc.nextLine();

    dao.searchBook(title);
     break;

    case 4:

    System.out.print("Enter Book ID: ");
    int id = sc.nextInt();

    System.out.print("Enter New Quantity: ");
    int quantity = sc.nextInt();

    dao.updateBook(id, quantity);

    break;

    case 5:

    System.out.print("Enter Book ID to Delete: ");
    int deleteId = sc.nextInt();

    dao.deleteBook(deleteId);

    break;

    case 6:
        System.out.println("Thank you!");
        break;

    default:
        System.out.println("Invalid Choice!");
}
sc.close();
    }
}