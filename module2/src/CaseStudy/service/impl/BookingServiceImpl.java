package CaseStudy.service.impl;

import CaseStudy.models.Booking;
import CaseStudy.models.Customer;
import CaseStudy.models.Facility;
import CaseStudy.models.Villa;
import CaseStudy.service.BookingService;
import CaseStudy.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static {
        customerList.add(new Customer(1,"hau,", "31/10/2001", "nam", "939393939", "0777588592",
                "hau@gmail.com", "diamond", "qn"));
        customerList.add(new Customer(2,"hau,", "31/10/2002", "nữ", "939777739", "0367588332",
                "hau1@gmail.com", "diamond", "qn"));
        customerList.add(new Customer(3,"hau,", "31/10/2003", "nam", "939392222", "0367588892",
                "hau2@gmail.com", "diamond", "qn"));

        facilityIntegerMap.put(new Villa(1,"villa1",100,300,10,"ngay",
                "Vip",300.2,2), 0);
        facilityIntegerMap.put(new Villa(2,"villa2",154,330,40,"thang",
                "Vip",30.2,10), 0);
    }

    public Set<Booking> sendBooking() {
        return bookingSet;
    }
    @Override
    public void display() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void addNew() {

    }

    @Override
    public void addBooking() {
        int id = 1;
        if(!bookingSet.isEmpty()){
            id = bookingSet.size();
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.print("Nhập ngày bắt đầu thuê: ");
        String ngayBd = scanner.nextLine();
        System.out.print("Nhập ngày trả phòng: ");
        String ngayKt = scanner.nextLine();
        Booking booking = new Booking(id,ngayBd,ngayKt,customer,facility);

        bookingSet.add(booking);
        facilityIntegerMap.put(facility, facilityIntegerMap.get(facility) + 1);
        System.out.println("Đã booking thành công!");
    }

    @Override
    public void displayListBooking() {
        for(Booking booking : bookingSet){
            System.out.println(booking.toString());
        }
    }

    public static Customer chooseCustomer () {
        System.out.println("Danh sách khách hàng: ");
        for(Customer customer : customerList){
            System.out.println(customer.toString());
        }

        System.out.print("Nhập id khách hàng: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());

        while (check) {
            for(Customer customer : customerList) {
                if(id == customer.getId()){
                    check = false;
                    return customer;
                }
            }

            if(check) {
                System.out.println("Nhập sai id, hãy nhập lại");
                id = Integer.parseInt(scanner.nextLine());
            }
        }

        return null;

    }
    public static Facility chooseFacility () {
        System.out.println("Danh sách dịch vụ: ");
        for(Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.print("Nhập id dịch vụ : ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());

        while (check) {
            for(Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                if(id==entry.getKey().getId()){
                    check = false;
                    return entry.getKey();
                }
            }

            if(check) {
                System.out.println("Vui lòng nhập lại dịch vụ");
                id = scanner.nextInt();
            }
        }

        return null;

    }
}
