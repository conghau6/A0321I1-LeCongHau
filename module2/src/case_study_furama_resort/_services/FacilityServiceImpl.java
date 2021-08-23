package case_study_furama_resort._services;

import case_study_furama_resort._models.Facility;
import case_study_furama_resort._models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService{

    private static Map<Facility, Integer> listFacility;

    static {
        listFacility = new LinkedHashMap<>();
    }
    @Override
    public void hienThiFacilityCanBaoTri() {
        for(Map.Entry<Facility, Integer> facilityIntegerEntry : listFacility.entrySet()){
            if(facilityIntegerEntry.getValue() == 5) {
                System.out.println(facilityIntegerEntry.toString());
            }
        }
    }

    @Override
    public void themMoi() { //Thếu thêm mới room và house
        System.out.println("++THÊM MỚI FACILITY++");
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Thêm mới House");
        System.out.println("3. Thêm mới Room");
        System.out.println("4. Back to menu");
        System.out.print("Nhập lựa chọn: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("++THÊM MỚI VILLA++");
                System.out.print("Nhập Diện tích sd: ");
                double dienTich = scanner.nextDouble();
                System.out.print("Nhập chi phí thuê: ");
                double chiPhiThue = scanner.nextDouble();
                System.out.print("Nhập sl người tối đa: ");
                int soLuongNg = scanner.nextInt();
                System.out.print("Nhập kiểu thuê(D/M/Y): ");
                char kieuThue = scanner.next().charAt(0);
                System.out.print("Nhập tiêu chuẩn phòng (1-5 sao): ");
                int tc = scanner.nextInt();
                System.out.print("Nhập diện tích hồ bơi: ");
                double dtHoBoi = scanner.nextDouble();
                System.out.print("Nhập số tầng: ");
                int soTang = scanner.nextInt();

                System.out.print("Nhập số lần đã sữ dụng: ");
                int soLan = scanner.nextInt();
                Villa villa = new Villa(dienTich,chiPhiThue,soLuongNg,kieuThue,tc,dtHoBoi,soTang);
                listFacility.put(villa, soLan);

                break;
        }
    }

    @Override
    public void sua() {

    }

    @Override
    public void hienThi() {
        for(Map.Entry<Facility, Integer> facilityIntegerEntry : listFacility.entrySet()){
            System.out.println(facilityIntegerEntry.toString());
        }
    }
}
