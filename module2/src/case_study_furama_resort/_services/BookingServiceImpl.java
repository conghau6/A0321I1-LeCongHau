package case_study_furama_resort._services;

import case_study_furama_resort._models.Booking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {

    private static TreeSet<Booking> bookingTreeSet;

    static {
        bookingTreeSet = new TreeSet<>();
    }

    @Override
    public void themMoi() {
        System.out.println("++THÊM MỚI BOOKING++");
        System.out.println("-->Mã khách hàng: ");
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        ArrayList<Integer> lisMaKH = customerService.listMaKhachHang();
        for(int i=0; i<lisMaKH.size(); i++){
            System.out.println("No." + i + ": " + lisMaKH.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần booking: ");
        int ma = -1;
        do {
            ma = scanner.nextInt();
        } while (ma < 0 || ma>lisMaKH.size());
        ma =  lisMaKH.get(ma);

        System.out.println("Lựa chọn dịch vụ: ");
        System.out.println("      ----1. Villa");
        System.out.println();

        System.out.print("Nhập ngày bắt đầu: ");
        String ngayBd = scanner.next();
        System.out.print("Nhập ngày kết thúc: ");
        String ngayKt = scanner.next();
        System.out.print("Nhập mã khách hàng: ");
        int maKh = scanner.nextInt();
        System.out.print("Nhập tên dịch vụ: ");
        scanner.skip("\\R");
        String tenDv = scanner.nextLine();
        System.out.print("Nhập loại dịch vụ (Villa/House/Room): ");
        String loaiDv = scanner.nextLine();

        Booking booking = new Booking(ma, ngayBd, ngayKt, maKh, tenDv, loaiDv);
        bookingTreeSet.add(booking);

    }

    @Override
    public void sua() {

    }

    @Override
    public void hienThi() {
        for(Booking booking : bookingTreeSet) {
            System.out.println(booking);
        }
    }
}
