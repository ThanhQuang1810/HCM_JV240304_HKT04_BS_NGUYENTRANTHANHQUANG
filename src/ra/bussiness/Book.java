package ra.bussiness;

import java.util.Scanner;

public class Book {
    private static int count = 0;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = ++count;
        this.bookStatus = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName != null && !bookName.isEmpty()) {
            this.bookName = bookName;
        } else {
            throw new IllegalArgumentException("Tên sách không được để trống");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Tác giả không thể để trống");
        }
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        if (descriptions != null && descriptions.length() >= 10) {
            this.descriptions = descriptions;
        } else {
            throw new IllegalArgumentException("Mô tả phải có ít nhất 10 ký tự");
        }
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        if (importPrice > 0) {
            this.importPrice = importPrice;
        } else {
            throw new IllegalArgumentException("Giá nhập khẩu phải lớn hơn 0");
        }
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        if (exportPrice > 1.2 * this.importPrice) {
            this.exportPrice = exportPrice;
        } else {
            throw new IllegalArgumentException("Giá xuất khẩu phải lớn hơn 1,2 lần giá nhập khẩu");
        }
    }

    public float getInterest() {
        return interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập tên sách: ");
            String name = scanner.nextLine();
            try {
                setBookName(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập tên tác giả: ");
            String author = scanner.nextLine();
            try {
                setAuthor(author);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập mô tả sách: ");
            String description = scanner.nextLine();
            try {
                setDescriptions(description);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập giá nhập khẩu: ");
            double importPrice = scanner.nextDouble();
            try {
                setImportPrice(importPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập giá xuất khẩu: ");
            double exportPrice = scanner.nextDouble();
            try {
                setExportPrice(exportPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void displayData() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Description: " + descriptions);
        System.out.println("Import Price: " + importPrice);
        System.out.println("Export Price: " + exportPrice);
        System.out.println("Interest: " + interest);
        System.out.println("Status: " + (bookStatus ? "True" : "False"));
    }
}
