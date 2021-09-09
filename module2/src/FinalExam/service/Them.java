package FinalExam.service;

import FinalExam.models.BenhAn;
import FinalExam.models.BenhAnThuong;
import FinalExam.models.BenhAnVip;
import FinalExam.utils.ReadAndWrite;
import FinalExam.utils.RegexData;

import java.util.List;
import java.util.Scanner;

import static FinalExam.utils.CheckNgay.tongNgay;

public class Them implements ListRegex {
    private static List<BenhAn> benhAnList = (List<BenhAn>) ReadAndWrite.read("./src/FinalExam/data/medical_records.csv");
    private static Scanner scanner = new Scanner(System.in);
    public static void themMoi() {
        boolean check = true;
        while (check) {
            System.out.println("==THÊM MỚI BỆNH ÁN==");
            System.out.println("1. Bệnh án cho bênh nhân VIP");
            System.out.println("2. Bệnh án cho bệnh nhân thường");
            System.out.println("3. Trở lại");
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
            }

            switch (choice) {
                case 1:
                    themBenhAnVip();
                    break;
                case 2:
                    themBenhAnThuong();
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.println("Nhập sai, nhập lại");
                    break;
            }
        }
    }

    public static void themBenhAnVip() {
        System.out.println("==THÊM BỆNH ÁN VIP==");
        System.out.print("Nhập mã bệnh án (BA-XXX): ");
        String maBenhAn = RegexData.regexStr(scanner.nextLine(),REGEX_MA_BA,"Nhập sai định dạng");
        System.out.print("Nhập mã bệnh nhân (BN-XXX): ");
        String maBenhNhan = RegexData.regexStr(scanner.nextLine(),REGEX_MA_BN,"Nhập sai định dạng");
        System.out.print("Nhâp tên bệnh nhân: ");
        String tenBenhNhanh = RegexData.regexStr(scanner.nextLine(),REGEX_NAME,"Nhập sai định dạng");
        System.out.print("Ngày nhập viện (dd/MM/yyyy): ");
        String ngayNhapVien = RegexData.regexStr(scanner.nextLine(),REGEX_NGAY,"Nhập sai định dạng");
        String ngayRaVien = null;
        do {
            System.out.print("Ngày ra viện (dd/MM/yyyy): ");
            ngayRaVien = RegexData.regexStr(scanner.nextLine(), REGEX_NGAY, "Nhập sai định dạng");
        } while (tongNgay(ngayRaVien) - tongNgay(ngayNhapVien) < 0 );
        System.out.print("Lý do nhập viện: ");
        String lyDo = scanner.nextLine();
        System.out.print("Nhập loại VIP: ");
        String loaiVip = RegexData.regexStr(scanner.nextLine(),REGEX_VIP,"Nhập sai định dạng");
        System.out.print("Thời hạn VIP (dd/MM/yyyy): ");
        String thoiHanVip = RegexData.regexStr(scanner.nextLine(),REGEX_NGAY,"Nhập sai định dạng");

        BenhAnVip benhAnVip = new BenhAnVip(1, maBenhAn, maBenhNhan, tenBenhNhanh, ngayNhapVien,
                ngayRaVien, lyDo, loaiVip, thoiHanVip);
        benhAnList.add(benhAnVip);
        ReadAndWrite.write(benhAnList,"./src/FinalExam/data/medical_records.csv");
        System.out.println("Đã thêm thành công!");
    }

    public static void themBenhAnThuong() {
        System.out.println("==THÊM BỆNH ÁN THƯỜNG==");
        System.out.print("Nhập mã bệnh án (BA-XXX): ");
        String maBenhAn = RegexData.regexStr(scanner.nextLine(),REGEX_MA_BA,"Nhập sai định dạng");
        System.out.print("Nhập mã bệnh nhân (BN-XXX): ");
        String maBenhNhan = RegexData.regexStr(scanner.nextLine(),REGEX_MA_BN,"Nhập sai định dạng");
        System.out.print("Nhâp tên bệnh nhân: ");
        String tenBenhNhanh = RegexData.regexStr(scanner.nextLine(),REGEX_NAME,"Nhập sai định dạng");
        System.out.print("Ngày nhập viện (dd/MM/yyyy): ");
        String ngayNhapVien = RegexData.regexStr(scanner.nextLine(),REGEX_NGAY,"Nhập sai định dạng");
        String ngayRaVien = null;
        do {
            System.out.print("Ngày ra viện (dd/MM/yyyy): ");
            ngayRaVien = RegexData.regexStr(scanner.nextLine(), REGEX_NGAY, "Nhập sai định dạng");
        } while (tongNgay(ngayRaVien) - tongNgay(ngayNhapVien) < 0 );
        System.out.print("Lý do nhập viện: ");
        String lyDo = scanner.nextLine();
        System.out.print("Phí nằm viện: ");
        double phiNamVien = Double.parseDouble(scanner.nextLine());

        BenhAnThuong benhAnThuong = new BenhAnThuong(1, maBenhAn, maBenhNhan, tenBenhNhanh, ngayNhapVien,
                ngayRaVien, lyDo,phiNamVien);
        benhAnList.add(benhAnThuong);
        ReadAndWrite.write(benhAnList,"./src/FinalExam/data/medical_records.csv");
        System.out.println("Đã thêm thành công!");
    }
}
