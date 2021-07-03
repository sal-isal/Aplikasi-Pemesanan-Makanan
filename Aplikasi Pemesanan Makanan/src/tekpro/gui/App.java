package tekpro.gui;

/*
    Tugas Tekpro Teori (GUI)
    Nama    : Faizal Abdul HAkim
    NIM     : 201524043
    Dibuat di IntelliJ IDEA Community Edition 2020.3.2
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.JavaBean;

public class App extends JFrame{
    private JPanel mainPanel;
    private JTextField txtNama;
    private JTextField txtAlamat;
    private JTextField txtNoTelp;
    private JCheckBox steakCheckBox;
    private JCheckBox spaghettiCheckBox;
    private JCheckBox pizzaCheckBox;
    private JTextField txtTotal;
    private JButton TAMBAHButton;
    private JTextArea textAreaPenjualan;
    private JLabel labeltittle;
    private String hasilPenjulan = "";
    private int totalBayar = 0;
    private int noPelanggan = 1;

    public App(String tittle){
        super(tittle);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(450,80,426,600);


        // Ketika button diclick
        TAMBAHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Jika ada pesanan
                if (steakCheckBox.isSelected() || spaghettiCheckBox.isSelected() || pizzaCheckBox.isSelected()) {
                    hasilPenjulan += "\nNama  : " + txtNama.getText() + "\n";
                    hasilPenjulan += "Alamat: " + txtAlamat.getText() + "\n";
                    hasilPenjulan += "Telp  : " + txtNoTelp.getText() + "\n";
                    hasilPenjulan += "pelanggan ke  : " + noPelanggan + "\n";

                    hasilPenjulan += "----------------------\n";

                    hasilPenjulan += "PESANAN : \n";

                    if (steakCheckBox.isSelected()) {
                        hasilPenjulan += "  -Steak (100000)\n";
                    }
                    if (spaghettiCheckBox.isSelected()) {
                        hasilPenjulan += "  -Spaghetti (200000)\n";
                    }
                    if (pizzaCheckBox.isSelected()) {
                        hasilPenjulan += "  -Pizza (300000)\n";
                    }

                    hasilPenjulan += "----------------------\n";
                    hasilPenjulan += "Total Bayar : ";
                    hasilPenjulan += txtTotal.getText() + "\n";
                }
                // Jika tidak ada pesanan
                else {
                    hasilPenjulan += "Tidak ada Pesanan\n";
                }
                noPelanggan++;

                // Tampilkan Data pesanan ke textArea
                textAreaPenjualan.setText(hasilPenjulan);
            }
        });

        // Ketika checkbox steak ditekan
        steakCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (steakCheckBox.isSelected())
                    totalBayar += 100000;
                else
                    totalBayar -= 100000;

                txtTotal.setText(String.valueOf(totalBayar));
            }
        });

        // Ketika checkbox spaghetti ditekan
        spaghettiCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (spaghettiCheckBox.isSelected())
                    totalBayar += 200000;
                else
                    totalBayar -= 200000;

                txtTotal.setText(String.valueOf(totalBayar));
            }
        });

        // Ketika pizza steak ditekan
        pizzaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pizzaCheckBox.isSelected())
                    totalBayar += 300000;
                else
                    totalBayar -= 300000;

                txtTotal.setText(String.valueOf(totalBayar));
            }
        });
    }

    public static void main(String[] args) {
        App frame = new App("Aplikasi Pemesanan Makanan");
        frame.setVisible(true);

    }

}
