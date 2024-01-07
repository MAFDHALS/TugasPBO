import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Interface
interface Displayable {
    void tampilkanDetail();
}

// Superclass
class Tugas {
    protected String deskripsi;
    protected Date batasWaktu;

    public Tugas(String deskripsi, Date batasWaktu) {
        this.deskripsi = deskripsi;
        this.batasWaktu = batasWaktu;
    }

    public void tampilkanDetail() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Batas Waktu: " + dateFormat.format(batasWaktu));
    }
}

// Subclass
class Acara extends Tugas implements Displayable {
    private String lokasi;

    public Acara(String deskripsi, Date batasWaktu, String lokasi) {
        super(deskripsi, batasWaktu);
        this.lokasi = lokasi;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Lokasi: " + lokasi);
    }
}

public class PengelolaJadwalHarian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collection framework (List)
        List<Tugas> tugasList = new ArrayList<>();

        // Input tugas
        for (int i = 1; i <= 2; i++) {
            System.out.println("Tugas " + i + ":");
            System.out.print("Deskripsi: ");
            String deskripsi = scanner.nextLine();

            System.out.print("Batas Waktu (dd-MM-yyyy HH:mm:ss): ");
            String batasWaktuString = scanner.nextLine();

            System.out.println("Apakah ini sebuah acara? (ya/tidak): ");
            String isAcara = scanner.nextLine();

            Tugas tugas;
            if ("ya".equalsIgnoreCase(isAcara)) {
                System.out.print("Lokasi: ");
                String lokasi = scanner.nextLine();
                tugas = new Acara(deskripsi, parseTanggal(batasWaktuString), lokasi);
            } else {
                tugas = new Tugas(deskripsi, parseTanggal(batasWaktuString));
            }

            tugasList.add(tugas);
        }

        // Tampilkan jadwal
        System.out.println("\nJadwal Harian Anda:");
        for (Tugas tugas : tugasList) {
            tugas.tampilkanDetail();
            System.out.println();
        }
    }

    // Metode untuk parsing tanggal dari string
    private static Date parseTanggal(String tanggalString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            return dateFormat.parse(tanggalString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
