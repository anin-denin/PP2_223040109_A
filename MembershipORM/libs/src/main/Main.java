package MembershipORM.libs.src.main;



import dao.MemberDao;
import dao.JenisMemberDao;
import model.Member;
import model.JenisMember;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Membaca konfigurasi MyBatis
        Reader reader = Resources.getResourceAsReader("resources/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            // Operasi untuk tabel Member
            MemberDao memberDao = new MemberDao(session);
            List<Member> members = memberDao.selectAll();
            System.out.println("Daftar Member:");
            members.forEach(m -> System.out.println("ID: " + m.getId() + ", Nama: " + m.getNama()));

            // Operasi untuk tabel JenisMember
            JenisMemberDao jenisMemberDao = new JenisMemberDao(session);
            List<JenisMember> jenisMembers = jenisMemberDao.selectAll();
            System.out.println("Daftar Jenis Member:");
            jenisMembers.forEach(j -> System.out.println("ID: " + j.getId() + ", Nama Jenis: " + j.getNamaJenis()));
        }
    }
}
