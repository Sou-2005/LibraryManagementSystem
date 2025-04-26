// هذا الكلاس يمثل كائن "كتاب" في نظام المكتبة
public class Book {
    private int id;              // رقم الكتاب
    private String title;        // عنوان الكتاب
    private String author;       // اسم المؤلف
    private String isbn;         // رقم ISBN
    private boolean isAvailable; // حالة التوفر

    public Book(int id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() {
        if (isAvailable) isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public void displayBookInfo() {
        System.out.println("رقم الكتاب: " + id);
        System.out.println("العنوان: " + title);
        System.out.println("المؤلف: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("متاح: " + (isAvailable ? "نعم" : "لا"));
    }
}