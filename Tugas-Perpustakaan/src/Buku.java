public class Buku {

    private int id;
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String isbn;

    public Buku(int id, String judul,
                String penulis,
                int tahunTerbit,
                String isbn) {

        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {

        return "ID            : " + id +
               "\nJudul        : " + judul +
               "\nPenulis      : " + penulis +
               "\nTahun Terbit : " + tahunTerbit +
               "\nISBN         : " + isbn;
    }
}