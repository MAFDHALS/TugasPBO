import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TugasStringDate {
    public static void main(String[] args) {
        // Kode utama program
        Scanner scanner = new Scanner(System.in);

        try {
            // Menampilkan header BERKAH MART
            System.out.println("BERKAH MART");

            // Menampilkan tanggal dan waktu
            String formattedDate = getFormattedDate();
            String formattedTime = getFormattedTime();
            System.out.println("Tanggal : " + formattedDate);
            System.out.println("Waktu   : " + formattedTime);

            // Menampilkan garis pemisah
            System.out.println("========================");

            // Menampilkan data pelanggan
            System.out.println("DATA PELANGGAN");
            System.out.println("---------------------");
            System.out.print("Nama Pelanggan : ");
            String namaPelanggan = scanner.nextLine();
            System.out.print("No. HP                 : ");
            String noHp = scanner.nextLine();
            System.out.print("Alamat                 : ");
            String alamat = scanner.nextLine();
            System.out.println("++++++++++++++++++++++++");

            // Menampilkan data pembelian barang
            System.out.println("DATA PEMBELIAN BARANG");
            System.out.println("------------------------------");
            System.out.print("Kode Barang       : ");
            String kodeBarang = scanner.nextLine();
            System.out.print("Nama Barang     : ");
            String namaBarang = scanner.nextLine();
            System.out.print("Harga Barang     : ");
            double hargaBarang = scanner.nextDouble();
            System.out.print("Jumlah Beli         : ");
            int jumlahBeli = scanner.nextInt();

            // Memastikan jumlah beli positif
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0");
            }

            // Menghitung total bayar
            double totalBayar = hargaBarang * jumlahBeli;

            // Menampilkan total bayar dan garis pemisah
            System.out.println("TOTAL BAYAR      : " + totalBayar);
            System.out.println("++++++++++++++++++++++++");

            // Menampilkan informasi kasir
            System.out.print("Kasir    : " + getKasirInfo());

        } catch (Exception e) {
            // Menangani exception umum
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            // Menutup scanner
            scanner.close();
        }
    }

    // Metode getFormattedDate(), getFormattedTime(), dan getKasirInfo() tetap sama
    private static String getFormattedDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
        return dateFormat.format(currentDate);
    }

    private static String getFormattedTime() {
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss z");
        return timeFormat.format(currentDate);
    }

    private static String getKasirInfo() {
        return "Nama Kasir";
    }
}
