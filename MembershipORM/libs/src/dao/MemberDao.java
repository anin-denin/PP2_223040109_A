package MembershipORM.libs.src.dao;


import model.Member;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class MemberDao {
    private SqlSession session;

    public MemberDao(SqlSession session) {
        this.session = session;
    }

    public List<Member> selectAll() {
        return session.selectList("mapper.MemberMapper.selectAll");
    }
}
