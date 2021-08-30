package CaseStudy.service;

import CaseStudy.models.Customer;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static LinkedList<Customer> customerLinkedList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        for(Customer customer : customerLinkedList) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        boolean check = true;
        int id;
        int index;
        do {
            System.out.print("Nhập id: ");
            id = scanner.nextInt();
            index = findId(id);
            if (index == -1) System.out.println("Không tìm thấy id này!");
        } while (index == -1);

        while (check) {
            System.out.println("==Edit customer==");
            System.out.println("1. Sủa tên");
            System.out.println("2. Sửa ngày sinh");
            System.out.println("3. Sủa giới tính");
            System.out.println("4. Sửa số cmnd");
            System.out.println("5. Sủa số đt");
            System.out.println("6. Sửa email");
            System.out.println("7. Sửa loại khách");
            System.out.println("8. Sủa địa chỉ");
            System.out.println("9. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    System.out.print("Nhập tên mới: ");
                    String ten = scanner.nextLine();
                    customerLinkedList.get(index).setTen(ten);
                    break;
                case 2:
                    String ngaySinh;
                    do {
                        System.out.print("Nhập ngày sinh mới: ");
                        ngaySinh = scanner.nextLine();
                    } while (!patternBirthday.matcher(ngaySinh).matches());
                    customerLinkedList.get(index).setNgaySinh(ngaySinh);
                    break;
                case 3:
                    System.out.print("Nhập giới tính: ");
                    String gt = scanner.nextLine();
                    customerLinkedList.get(index).setGioiTinh(gt);
                    break;
                case 4:
                    String cmnd;
                    do {
                        System.out.print("Nhập cmnd mới: ");
                        cmnd = scanner.nextLine();
                    } while (!patternCmnd.matcher(cmnd).matches());
                    customerLinkedList.get(index).setCmnd(cmnd);
                    break;
                case 5:
                    String sdt;
                    do {
                        System.out.print("Nhập sdt mới: ");
                        sdt = scanner.nextLine();
                    } while (!patternPhone.matcher(sdt).matches());
                    customerLinkedList.get(index).setSdt(sdt);
                    break;
                case 6:
                    String email;
                    do {
                        System.out.print("Nhập email mới: ");
                        email = scanner.nextLine();
                    } while (!patternEmail.matcher(email).matches());
                    customerLinkedList.get(index).setEmail(email);
                    break;
                case 7:
                    String loaiKhach;
                    do {
                        System.out.print("Nhập loại khách (diamond/platinum/silver/gold/member): ");
                        loaiKhach = scanner.nextLine();
                    } while (!patternLoaiKhach.matcher(loaiKhach).matches());
                    customerLinkedList.get(index).setLoaiKhach(loaiKhach);
                    break;
                case 8:
                    System.out.print("Nhập địa chỉ: ");
                    String diaChi = scanner.nextLine();
                    customerLinkedList.get(index).setDiaChi(diaChi);
                    break;
                case 9:
                    check = false; break;
                default:
                    break;
            }
        }
    }

    @Override
    public void addNew() {
        System.out.println("==Add new customer==");
        boolean check = true;
        int id = -1;
        do {
            try {
                System.out.print("Nhập id: ");
                id = Integer.parseInt(scanner.nextLine());
                check = true;
            } catch (Exception e) {
                check = false;
            }
        } while (!check);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        String ngaySinh;
        do {
            System.out.print("Nhập ngày sinh: ");
            ngaySinh = scanner.nextLine();
        } while (!patternBirthday.matcher(ngaySinh).matches());
        System.out.print("Nhập giới tính: ");
        String gt = scanner.nextLine();
        String cmnd;
        do {
            System.out.print("Nhập số cmnd: ");
            cmnd = scanner.nextLine();
        } while (!patternCmnd.matcher(cmnd).matches());
        String sdt;
        do {
            System.out.print("Nhập sdt: ");
            sdt = scanner.nextLine();
        } while (!patternPhone.matcher(sdt).matches());
        String email;
        do {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
        } while (!patternEmail.matcher(email).matches());
        String loaiKhach;
        do {
            System.out.print("Nhập loại khách (diamond/platinum/silver/gold/member): ");
            loaiKhach = scanner.nextLine();
        } while (!patternLoaiKhach.matcher(loaiKhach).matches());
        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();
        customerLinkedList.add(new Customer(id, name, ngaySinh, gt, cmnd, sdt, email, loaiKhach, diaChi));
        System.out.println("Đã thêm thành công Customer!");
    }

    @Override
    public int findId(int id) {
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
