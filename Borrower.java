// هذا الكلاس يمثل كائن "مستعير" في نظام المكتبة
public class Borrower {
    private int id;
    private String name;
    private String email;

    public Borrower(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void displayBorrowerInfo() {
        System.out.println("رقم المستعير: " + id);
        System.out.println("الاسم: " + name);
        System.out.println("البريد الإلكتروني: " + email);
    }
}