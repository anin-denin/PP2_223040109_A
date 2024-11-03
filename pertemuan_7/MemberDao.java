package pertemuan_7;


import db.MySqlConnection;
import model.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    public void addMember(Member member) throws SQLException {
        Connection connection = MySqlConnection.getConnection();
        String query = "INSERT INTO member (id, jenis_member_id, nama) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, member.getId());
        statement.setString(2, member.getJenisMemberId());
        statement.setString(3, member.getNama());
        statement.executeUpdate();
        connection.close();
    }

    public List<Member> getAllMembers() throws SQLException {
        Connection connection = MySqlConnection.getConnection();
        String query = "SELECT * FROM member";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Member> members = new ArrayList<>();
        while (resultSet.next()) {
            Member member = new Member(
                    resultSet.getString("id"),
                    resultSet.getString("jenis_member_id"),
                    resultSet.getString("nama")
            );
            members.add(member);
        }
        connection.close();
        return members;
    }
}

