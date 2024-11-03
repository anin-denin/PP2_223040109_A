package pertemuan_7;


import db.MySqlConnection;
import model.JenisMember;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JenisMemberDao {
    public void addJenisMember(JenisMember jenisMember) throws SQLException {
        Connection connection = MySqlConnection.getConnection();
        String query = "INSERT INTO jenis_member (id, nama) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, jenisMember.getId());
        statement.setString(2, jenisMember.getNama());
        statement.executeUpdate();
        connection.close();
    }

    public List<JenisMember> getAllJenisMembers() throws SQLException {
        Connection connection = MySqlConnection.getConnection();
        String query = "SELECT * FROM jenis_member";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<JenisMember> jenisMembers = new ArrayList<>();
        while (resultSet.next()) {
            JenisMember jenisMember = new JenisMember(
                    resultSet.getString("id"),
                    resultSet.getString("nama")
            );
            jenisMembers.add(jenisMember);
        }
        connection.close();
        return jenisMembers;
    }
}

