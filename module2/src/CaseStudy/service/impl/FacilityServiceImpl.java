package CaseStudy.service.impl;

import CaseStudy.models.Facility;
import CaseStudy.models.House;
import CaseStudy.models.Room;
import CaseStudy.models.Villa;
import CaseStudy.service.FacilityService;
import CaseStudy.utils.RegexData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_STR = "^[A-Z][a-z]+$]";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_SO_NGUOI = "^[1-9]|([1][0-9])$";
    Pattern pattern = Pattern.compile(REGEX_SO_NGUOI);
    public static final String REGEX_DT_HOBOI = "^([3-9]\\d)|([1-9]\\d{2,})$";

    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + " Số lần đã thuê " + element.getValue());
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void addNew() {
        boolean check = true;
        while (check) {
            System.out.println("==Add new Facility==");
            System.out.println("1. Add new Villa");
            System.out.println("2. Add new House");
            System.out.println("3. Add new Room");
            System.out.println("4. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void addNewVilla() {
        System.out.println("==Add new Villa==");
        String id = inputId();
        String tenDv = nhapTenDv();
        System.out.print("Nhập dt sũ dụng: ");
        double dt = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập phí thuê: ");
        double phiThue = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng người tối đa: ");
        int ngToiDa = Integer.parseInt(scanner.nextLine());
        String kieuThue;
        do {
            System.out.print("Nhập kiểu thuê (năm/tháng/ngày/giờ): ");
            kieuThue = scanner.nextLine();
        } while (!validateKieuThue.matcher(kieuThue).matches());
        System.out.print("Nhập tiêu chuẩn phòng: ");
        String tieuChuan = scanner.nextLine();
        System.out.print("Nhập diệnt tích hồ bơi: ");
        double dtHoBoi = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số tầng: ");
        int soTang = Integer.parseInt(scanner.nextLine());

        Villa villa = new Villa(id, tenDv, dt, phiThue, ngToiDa, kieuThue, tieuChuan, dtHoBoi, soTang);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Đã thêm thành công villa!");
    }

    private String inputId() {
        System.out.print("Nhập id, mã dịch vụ: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_ID_VILLA,"Bạn đã nhấp sai định dạng (SVVL-XXXX)\n Nhâp id, mã dv: ");
    }

    private String nhapTenDv() {
        System.out.print("Nhập tên dịch vụ: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng");
    }

    public void addNewHouse() {
        System.out.println("==Add new House==");
        System.out.print("Nhập id: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên dịch vụ: ");
        String tenDv = scanner.nextLine();
        System.out.print("Nhập dt sũ dụng: ");
        double dt = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập phí thuê: ");
        double phiThue = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng người tối đa: ");
        int ngToiDa = Integer.parseInt(scanner.nextLine());
        String kieuThue;
        do {
            System.out.print("Nhập kiểu thuê (năm/tháng/ngày/giờ): ");
            kieuThue = scanner.nextLine();
        } while (!validateKieuThue.matcher(kieuThue).matches());
        System.out.print("Nhập tiêu chuẩn phòng: ");
        String tieuChuan = scanner.nextLine();
        System.out.print("Nhập số tâng: ");
        int soTang = Integer.parseInt(scanner.nextLine());

        House house = new House(id,tenDv, dt, phiThue, ngToiDa, kieuThue, tieuChuan, soTang);
        facilityIntegerMap.put(house,0);
        System.out.println("Đã thêm thành công house!");
    }

    public void addNewRoom() {
        System.out.println("==Add new Room==");
        System.out.print("Nhập id: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên dịch vụ: ");
        String tenDv = scanner.nextLine();
        System.out.print("Nhập dt sũ dụng: ");
        double dt = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập phí thuê: ");
        double phiThue = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng người tối đa: ");
        int ngToiDa = Integer.parseInt(scanner.nextLine());
        String kieuThue;
        do {
            System.out.print("Nhập kiểu thuê (năm/tháng/ngày/giờ): ");
            kieuThue = scanner.nextLine();
        } while (!validateKieuThue.matcher(kieuThue).matches());
        System.out.print("Dịch vụ miễn phí đi kèm: ");
        String dvFree = scanner.nextLine();

        Room room = new Room(id,tenDv, dt, phiThue, ngToiDa, kieuThue, dvFree);
        facilityIntegerMap.put(room,0);
        System.out.println("Đã thêm thành công room!");
    }

    @Override
    public void displayFacilityMaintenance() {
        for(Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            if(element.getValue() == 5) {
                System.out.println(element.getKey() + " Cần bảo trì!");
            }
        }
    }
}
