package responuas;
import java.util.*;
import java.text.*;

public class ResponUAS {
    protected static Scanner inputan = new Scanner(System.in);
    protected static int err = 1;
    protected static ArrayList<String> kodeBarang = new ArrayList();
    protected static ArrayList<Double> hargaBarang = new ArrayList();
    protected static ArrayList<Double> qtyBarang = new ArrayList();
    protected static ArrayList<String> namaBarang = new ArrayList();
    static boolean appRun = true; 
    
    public static void main(String[] args) {
        System.out.println("=== POINT OF SALES ===");
        do {
            menuUtama();
        } while (appRun);
    }
    
    private static void menuUtama(){
        System.out.println("#----------------#");
        System.out.println("#   MENU UTAMA   #");
        System.out.println("#----------------#");
        System.out.println("[1] Lihat Data");
        System.out.println("[2] Tambah Data");
        System.out.println("[3] Koreksi");
        System.out.println("[4] Hapus");
        System.out.println("[5] Selesai");
        err = 1;
        while(err == 1){
            System.out.println("");
            System.out.print("Pilihan anda [1 ~ 5]: ");
            int pilihanMenu = inputan.nextInt();
            err = 0;
            if (pilihanMenu < 1 || pilihanMenu > 5){
                err = 1;
            }
            switch (pilihanMenu){
                case 1: lihat(); break;
                case 2: tambah(); break;
                case 3: koreksi(); break;
                case 4: hapus(); break;
                case 5: appRun = false;
                default: System.out.println("Pilihan salah! Ulangi!");
            }
        }
    }
    
    private static void lihat(){
        //Membuat format Rp.
        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kurs.setDecimalFormatSymbols(formatRp);

        if(namaBarang.isEmpty()){
            System.out.println("Belum ada data. Tambahkan terlebih dahulu beberapa alat!");
        }else{
            System.out.println("+----------------------------------------------------------------------------------------------+");
            System.out.println("| NO | Kode Barang |       Nama Barang       |         HARGA         | QTY |    TOTAL HARGA    |");
            System.out.println("|----|-------------|-------------------------|-----------------------|-----|-------------------|");
            for(int i = 0; i < qtyBarang.size(); i++){
                double totalHarga = hargaBarang.get(i) * qtyBarang.get(i);
                System.out.printf("|%-4s|%-13s|%-25s| Rp. %18s |%-5s| Rp.%13s |%n",i+1,kodeBarang.get(i),namaBarang.get(i),kurs.format(hargaBarang.get(i)),qtyBarang.get(i),kurs.format(totalHarga));
            }
            System.out.println("|----------------------------------------------------------------------------------------------|");
        }
    }
    
    private static void tambah(){
        System.out.print("Kode Barang   : ");
        String inputKodeBarang = inputan.next();
        System.out.print("Nama Barang   : ");
        String inputNamaBarang = inputan.next();
        System.out.print("Harga         : ");
        double inputHargaBarang = inputan.nextDouble();
        System.out.print("Qty           : ");
        double inputQtyBarang = inputan.nextDouble();
        kodeBarang.add(inputKodeBarang);
        namaBarang.add(inputNamaBarang);
        hargaBarang.add(inputHargaBarang);
        qtyBarang.add(inputQtyBarang);
    }
    
    private static void koreksi(){
        lihat();
        System.out.print("Pilih nomor barang yang akan diubah : ");
        int index = inputan.nextInt();
        System.out.print("Kode Barang   : ");
        String inputKodeBarang = inputan.next();
        System.out.print("Nama Barang   : ");
        String inputNamaBarang = inputan.next();
        System.out.print("Harga         : ");
        double inputHargaBarang = inputan.nextDouble();
        System.out.print("Qty           : ");
        double inputQtyBarang = inputan.nextDouble();
        kodeBarang.set(index-1,inputKodeBarang);
        namaBarang.set(index-1,inputNamaBarang);
        hargaBarang.set(index-1,inputHargaBarang);
        qtyBarang.set(index-1,inputQtyBarang);
    }
    
    private static void hapus(){
        lihat();
        System.out.print("Pilih nomor barang yang akan dihapus : ");
        int index = inputan.nextInt();
        kodeBarang.remove(index-1);
        namaBarang.remove(index-1);
        hargaBarang.remove(index-1);
        qtyBarang.remove(index-1);
    }
}
