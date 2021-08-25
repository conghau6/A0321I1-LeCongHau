package case_study_furama_resort._services;

import case_study_furama_resort._models.Facility;
import case_study_furama_resort._models.House;
import case_study_furama_resort._models.Room;
import case_study_furama_resort._models.Villa;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {

    private static Map<Facility, Integer> listFacility;

    static {
        listFacility = new LinkedHashMap<>();
        listFacility.put(new Villa("Villa_1",1000,200.4,30,'Y',5,30.5,6),0);
        listFacility.put(new House("House_1",1000, 200.4, 30, 'Y', 5, 6),0);
    }


    @Override
    public void hienThiFacilityCanBaoTri() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : listFacility.entrySet()) {
            if (facilityIntegerEntry.getValue() == 5) {
                System.out.println(facilityIntegerEntry.toString());
            }
        }
    }

    @Override
    public void themMoi() {
        System.out.println("++THÊM MỚI FACILITY++");
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Thêm mới House");
        System.out.println("3. Thêm mới Room");
        System.out.println("4. Back to menu");
        System.out.print("Nhập lựa chọn: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String tenDv;
        double dienTich;
        double chiPhiThue;
        int soLuongNg;
        int soTang;
        int soLanSd;
        int tc;
        char kieuThue;
        switch (choice) {
            case 1:
                System.out.println("++THÊM MỚI VILLA++");
                System.out.println("Nhập tên villa: ");
                scanner.skip("\\R");
                tenDv = scanner.nextLine();
                System.out.print("Nhập Diện tích sd: ");
                dienTich = scanner.nextDouble();
                System.out.print("Nhập chi phí thuê: ");
                chiPhiThue = scanner.nextDouble();
                System.out.print("Nhập sl người tối đa: ");
                soLuongNg = scanner.nextInt();
                System.out.print("Nhập kiểu thuê(D/M/Y): ");
                kieuThue = scanner.next().charAt(0);
                System.out.print("Nhập tiêu chuẩn phòng (1-5 sao): ");
                tc = scanner.nextInt();
                System.out.print("Nhập diện tích hồ bơi: ");
                double dtHoBoi = scanner.nextDouble();
                System.out.print("Nhập số tầng: ");
                soTang = scanner.nextInt();

                System.out.print("Nhập số lần đã sữ dụng: ");
                soLanSd = scanner.nextInt();
                Villa villa = new Villa(tenDv, dienTich, chiPhiThue, soLuongNg, kieuThue, tc, dtHoBoi, soTang);
                listFacility.put(villa, soLanSd);
                break;
            case 2:
                System.out.println("++THÊM MỚI HOUSE++");
                System.out.println("Nhập tên house: ");
                scanner.skip("\\R");
                tenDv = scanner.nextLine();
                System.out.print("Nhập Diện tích sd: ");
                dienTich = scanner.nextDouble();
                System.out.print("Nhập chi phí thuê: ");
                chiPhiThue = scanner.nextDouble();
                System.out.print("Nhập sl người tối đa: ");
                soLuongNg = scanner.nextInt();
                System.out.print("Nhập kiểu thuê(D/M/Y): ");
                kieuThue = scanner.next().charAt(0);
                System.out.print("Nhập tiêu chuẩn phòng (1-5 sao): ");
                tc = scanner.nextInt();
                System.out.print("Nhập số tầng: ");
                soTang = scanner.nextInt();

                System.out.print("Nhập số lần đã sữ dụng: ");
                soLanSd = scanner.nextInt();
                House house = new House(tenDv, dienTich, chiPhiThue, soLuongNg, kieuThue, tc, soTang);
                listFacility.put(house, soLanSd);
                break;
            case 3:
                System.out.println("++THÊM MỚI ROOM++");
                System.out.println("Nhập tên room: ");
                scanner.skip("\\R");
                tenDv = scanner.nextLine();
                System.out.print("Nhập Diện tích sd: ");
                dienTich = scanner.nextDouble();
                System.out.print("Nhập chi phí thuê: ");
                chiPhiThue = scanner.nextDouble();
                System.out.print("Nhập sl người tối đa: ");
                soLuongNg = scanner.nextInt();
                System.out.print("Nhập kiểu thuê(D/M/Y): ");
                kieuThue = scanner.next().charAt(0);
                System.out.print("DV free");
                String dvFree = scanner.nextLine();

                System.out.print("Nhập số lần đã sữ dụng: ");
                soLanSd = scanner.nextInt();
                Room room = new Room(tenDv, dienTich, chiPhiThue, soLuongNg, kieuThue, dvFree);
                listFacility.put(room, soLanSd);

                break;
            case 4:
                break;
            default:
                break;
        }
    }

    @Override
    public void sua() {
        return;
    }

    @Override
    public void hienThi() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : listFacility.entrySet()) {
            System.out.println(facilityIntegerEntry.toString());
        }
    }
}
