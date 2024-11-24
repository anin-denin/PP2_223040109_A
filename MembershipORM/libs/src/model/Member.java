package MembershipORM.libs.src.model;


public class Member {
    private int id;
    private String nama;
    private int jenisMemberId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJenisMemberId() {
        return jenisMemberId;
    }

    public void setJenisMemberId(int jenisMemberId) {
        this.jenisMemberId = jenisMemberId;
    }
}
