package model.repositories;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepositories {
    public void addNewUserTransaction(User user, int[] permisions);
    public void insertUpdateWithoutTransaction();
    public void addNewUser(User user);

    public User findById(int id);

    public List<User> findAllUsers();

    public boolean deleteUser(int id);

    public boolean updateUser(User user);

    public User getUserById(int id);

    public void insertUserStore(User user);

}
