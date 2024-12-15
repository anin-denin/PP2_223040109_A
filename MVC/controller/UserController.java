package controller;

import model.User;
import model.UserMapper;
import model.MyBatisUtil;
import view.UserView;

import org.apache.ibatis.session.SqlSession;

public class UserController {
    private UserView view;

    public UserController(UserView view) {
        this.view = view;
    }

    public void saveUser() {
        String name = view.getUserName();
        String email = view.getUserEmail();

        User user = new User(name, email);
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insertUser(user);
            session.commit();
        }
    }

    public void displayUser(String email) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(email);
            if (user != null) {
                view.displayUser(user.getName(), user.getEmail());
            } else {
                System.out.println("User tidak ditemukan.");
            }
        }
    }
}
