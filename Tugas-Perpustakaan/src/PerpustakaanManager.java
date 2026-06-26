import java.util.ArrayList;
import java.io.*;

public class PerpustakaanManager {

    private ArrayList<Buku> daftarBuku;
    private int nextId = 1;

    public PerpustakaanManager() {
        daftarBuku = new ArrayList<>();
        bacaFile();
    }

    public boolean isbnSudahAda(String isbn) {

        for (Buku b : daftarBuku) {
            if (b.getIsbn().equals(isbn)) {
                return true;
            }
        }

        return false;
    }

    public void tambahBuku(String judul,
                           String penulis,
                           int tahun,
                           String isbn) {

        if (isbnSudahAda(isbn)) {
            System.out.println("ISBN sudah digunakan.");
            return;
        }

        Buku buku = new Buku(
                nextId++,
                judul,
                penulis,
                tahun,
                isbn);

        daftarBuku.add(buku);

        simpanFile();

        System.out.println("Buku berhasil ditambahkan.");
    }

    public void tampilSemua() {

        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }

        for (Buku b : daftarBuku) {
            System.out.println("------------------------");
            System.out.println(b);
        }
    }

    public Buku cariId(int id) {

        for (Buku b : daftarBuku) {
            if (b.getId() == id) {
                return b;
            }
        }

        return null;
    }

    public Buku cariIsbn(String isbn) {

        for (Buku b : daftarBuku) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }

        return null;
    }

    public boolean updateId(int id,
                            String judul,
                            String penulis,
                            int tahun) {

        Buku b = cariId(id);

        if (b != null) {

            b.setJudul(judul);
            b.setPenulis(penulis);
            b.setTahunTerbit(tahun);

            simpanFile();

            return true;
        }

        return false;
    }

    public boolean updateIsbn(String isbn,
                              String judul,
                              String penulis,
                              int tahun) {

        Buku b = cariIsbn(isbn);

        if (b != null) {

            b.setJudul(judul);
            b.setPenulis(penulis);
            b.setTahunTerbit(tahun);

            simpanFile();

            return true;
        }

        return false;
    }

    public boolean hapusId(int id) {

        Buku b = cariId(id);

        if (b != null) {

            daftarBuku.remove(b);

            simpanFile();

            return true;
        }

        return false;
    }

    public boolean hapusIsbn(String isbn) {

        Buku b = cariIsbn(isbn);

        if (b != null) {

            daftarBuku.remove(b);

            simpanFile();

            return true;
        }

        return false;
    }

    public void simpanFile() {

        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter("buku.txt"));

            for (Buku b : daftarBuku) {

                writer.println(
                        b.getId() + ";" +
                        b.getJudul() + ";" +
                        b.getPenulis() + ";" +
                        b.getTahunTerbit() + ";" +
                        b.getIsbn());
            }

            writer.close();

        } catch (Exception e) {

            System.out.println(
                    "Gagal menyimpan data.");
        }
    }

    public void bacaFile() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("buku.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(";");

                Buku buku = new Buku(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4]);

                daftarBuku.add(buku);

                if (buku.getId() >= nextId) {
                    nextId = buku.getId() + 1;
                }
            }

            br.close();

        } catch (Exception e) {
        }
    }
}