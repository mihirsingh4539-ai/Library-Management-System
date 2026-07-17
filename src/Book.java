public class Book{

    private int bookId;
    private String title;
    private String author;
    private String category;
    private int quantity;

    public Book() {
    }
    public Book(int bookId, String title, String author, String category, int quantity){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

}
