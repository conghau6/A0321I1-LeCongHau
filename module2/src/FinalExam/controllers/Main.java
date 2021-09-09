package FinalExam.controllers;

import FinalExam.models.BenhAn;
import FinalExam.service.Them;
import FinalExam.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<BenhAn> benhAnList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private static int soThuTu = 1;

    public void displayMainMenu () {
        boolean check = true;
        while (check) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--");
            System.out.println("Chọn chức năng theo số để tiếp tục: ");
            System.out.println("1. Them mới");
            System.out.println("2. Xoá");
            System.out.println("3. Xem danh sách bệnh án");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            Scanner scanner = new Scanner(System.in);
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
            }

            switch (choice) {
                case 1:
                    Them.themMoi();
                    break;
                case 2:
                    xoa();
                    break;
                case 3:
                    hienThi();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }



    public void xoa() {
        System.out.println("==XOÁ BÊNH ÁN==");
        benhAnList = (List<BenhAn>) ReadAndWrite.read("./src/FinalExam/data/medical_records.csv");
        Scanner scanner = new Scanner(System.in);
        String maBenhAn = null;
        int index = -1;
        do {
            System.out.print("Nhập mã bênh án: ");
            maBenhAn = scanner.nextLine();
            index = timIndex(maBenhAn);
            if(index == -1) {
                System.out.println("Mã bệnh án không tồn tại");
            }
        }while (index == -1);

        String xacNhan = null;
        do {
            System.out.print("Xoá bênh án này (yes/no)?: ");
            xacNhan = scanner.nextLine();
        }while (!(xacNhan.equalsIgnoreCase("yes") || xacNhan.equalsIgnoreCase("no")));
        if(xacNhan.equalsIgnoreCase("yes")) {
            benhAnList.remove(index);
            ReadAndWrite.write(benhAnList,"./src/FinalExam/data/medical_records.csv");
        }
    }

    public void hienThi() {
        System.out.println("==DANH SÁCH BỆNH ÁN==");
        benhAnList = (List<BenhAn>) ReadAndWrite.read("./src/FinalExam/data/medical_records.csv");
        for(BenhAn benhAn : benhAnList) {
            System.out.println(benhAn.toString());
        }
    }

    public int timIndex (String ma) {
        benhAnList = (List<BenhAn>) ReadAndWrite.read("./src/FinalExam/data/medical_records.csv");
        for(int i=0; i<benhAnList.size(); i++) {
            if(benhAnList.get(i).getMaBenhAn().equals(ma)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Main mainMenu = new Main();
        while (true) {
            mainMenu.displayMainMenu();
        }
    }
}
