package vn.ht.phonebook.view;

import vn.ht.phonebook.module.Phonebook;
import vn.ht.phonebook.service.PhonebookService;
import vn.ht.phonebook.until.Untils;

import java.util.List;
import java.util.Scanner;

public class PhonebookView {
    private PhonebookService phonebookService;
    private Scanner scanner;

    public PhonebookView() {
        phonebookService = new PhonebookService();
        scanner = new Scanner(System.in);
    }

    public void add() {
        phonebookService.getPhonebooks();
            System.out.println("Nhập số điện thoại(0345678912)");
            System.out.print("⭆ ");
            String phone = scanner.nextLine();
            while (!Untils.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " của bạn không đúng định dạng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                System.out.println("Nhập số điện thoại (vd: 0345129876)");
                System.out.print("⭆ ");
                phone = scanner.nextLine();
            }
            System.out.println("Nhập nhóm của danh bạ");
            System.out.print("⭆ ");
            String groupPhone = scanner.nextLine();
            System.out.println("Nhập họ và tên");
            System.out.print("⭆ ");
            String fullName = scanner.nextLine();
            while (phonebookService.checkDuplicateName(fullName)) {
                System.out.println("Tên người dùng này đã tồn tại. Vui lòng nhập lại tên khác");
                System.out.print("⭆ ");
                fullName = scanner.nextLine();
            }
            System.out.println("Nhập giới tính");
            System.out.print("⭆ ");
            String gender = scanner.nextLine();
            System.out.println("Nhập địa chỉ");
            System.out.print("⭆ ");
            String address = scanner.nextLine();
            System.out.println("Nhập ngày sinh");
            System.out.print("⭆ ");
            String birthdate = scanner.nextLine();
            System.out.println("Nhập email(thuan1@gmail.com)");
            System.out.print("⭆ ");
            String email = scanner.nextLine();
            while (!Untils.isEmailValid(email)) {
                System.out.println("Email" + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại" + ("email bắt buộc phải có @"));
                System.out.println("Nhập email (vd: thuan@gmail.com)");
                System.out.print("⭆ ");
                email = scanner.nextLine();
            }
            while (phonebookService.checkDuplicateEmail(email)) {
                System.out.println("Email" + email + "của bạn đã tồn tại! vui lòng kiểm tra lại");
                System.out.println("Nhập email (vd: thuan12@gmail.com)");
                System.out.print("⭆ ");
                email = scanner.nextLine();
            }
            Phonebook phonebook = new Phonebook(phone, groupPhone, fullName, gender, address, birthdate, email);
            phonebookService.add(phonebook);
        }


    public void remove() {
        phonebookService.getPhonebooks();
        System.out.println("Nhập số điện thoại bạn cần xoá: ");
        System.out.print("⭆ ");
        String phone = scanner.nextLine();
        Phonebook phonebook = phonebookService.getPhone(phone);
        if (phonebook == null) {
            System.out.println("Không tìm thấy số điện thoại để xoá!");
        } else {
            phonebookService.remove(phonebook);
            System.out.println("Đã xoá thành công!");
        }
    }

    public void update() {
        do {
            phonebookService.getPhonebooks();
            System.out.println("Nhập số điện thoại bạn cần sửa: ");
            System.out.print("⭆ ");
            String phone = scanner.nextLine();
            Phonebook phonebook = phonebookService.getPhone(phone);
            if (phonebook == null) {
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
                break;
            } else {
                System.out.println("Nhập số điện thoại mà bạn muốn sửa");
                System.out.print("⭆ ");
                phone = scanner.nextLine();
                phonebook.setPhone(phone);
                phonebookService.update();
                System.out.println("Chúc mừng bạn đã sửa thành công");
            }
        }while (true);

    }

    public void show() {
        List<Phonebook> phonebooks = phonebookService.getPhonebooks();
        System.out.println("---------------------DANH SÁCH DANH BẠ-------------------------");
        System.out.printf("%-5s %-20s %-15s %-15s %-10s", "Số điện thoại", "Nhóm", "Họ Tên", "Giới tính", "Địa chỉ");
        System.out.println(" ");
        for (Phonebook phonebook : phonebooks) {
            System.out.printf("%-5s %-20s %-15s %-15s %-10s\n", phonebook.getPhone(), phonebook.getGroupPhonebook(), phonebook.getFullName(), phonebook.getGender(), phonebook.getAddress());
        }
        System.out.println("----------------------------------------------------------------");
    }
}
