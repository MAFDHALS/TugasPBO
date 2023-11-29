import java.util.Scanner;

public class TugasExceptionHandling {
    public static void main(String[] args) {
        // Membuat objek scanner untuk input
        Scanner scanner = new Scanner(System.in);

        try {
            // Memasukkan data faktur
            System.out.print("Masukkan Nomor Faktur: ");
            int noFaktur = scanner.nextInt();
            scanner.nextLine();  // Membuang newline

            System.out.print("Masukkan Nama Pelanggan: ");
            String namaPelanggan = scanner.nextLine();

            System.out.print("Masukkan Nomor HP Pelanggan: ");
            String noHp = scanner.nextLine();

            // Memasukkan data barang
            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();

            // Memastikan jumlah beli positif
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0");
            }

            // Menghitung total bayar
            double totalBayar = hargaBarang * jumlahBeli;

            // Menampilkan faktur
            System.out.println("\n=== FAKTUR BELANJA ===");
            System.out.println("Nomor Faktur: " + noFaktur);
            System.out.println("Nama Pelanggan: " + namaPelanggan);
            System.out.println("Nomor HP: " + noHp);
            System.out.println("Nama Barang: " + namaBarang);
            System.out.println("Harga Barang: " + hargaBarang);
            System.out.println("Jumlah Beli: " + jumlahBeli);
            System.out.println("Total Bayar: " + totalBayar);

        } catch (Exception e) {
            // Menangani exception umum
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            // Menutup scanner
            scanner.close();
        }
    }
}
