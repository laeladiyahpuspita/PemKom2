/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class DataKomputer implements AppInterface{
    private final Komputer[] komputer;    
    
    public DataKomputer(){
        komputer = new Komputer[1000];
    }
    
    @Override
    public int pilihanMenu() {
        String p = JOptionPane.showInputDialog(null, ""
                + "<html"
                + "=====Pilihan====================<br>"
                + "1 &rarr; Tambah Data Komputer<br>"
                + "2 &rarr; Cari berdasarkan Brand Komputer<br>"
                + "3 &rarr; Cari berdasarkan Model Komputer<br>"
                + "4 &rarr; Keluar Aplikasi<br>"
                + "===============================<br>"
                + "<b>Ketik Pilihan Anda:</b>"
                + "</html>",
            "Menu Pilihan",
        JOptionPane.QUESTION_MESSAGE);
        int pilihan = Integer.parseInt(p);//casting
        return pilihan;
    }

    @Override
    public void add() {
        Komputer kom = new Komputer();
        String brand = JOptionPane.showInputDialog(null, "Ketik Brand:", ""
                + "Brand", JOptionPane.QUESTION_MESSAGE);
        kom.setBrand(brand);
        String model = JOptionPane.showInputDialog(null, "Ketik Model:", ""
                + "Model", JOptionPane.QUESTION_MESSAGE);
        kom.setModel(model);
        String disk = JOptionPane.showInputDialog(null, "Tipe Disk (SSD/Harddisk):", ""
                + "Tipe Disk", JOptionPane.QUESTION_MESSAGE);
        kom.setDisk(disk);
        String size = JOptionPane.showInputDialog(null, "Kapasitas Disk (Angka):", ""
                + "Kapasitas Disk (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int diskSize = Integer.parseInt(size);//casting
        kom.setDiskSize(diskSize);
        String ram = JOptionPane.showInputDialog(null, "Kapasitas RAM (Angka):", ""
                + "Ukuran RAM (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int ramSize = Integer.parseInt(ram);//casting
        kom.setRam(ramSize);
        
        for (int i = 0; i < komputer.length; i++){
            if(komputer[i] == null){
                komputer[i] = kom;
                break;
            }
        }
        
        viewData(kom);
       }

    @Override
    public String keyword(String type) {
        String key = JOptionPane.showInputDialog(null,
                "Ketik "+type+" komputer",
           type,JOptionPane.QUESTION_MESSAGE);
        return key;
    }
    
    @Override
    public Komputer searchByBrand(String brand) {
        Komputer komp = null;
        for (Komputer k : komputer){
            if(k != null && brand.equalsIgnoreCase(k.getBrand())){
                komp = k;
                break;
            }
        }
        return komp;
    }
        
    @Override
    public Komputer searchByModel(String model) {
       Komputer komp =  null;
        for (Komputer k : komputer){
            if(k != null && model.equalsIgnoreCase(k.getModel())){
                komp = k;
                break;
            }
        }
        return komp;
    } 
    
    public Komputer selectFromResults(List<Komputer> results) {
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak ada hasil yang ditemukan.");
            return null;
        } else if (results.size() == 1) {
            return results.get(0);
        } else {
            String[] options = new String[results.size()];
            for (int i = 0; i < results.size(); i++) {
                options[i] = "Komputer " + (i + 1);
            }
            int choice = JOptionPane.showOptionDialog(null, "Pilih komputer:", "Hasil Pencarian", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            return results.get(choice);
        }
    }
    
    @Override
    public void viewData(Komputer k) {
        if(k == null){
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
        }else {
            JOptionPane.showMessageDialog(null, 
                    "Brand\t\t: "+k.getBrand() +
                    "\nModel\t\t: "+k.getModel() +
                    "\nDisk Type\t: "+k.getDisk() +
                    "\nDisk Size\t: "+k.getDiskSize() +
                    "\nRAM Size\t: "+k.getRam(),
                    "Data Komputer",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}