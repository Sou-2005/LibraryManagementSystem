import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// هذا الكلاس يحتوي على التطبيق الكامل للنظام
public class LibrarySystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Borrower> borrowers = new ArrayList<>();
    private static ArrayList<BorrowingProcess> borrowings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- نظام إدارة مكتبة رقمية ---");
            System.out.println("1. إضافة كتاب");
            System.out.println("2. إضافة مستعير");
            System.out.println("3. إعارة كتاب");
            System.out.println("4. إرجاع كتاب");
            System.out.println("5. عرض الكتب");
            System.out.println("6. عرض المستعيرين");
            System.out.println("7. عرض عمليات الإعارة");
            System.out.println("0. خروج");
            System.out.print("اختر خيارًا: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addBook(); break;
                case 2: addBorrower(); break;
                case 3: borrowBook(); break;
                case 4: returnBook(); break;
                case 5: showBooks(); break;
                case 6: showBorrowers(); break;
                case 7: showBorrowings(); break;
                case 0: System.out.println("تم إنهاء البرنامج."); break;
                default: System.out.println("خيار غير صحيح!");
            }
        } while (choice != 0);
    }

    public static void addBook() {
        System.out.print("أدخل رقم الكتاب: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل عنوان الكتاب: ");
        String title = scanner.nextLine();
        System.out.print("أدخل اسم المؤلف: ");
        String author = scanner.nextLine();
        System.out.print("أدخل رقم ISBN: ");
        String isbn = scanner.nextLine();

        books.add(new Book(id, title, author, isbn));
        System.out.println("تمت إضافة الكتاب بنجاح.");
    }

    public static void addBorrower() {
        System.out.print("أدخل رقم المستعير: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل اسم المستعير: ");
        String name = scanner.nextLine();
        System.out.print("أدخل البريد الإلكتروني: ");
        String email = scanner.nextLine();

        borrowers.add(new Borrower(id, name, email));
        System.out.println("تمت إضافة المستعير بنجاح.");
    }

    public static void borrowBook() {
        System.out.print("أدخل رقم الكتاب: ");
        int bookId = scanner.nextInt();
        System.out.print("أدخل رقم المستعير: ");
        int borrowerId = scanner.nextInt();

        Book book = findBookById(bookId);
        Borrower borrower = findBorrowerById(borrowerId);

        if (book != null && borrower != null && book.isAvailable()) {
            book.borrowBook();
            borrowings.add(new BorrowingProcess(book, borrower, LocalDate.now()));
            System.out.println("تمت عملية الإعارة بنجاح.");
        } else {
            System.out.println("تعذر إجراء الإعارة (الكتاب غير متاح أو غير موجود).");
        }
    }

    public static void returnBook() {
        System.out.print("أدخل رقم الكتاب المراد إرجاعه: ");
        int bookId = scanner.nextInt();

        for (BorrowingProcess bp : borrowings) {
            if (bp.getBook().getId() == bookId && !bp.getBook().isAvailable()) {
                bp.returnBook(LocalDate.now());
                System.out.println("تم إرجاع الكتاب بنجاح.");
                return;
            }
        }
        System.out.println("لم يتم العثور على عملية إعارة نشطة لهذا الكتاب.");
    }

    public static void showBooks() {
        for (Book book : books) {
            book.displayBookInfo();
            System.out.println("-------------------------");
        }
    }

    public static void showBorrowers() {
        for (Borrower b : borrowers) {
            b.displayBorrowerInfo();
            System.out.println("-------------------------");
        }
    }

    public static void showBorrowings() {
        for (BorrowingProcess bp : borrowings) {
            bp.displayBorrowingInfo();
            System.out.println("-------------------------");
        }
    }

    private static Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private static Borrower findBorrowerById(int id) {
        for (Borrower b : borrowers) {
            if (b.getId() == id) return b;
        }
        return null;
    }
}