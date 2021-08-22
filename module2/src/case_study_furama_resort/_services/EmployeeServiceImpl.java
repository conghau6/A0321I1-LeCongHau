package case_study_furama_resort._services;

import case_study_furama_resort._models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    private static ArrayList<Employee> listNhanVien;

    static {
        listNhanVien = new ArrayList<>();
    }

    @Override
    public void themMoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên: ");
        int ma = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên nhân viên: ");
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
        System.out.print("Nhập trình độ: ");
        String trinhDo = scanner.next();
        System.out.print("Nhập vị trí: ");
        String viTri = scanner.next();
        System.out.print("Nhập tiền lương: ");
        double luong = scanner.nextDouble();

        listNhanVien.add(new Employee(ma, ten, ngaySinh, gioiTinh, cmnd, sdt, email, trinhDo, viTri, luong));
    }

    @Override
    public int timIndex(int ma) {
        for(int i=0; i<listNhanVien.size(); i++){
            if(listNhanVien.get(i).getMa()==ma) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sua() {
        Scanner scanner = new Scanner(System.in);
        int ma;
        try {
            do {
                System.out.print("Nhập mã nhân viên cần sửa: ");
                ma = scanner.nextInt();
            } while (timIndex(ma)==-1);
        } catch (Exception e) {
            do {
                System.out.print("Nhập mã nhân viên cần sửa: ");
                ma = scanner.nextInt();
            } while (timIndex(ma)==-1);
        }
        System.out.println("1. Sủa tên");
        System.out.println("2. Sủa ngày sinh");
        System.out.println("3. Sửa giới tính");
        System.out.println("4. Sủa cmnd");
        System.out.println("5. Sủa số đt");
        System.out.println("6. Sủa email");
        System.out.println("7. Sủa trình độ");
        System.out.println("8. Sủa vị trí");
        System.out.println("9. Sủa tiền lương");
        System.out.print("Nhạp lựa chọn: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Nhập tên mới: ");
                scanner.skip("\\R");
                String ten = scanner.nextLine();
                int index = timIndex(ma);
                listNhanVien.get(index).setHoTen(ten);
                break;
            default: break;
        }
    }

    @Override
    public void hienThi() {
        for(Employee employee : listNhanVien) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        EmployeeServiceImpl employeeService  = new EmployeeServiceImpl();
        employeeService.themMoi();
        employeeService.hienThi();
    }

}
