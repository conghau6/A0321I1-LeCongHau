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
    public int timIndex(String tenDv) {
//        Set<Facility> facilityKeySet = listFacility.keySet();
        List<Facility> facilityKeyList = new ArrayList<>(listFacility.keySet());
        for (int i = 0; i < facilityKeyList.size(); i++) {
            if (facilityKeyList.get(i).getTenDv() == tenDv) {
                return i;
            }
        }
        return -1;
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
                System.out.println("Thêm mới House");
                System.out.println("Nhập tên house: ");
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
                System.out.println("Thêm mới Room");
                System.out.println("Nhập tên room: ");
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
        System.out.println("++Sủa FACILITY++");
        Scanner scanner = new Scanner(System.in);
        int choice;
        int index;
        String tenDv;
        System.out.print("Nhập tên dịch vụ: ");
        tenDv = scanner.nextLine();
        System.out.println("1. Sủa diện tích");
        System.out.println("2. Sủa chi phí thuê");
        System.out.println("3. Sủa số lượng người tối đa");
        System.out.println("4. Sủa kiểu thuê");
        System.out.println("5. Sủa tiêu chuẩn phòng");
        System.out.println("6. Sủa dt hồ bơi");
        System.out.println("7. Sủa số tầng");
        System.out.print("8. Sủa số lần sữ dụng: ");
        System.out.print("Nhập lựa chọn: ");
        choice = scanner.nextInt();
        index = timIndex(tenDv);
        List<Facility> facilityKey = new ArrayList<>(listFacility.keySet());
        switch (choice) {
            case 1:
                System.out.print("Nhập diện tích mới: ");
                double dienTich = scanner.nextDouble();
                Facility oldVilla = facilityKey.get(index);
                int soLanSdCu = listFacility.get(oldVilla);

                Villa newVilla = (Villa) oldVilla;
                newVilla.setTenDv(tenDv);

                listFacility.remove(oldVilla);
                listFacility.put(newVilla,soLanSdCu);
                break;
        }

    }

    @Override
    public void hienThi() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : listFacility.entrySet()) {
            System.out.println(facilityIntegerEntry.toString());
        }
    }
}
