package CaseStudy.service.impl;

import CaseStudy.models.Employee;
import CaseStudy.service.EmployeeService;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    public static ArrayList<Employee> employeeList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
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
            System.out.println("==Edit employee==");
            System.out.println("1. Sủa tên");
            System.out.println("2. Sửa ngày sinh");
            System.out.println("3. Sủa giới tính");
            System.out.println("4. Sửa số cmnd");
            System.out.println("5. Sủa số đt");
            System.out.println("6. Sửa email");
            System.out.println("7. Sửa trình độ");
            System.out.println("8. Sủa vị trí");
            System.out.println("9. Sửa tiền lương");
            System.out.println("10. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    System.out.print("Nhập tên mới: ");
                    String ten = scanner.nextLine();
                    employeeList.get(index).setTen(ten);
                    break;
                case 2:
                    String ngaySinh;
                    do {
                        System.out.print("Nhập ngày sinh mới: ");
                        ngaySinh = scanner.nextLine();
                    } while (!validateBirthDay.matcher(ngaySinh).matches());
                    employeeList.get(index).setNgaySinh(ngaySinh);
                    break;
                case 3:
                    System.out.print("Nhập giới tính: ");
                    String gt = scanner.nextLine();
                    employeeList.get(index).setGioiTinh(gt);
                    break;
                case 4:
                    String cmnd;
                    do {
                        System.out.print("Nhập cmnd mới: ");
                        cmnd = scanner.nextLine();
                    } while (!validateCmnd.matcher(cmnd).matches());
                    employeeList.get(index).setCmnd(cmnd);
                    break;
                case 5:
                    String sdt;
                    do {
                        System.out.print("Nhập sdt mới: ");
                        sdt = scanner.nextLine();
                    } while (!validatePhone.matcher(sdt).matches());
                    employeeList.get(index).setSdt(sdt);
                    break;
                case 6:
                    String email;
                    do {
                        System.out.print("Nhập email mới: ");
                        email = scanner.nextLine();
                    } while (!validateEmail.matcher(email).matches());
                    employeeList.get(index).setEmail(email);
                    break;
                case 7:
                    String trinhDo;
                    do {
                        System.out.print("Nhập trình độ (trung cấp/cao đẳng/đại học): ");
                        trinhDo = scanner.nextLine();
                    } while (!patternLevel.matcher(trinhDo).matches());
                    employeeList.get(index).setTrinhDo(trinhDo);
                    break;
                case 8:
                    String viTri;
                    do {
                        System.out.print("Nhập vị trí (lễ tân/phục vụ/chuyên viên/giám sát/quản lý/giám đốc): ");
                        viTri = scanner.nextLine();
                    } while (!validateViTri.matcher(viTri).matches());
                    employeeList.get(index).setViTri(viTri);
                    break;
                case 9:
                    System.out.print("Nhập tiền lương mới: ");
                    double luong = Double.parseDouble(scanner.nextLine());
                    employeeList.get(index).setLuong(luong);
                    break;
                case 10: check = false; break;
                default: break;
            }
        }
    }

    @Override
    public void addNew() {
        System.out.println("==Add new facility==");
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
        } while (!validateBirthDay.matcher(ngaySinh).matches());
        System.out.print("Nhập giới tính: ");
        String gt = scanner.nextLine();
        String cmnd;
        do {
            System.out.print("Nhập số cmnd: ");
            cmnd = scanner.nextLine();
        } while (!validateCmnd.matcher(cmnd).matches());
        String sdt;
        do {
            System.out.print("Nhập sdt: ");
            sdt = scanner.nextLine();
        } while (!validatePhone.matcher(sdt).matches());
        String email;
        do {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
        } while (!validateEmail.matcher(email).matches());
        String trinhDo;
        do {
            System.out.print("Nhập trình đọ (trung cấp/cao đẳng/đại học): ");
            trinhDo = scanner.nextLine();
        } while (!patternLevel.matcher(trinhDo).matches());
        String viTri;
        do {
            System.out.print("Nhập vị trí (lễ tân/phục vụ/chuyên viên/giám sát/quản lý/giám đốc): ");
            viTri = scanner.nextLine();
        } while (!validateViTri.matcher(viTri).matches());
        System.out.print("Nhập tiền lương: ");
        double luong = Double.parseDouble(scanner.nextLine());
        employeeList.add(new Employee(id, name, ngaySinh, gt, cmnd, sdt, email, trinhDo, viTri, luong));
        System.out.println("Đã thêm thành công Employee!");
    }

    @Override
    public int findId(int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
