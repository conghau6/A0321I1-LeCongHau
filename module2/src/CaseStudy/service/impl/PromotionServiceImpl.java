package CaseStudy.service.impl;

import CaseStudy.models.Booking;
import CaseStudy.models.Promotion;
import CaseStudy.service.PromotionService;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
    static Set<Promotion> promotionSet = new HashSet<>();

    public void displayCustomerUserService() {
        System.out.print("Nhập vào năm: ");
        String nam = scanner.nextLine();
        for (Booking booking : bookingSet) {
            if (booking.getNgayBd().contains(nam)) {
                System.out.println(booking);
            }
        }
    }

    public void displayCustomerGetVoucher() {
        Stack<Booking> bookingStack = new Stack<>();
        for (Booking booking : bookingSet) {
            bookingStack.push(booking);
        }
        int tongVc = 0;
        int vc10, vc20, vc50;
        do {
            System.out.print("Nhập số lượng voucher 10%: ");
            vc10 = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập số lượng voucher 20%: ");
            vc20 = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập số lượng voucher 50%: ");
            vc50 = Integer.parseInt(scanner.nextLine());
            tongVc = vc10 + vc20 + vc50;
        } while (tongVc!=bookingStack.size());

        while ((vc10 + vc20 + vc50) != 0) {
            if (vc10 != 0) {
                promotionSet.add(new Promotion(bookingStack.peek(), "10%"));
                vc10 = vc10 - 1;
            } else if (vc20 != 0) {
                promotionSet.add(new Promotion(bookingStack.peek(), "20"));
                vc20 = vc20 - 1;
            } else if (vc50 != 0) {
                promotionSet.add(new Promotion(bookingStack.peek(), "50%"));
                vc50 = vc50 - 1;
            }
        }

        for (Promotion promotion : promotionSet) {
            System.out.println(promotion);
        }
    }
}
