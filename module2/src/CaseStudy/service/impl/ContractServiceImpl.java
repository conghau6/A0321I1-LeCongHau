package CaseStudy.service.impl;

import CaseStudy.models.Booking;
import CaseStudy.models.Contract;
import CaseStudy.models.Customer;
import CaseStudy.service.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

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
    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();

            System.out.println("Đang tạo hợp đồng cho booking có thông tin " + booking.toString());
            System.out.println("Đang tạo hợp đồng cho KH có thông tin " + customer.toString());

            System.out.print("Nhập id hợp đồng: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập tiền cọc trước: ");
            double tienCocTruoc = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập tiền thanh toan: ");
            double tongChiPhi = Double.parseDouble(scanner.nextLine());

            Contract contract = new Contract(id, booking, tienCocTruoc, tongChiPhi, customer.getId());
            contractList.add(contract);
            System.out.println("Đã tạo hợp đồng thành công!");
        }
    }

    @Override
    public void displayListContract() {
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

    @Override
    public void editContract() {

    }
}
