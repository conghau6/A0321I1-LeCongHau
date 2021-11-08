package model.repositories.impl;

import model.bean.BenhAn;
import model.repositories.BenhAnRepositories;
import model.repositories.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoriesImpl implements BenhAnRepositories {
    public static final String SELECT_ALL_BENH_AN = "select * from benh_an inner join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan;";
    public static final String UPDATE_BENH_AN = "update benh_an inner join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan\n" +
            "set benh_nhan.ten_benh_nhan = ?,\n" +
            "benh_an.ngay_nhap_vien = ?,\n" +
            "benh_an.ngay_ra_vien = ?,\n" +
            "benh_an.ly_do = ? \n" +
            "where benh_nhan.ma_benh_nhan = ?;";
    public static final String DELETE_BENH_AN = "delete from benh_an where benh_an.ma_benh_nhan = ?;";
    public static final String DELETE_BENH_NHAN = "delete from benh_nhan where benh_nhan.ma_benh_nhan = ?;";
    public static final String FIND_BY_ID = "select * from benh_an inner join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan where benh_an.ma_benh_nhan = ?;";
    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENH_AN);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String maBenhAn = resultSet.getString("ma_benh_an");
                    String maBenhNhan = resultSet.getString("ma_benh_nhan");
                    String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                    Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                    Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                    String lyDo = resultSet.getString("ly_do");

                    BenhAn benhAn = new BenhAn(maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo);
                    benhAnList.add(benhAn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return benhAnList;
    }

    @Override
    public BenhAn findById(String id) {
        BenhAn benhAn = null;
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
                preparedStatement.setString(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String maBenhAn = resultSet.getString("ma_benh_an");
                    String maBenhNhan = resultSet.getString("ma_benh_nhan");
                    String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                    Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                    Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                    String lyDo = resultSet.getString("ly_do");

                    benhAn = new BenhAn(maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return benhAn;
    }

    @Override
    public void update(BenhAn benhAn) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENH_AN);
                preparedStatement.setString(1,benhAn.getTenBenhNhan());
                preparedStatement.setDate(2,benhAn.getNgayNhapVien());
                preparedStatement.setDate(3,benhAn.getNgayRaVien());
                preparedStatement.setString(4,benhAn.getLyDo());
                preparedStatement.setString(5,benhAn.getMaBenhNhan());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException throwables) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                PreparedStatement xoaBenhAn = connection.prepareStatement(DELETE_BENH_AN);
                PreparedStatement xoaBenhNhan = connection.prepareCall(DELETE_BENH_NHAN);
                xoaBenhAn.setString(1,id);
                xoaBenhNhan.setString(1,id);
                xoaBenhAn.executeUpdate();
                xoaBenhNhan.executeUpdate();
                connection.commit();
            } catch (SQLException throwables) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }
        }
    }
}
