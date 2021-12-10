package vn.ht.phonebook.view;

import vn.ht.phonebook.module.Phonebook;
import vn.ht.phonebook.service.PhonebookService;
import vn.ht.phonebook.until.CSVUntil;
import vn.ht.phonebook.until.Untils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void run() {
        int number;
        do {
            Scanner scanner = new Scanner(System.in);
            PhonebookView phonebookView = new PhonebookView();
            menu();
            try {
                System.out.println(" Chọn chức năng: ");
                System.out.print("⭆ ");
                number = scanner.nextInt();
                switch (number) {
                    case 1:
                        phonebookView.show();
                        break;
                    case 2:
                        phonebookView.add();
                        break;
                    case 3:
                        phonebookView.update();
                        break;
                    case 4:
                        phonebookView.remove();
                        break;
//                    case 5:
//
//                        break;

                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        run();
                }
            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }


    public static void menu() {
        System.out.println("☯ ☯ ☯ ☯ ☯ ☯ MENU ☯ ☯ ☯ ☯ ☯ ☯");
        System.out.println("☯                          ☯");
        System.out.println("☯    1. Xem danh sách      ☯");
        System.out.println("☯    2. Thêm mới           ☯");
        System.out.println("☯    3. Cập nhật           ☯");
        System.out.println("☯    4. Xoá                ☯");
        System.out.println("☯    5. Tìm kiếm           ☯");
        System.out.println("☯    6. Đọc từ file        ☯");
        System.out.println("☯    7. Ghi vào file       ☯");
        System.out.println("☯    8. Thoát              ☯");
        System.out.println("☯                          ☯");
        System.out.println("☯ ☯ ☯ ☯ ☯ ☯ ☯ ☯ ☯ ☯ ☯ ☯ ☯ ☯");

    }
}
