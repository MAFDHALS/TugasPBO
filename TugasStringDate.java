import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TugasStringDate {
    public static void main(String[] args) {
        // Metode main dihapus dari sini
    }

    public void runProgram() {
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

            // Menyimpan data ke database menggunakan JDBC
            saveToDatabase(namaPelanggan, noHp, alamat, kodeBarang, namaBarang, hargaBarang, jumlahBeli, totalBayar);

        } catch (Exception e) {
            // Menangani exception umum
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            // Menutup scanner
            scanner.close();
        }
    }

    private String getFormattedDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
        return dateFormat.format(currentDate);
    }

    private String getFormattedTime() {
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss z");
        return timeFormat.format(currentDate);
    }

    private String getKasirInfo() {
        return "Nama Kasir";
    }

    private void saveToDatabase(String namaPelanggan, String noHp, String alamat,
                                String kodeBarang, String namaBarang, double hargaBarang,
                                int jumlahBeli, double totalBayar) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/kasirjava";
        String username = "admin";
        String password = ""; 

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String insertQuery = "INSERT INTO pembelian (nama_pelanggan, no_hp, alamat, kode_barang, nama_barang, harga_barang, jumlah_beli, total_bayar) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, namaPelanggan);
                preparedStatement.setString(2, noHp);
                preparedStatement.setString(3, alamat);
                preparedStatement.setString(4, kodeBarang);
                preparedStatement.setString(5, namaBarang);
                preparedStatement.setDouble(6, hargaBarang);
                preparedStatement.setInt(7, jumlahBeli);
                preparedStatement.setDouble(8, totalBayar);

                // Eksekusi pernyataan SQL
                preparedStatement.executeUpdate();

                System.out.println("Data berhasil disimpan ke database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan SQL: " + e.getMessage());
        }
    }
}
