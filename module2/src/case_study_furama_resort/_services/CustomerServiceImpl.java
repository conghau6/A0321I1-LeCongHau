package case_study_furama_resort._services;

import case_study_furama_resort._models.Customer;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static LinkedList<Customer> listKhachHang;

    static {
        listKhachHang = new LinkedList<>();
    }

    @Override
    public void themMoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++Thêm khách hàng+++");
        System.out.print("Nhập mã khách hàng: ");
        int ma = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên khách hàng: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String ngaySinh = scanner.next();
        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.next();
        System.out.print("Nhập số CMND: ");
        scanner.skip("\\R");
        String cmnd = scanner.nextLine();
        System.out.print("Nhập số đt: ");
        String sdt = scanner.next();
        System.out.print("Nhập email: ");
        String email = scanner.next();
        System.out.print("Loại khách(Diamond/Platinum/Gold/Silver/Member): ");
        String loaiKhach = scanner.next();
        System.out.print("Nhập địa chỉ: ");
        scanner.skip("\\R");
        String diaChi = scanner.nextLine();

        listKhachHang.add(new Customer(ma, ten, ngaySinh, gioiTinh, cmnd, sdt, email, loaiKhach, diaChi));
    }

    @Override
    public int timIndex(int ma) {
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getMa() == ma) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++Chỉnh sửa thông tin khách hàng+++");
        int ma;
        do {
            System.out.print("Nhập mã khách hàng cần sửa: ");
            ma = scanner.nextInt();
        } while (timIndex(ma) == -1);
        int index = timIndex(ma);
        System.out.println("1. Sủa tên");
        System.out.println("2. Sủa ngày sinh");
        System.out.println("3. Sửa giới tính");
        System.out.println("4. Sủa cmnd");
        System.out.println("5. Sủa số đt");
        System.out.println("6. Sủa email");
        System.out.println("7. Sủa loại khách");
        System.out.println("8. Sủa địa chỉ");
        System.out.print("Nhạp lựa chọn: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Nhập tên mới: ");
                scanner.skip("\\R");
                String ten = scanner.nextLine();
                listKhachHang.get(index).setHoTen(ten);
                break;
            case 2:
                System.out.print("Nhập ngày sinh mới: ");
                String ngaySinh = scanner.next();
                listKhachHang.get(index).setNgaySinh(ngaySinh);
                break;
            case 3:
                System.out.print("Nhập giới tính mới: ");
                String gioiTinh = scanner.next();
                listKhachHang.get(index).setGioiTinh(gioiTinh);
                break;
            case 4:
                System.out.print("Nhập cmnd mới: ");
                String cmnd = scanner.next();
                listKhachHang.get(index).setCmnd(cmnd);
                break;
            case 5:
                System.out.print("Nhập số đt mới: ");
                String sdt = scanner.next();
                listKhachHang.get(index).setSdt(sdt);
                break;
            case 6:
                System.out.print("Nhập email mới: ");
                String email = scanner.next();
                listKhachHang.get(index).setEmail(email);
                break;
            default:
                break;
        }
    }

    @Override
    public void hienThi() {
        System.out.println("+++Danh sách khách hàng+++");
        for (Customer customer : listKhachHang) {
            System.out.println(customer);
        }
    }

}