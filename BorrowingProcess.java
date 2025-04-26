import java.time.LocalDate;

// هذا الكلاس يمثل عملية الإعارة بين كتاب ومستعير
public class BorrowingProcess {
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowingProcess(Book book, Borrower borrower, LocalDate borrowDate) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
        book.returnBook();
    }

    public void displayBorrowingInfo() {
        System.out.println("اسم الكتاب: " + book.getTitle());
        System.out.println("اسم المستعير: " + borrower.getName());
        System.out.println("تاريخ الإعارة: " + borrowDate);
        System.out.println("تاريخ الإرجاع: " + (returnDate != null ? returnDate : "لم يتم الإرجاع بعد"));
    }

    public Book getBook() { return book; }
    public Borrower getBorrower() { return borrower; }
}