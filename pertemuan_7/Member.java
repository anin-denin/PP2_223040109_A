package pertemuan_7;

public class Member {
    private String id;
    private String jenisMemberId;
    private String nama;

    public Member(String id, String jenisMemberId, String nama) {
        this.id = id;
        this.jenisMemberId = jenisMemberId;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenisMemberId() {
        return jenisMemberId;
    }

    public void setJenisMemberId(String jenisMemberId) {
        this.jenisMemberId = jenisMemberId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}


