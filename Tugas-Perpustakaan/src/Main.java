import java.util.Scanner;

public class Main {

    public static int inputAngka(Scanner input) {

        while (true) {

            try {
                return Integer.parseInt(input.nextLine());
            }

            catch (Exception e) {
                System.out.print("Input harus berupa angka: ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        PerpustakaanManager manager =
                new PerpustakaanManager();

        int pilihan;

        do {

            System.out.println("\n===== SISTEM PERPUSTAKAAN =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Update Buku");
            System.out.println("5. Hapus Buku");
            System.out.println("6. Keluar");

            System.out.print("Pilih menu: ");

            pilihan = inputAngka(input);

            switch (pilihan) {

                case 1:

                    System.out.print("Judul: ");
                    String judul =
                            input.nextLine();

                    System.out.print("Penulis: ");
                    String penulis =
                            input.nextLine();

                    int tahun;

                    while (true) {

                        System.out.print(
                                "Tahun Terbit: ");

                        tahun =
                                inputAngka(input);

                        if (tahun >= 1000 &&
                                tahun <= 9999)
                            break;

                        System.out.println(
                                "Tahun harus 4 digit.");
                    }

                    System.out.print("ISBN: ");
                    String isbn =
                            input.nextLine();

                    manager.tambahBuku(
                            judul,
                            penulis,
                            tahun,
                            isbn);

                    break;

                case 2:

                    manager.tampilSemua();

                    break;

                case 3:

                    System.out.println(
                            "1. Cari ID");
                    System.out.println(
                            "2. Cari ISBN");

                    int cari =
                            inputAngka(input);

                    if (cari == 1) {

                        System.out.print(
                                "ID: ");

                        int id =
                                inputAngka(input);

                        Buku buku =
                                manager.cariId(id);

                        if (buku != null)
                            System.out.println(
                                    "\n" + buku);
                        else
                            System.out.println(
                                    "Data tidak ditemukan.");
                    }

                    else if (cari == 2) {

                        System.out.print(
                                "ISBN: ");

                        String isbnCari =
                                input.nextLine();

                        Buku buku =
                                manager.cariIsbn(
                                        isbnCari);

                        if (buku != null)
                            System.out.println(
                                    "\n" + buku);
                        else
                            System.out.println(
                                    "Data tidak ditemukan.");
                    }

                    else {

                        System.out.println(
                                "Pilihan tidak valid.");
                    }

                    break;

                case 4:

                    System.out.println(
                            "1. Update ID");
                    System.out.println(
                            "2. Update ISBN");

                    int up =
                            inputAngka(input);

                    boolean hasil = false;

                    if (up == 1) {

                        System.out.print(
                                "ID: ");

                        int id =
                                inputAngka(input);

                        Buku buku =
                                manager.cariId(id);

                        if (buku != null) {

                            System.out.println(
                                    buku);

                            System.out.print(
                                    "Judul baru: ");
                            String j =
                                    input.nextLine();

                            System.out.print(
                                    "Penulis baru: ");
                            String p =
                                    input.nextLine();

                            System.out.print(
                                    "Tahun baru: ");

                            int t =
                                    inputAngka(input);

                            hasil =
                                    manager.updateId(
                                            id,
                                            j,
                                            p,
                                            t);
                        }
                    }

                    else if (up == 2) {

                        System.out.print(
                                "ISBN: ");

                        String isbnUpdate =
                                input.nextLine();

                        Buku buku =
                                manager.cariIsbn(
                                        isbnUpdate);

                        if (buku != null) {

                            System.out.println(
                                    buku);

                            System.out.print(
                                    "Judul baru: ");
                            String j =
                                    input.nextLine();

                            System.out.print(
                                    "Penulis baru: ");
                            String p =
                                    input.nextLine();

                            System.out.print(
                                    "Tahun baru: ");

                            int t =
                                    inputAngka(input);

                            hasil =
                                    manager.updateIsbn(
                                            isbnUpdate,
                                            j,
                                            p,
                                            t);
                        }
                    }

                    if (hasil)
                        System.out.println(
                                "Data berhasil diupdate.");
                    else
                        System.out.println(
                                "Data tidak ditemukan.");

                    break;

                case 5:

                    System.out.println(
                            "1. Hapus ID");
                    System.out.println(
                            "2. Hapus ISBN");

                    int h =
                            inputAngka(input);

                    boolean ditemukan =
                            false;

                    if (h == 1) {

                        System.out.print(
                                "ID: ");

                        int id =
                                inputAngka(input);

                        Buku buku =
                                manager.cariId(id);

                        if (buku != null) {

                            ditemukan = true;

                            System.out.println(
                                    "\n" + buku);

                            System.out.print(
                                    "Yakin ingin menghapus? (Y/N): ");

                            String konfirmasi =
                                    input.nextLine();

                            if (konfirmasi.equalsIgnoreCase("Y")) {

                                manager.hapusId(id);

                                System.out.println(
                                        "Data berhasil dihapus.");
                            }

                            else {

                                System.out.println(
                                        "Penghapusan dibatalkan.");
                            }
                        }
                    }

                    else if (h == 2) {

                        System.out.print(
                                "ISBN: ");

                        String isbnHapus =
                                input.nextLine();

                        Buku buku =
                                manager.cariIsbn(
                                        isbnHapus);

                        if (buku != null) {

                            ditemukan = true;

                            System.out.println(
                                    "\n" + buku);

                            System.out.print(
                                    "Yakin ingin menghapus? (Y/N): ");

                            String konfirmasi =
                                    input.nextLine();

                            if (konfirmasi.equalsIgnoreCase("Y")) {

                                manager.hapusIsbn(
                                        isbnHapus);

                                System.out.println(
                                        "Data berhasil dihapus.");
                            }

                            else {

                                System.out.println(
                                        "Penghapusan dibatalkan.");
                            }
                        }
                    }

                    else {

                        System.out.println(
                                "Pilihan tidak valid.");
                    }

                    if (!ditemukan &&
                            (h == 1 || h == 2)) {

                        System.out.println(
                                "Data tidak ditemukan.");
                    }

                    break;

                case 6:

                    System.out.println(
                            "Terima kasih.");

                    break;

                default:

                    System.out.println(
                            "Menu tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }
}