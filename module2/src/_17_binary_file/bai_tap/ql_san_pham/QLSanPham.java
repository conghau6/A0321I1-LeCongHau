package _17_binary_file.bai_tap.ql_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLSanPham {

    public static void themSp () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        int maSp = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String tenSp = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String hangSx = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double gia = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập mô tả: ");
        String moTa = scanner.nextLine();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./src/_17_binary_file/bai_tap/ql_san_pham/MyFile.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            List<SanPham> listSp = new ArrayList<>();
            listSp.add(new SanPham(maSp,tenSp,hangSx,gia,moTa));
            listSp.add(new SanPham(maSp,tenSp,hangSx,gia,moTa));
            listSp.add(new SanPham(maSp,tenSp,hangSx,gia,moTa));
            objectOutputStream.writeObject(listSp);
            objectOutputStream.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hienThiSp () {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/_17_binary_file/bai_tap/ql_san_pham/MyFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<SanPham> sanPhamList = (List<SanPham>) objectInputStream.readObject();
            for(SanPham sanPham : sanPhamList) {
                System.out.println(sanPham);
            }
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        themSp();
        hienThiSp();
    }
}
