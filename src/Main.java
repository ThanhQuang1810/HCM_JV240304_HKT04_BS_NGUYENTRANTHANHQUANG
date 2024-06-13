import ra.run.BookManagement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_CYAN = "\u001B[36m";
        do {
            System.out.println(ANSI_CYAN + "╔════════════════════════════════════════════════════════════════════════╗" + ANSI_RESET);
            System.out.println("                     JAVA-HACKATHON-04-BASIC-MENU");
            System.out.println(ANSI_CYAN + "╚════════════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách    ║"  + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 2. Hiển thị thông tin tất cả sách trong thư viện                       ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 3. Sắp xếp sách theo lợi nhuận tăng dần                                ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 4. Xóa sách theo mã sách                                               ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả                    ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 6. Thay đổi thông tin sách theo mã sách                                ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN +"║ 7. Thoát                                                               ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "╚════════════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
           System.out.print(ANSI_RED + "Lựa chọn của bạn là: " + ANSI_RESET);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    BookManagement.addBooks(scanner);
                    break;
                case 2:
                    BookManagement.displayAllBooks();
                    break;
                case 3:
                    BookManagement.sortBooksByInterest();
                    break;
                case 4:
                    BookManagement.deleteBookById(scanner);
                    break;
                case 5:
                    BookManagement.searchBooks(scanner);
                    break;
                case 6:
                    BookManagement.updateBookById(scanner);
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 7);
    }
}
