package model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    void insertUser(User user);

    @Select("SELECT * FROM users WHERE email = #{email}")
    User selectUser(String email);
}
