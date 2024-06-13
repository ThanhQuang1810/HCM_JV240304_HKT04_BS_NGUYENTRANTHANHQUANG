package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    private static Book[] books = new Book[100];
    private static int count = 0;

    public static void addBooks(Scanner scanner) {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (count + n > 100) {
            System.out.println("Không thể thêm sách quá 100 cuốn.");
            return;
        }

        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData();
            books[count++] = book;
        }
    }

    public static void displayAllBooks() {
        for (int i = 0; i < count; i++) {
            books[i].displayData();
            System.out.println("-----------------------------");
        }
    }

    public static void sortBooksByInterest() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Sách được sắp xếp theo sở thích.");
    }

    public static void deleteBookById(Scanner scanner) {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--count] = null;
                System.out.println("ID sách " + id + " xóa.");
                return;
            }
        }
        System.out.println("ID sách " + id);
    }

    public static void searchBooks(Scanner scanner) {
        System.out.print("Nhập cụm từ tìm kiếm: ");
        String term = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookName().contains(term) || books[i].getDescriptions().contains(term)) {
                books[i].displayData();
                System.out.println("-----------------------------");
            }
        }
    }

    public static void updateBookById(Scanner scanner) {
        System.out.print("Nhập ID sách để cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].inputData();
                System.out.println("ID sách " + id + " cập nhật.");
                return;
            }
        }
        System.out.println("ID sách " + id);
    }
}
