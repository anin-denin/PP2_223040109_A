package MembershipORM.libs.src.dao;


import model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class JenisMemberDao {
    private SqlSession session;

    public JenisMemberDao(SqlSession session) {
        this.session = session;
    }

    public List<JenisMember> selectAll() {
        return session.selectList("mapper.JenisMemberMapper.selectAll");
    }
}
