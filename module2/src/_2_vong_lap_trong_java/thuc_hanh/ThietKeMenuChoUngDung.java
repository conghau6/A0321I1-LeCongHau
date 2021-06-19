package _2_vong_lap_trong_java.thuc_hanh;

public class ThietKeMenuChoUngDung {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int lua_chon = -1;
        while (lua_chon!=0){
            System.out.println("Menu");
            System.out.println("1. Vẽ hình tam giác");
            System.out.println("2. Vẽ hình vuông");
            System.out.println("3. Vẻ hình chữ nhật");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn: ");
            lua_chon = scanner.nextInt();

            switch (lua_chon) {
                case 1:
                    System.out.println("Vẽ hình tam giác");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Vẽ hình vuông");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");

                    break;
                case 3:
                    System.out.println("Vẽ hình chữ nhật");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Không có lựa chọn!");
            }
        }
    }
}
