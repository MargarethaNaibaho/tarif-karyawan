package com.sistemkode;

import java.util.Scanner;

public class App
{
    public static void header(){
        System.out.println( "---------------------------------------------------------------------------------------------" );
        System.out.println("Selamat Datang di Program Penghitungan Gaji Karyawan");
        System.out.println( "---------------------------------------------------------------------------------------------" );
    }

    public static double getDoubleInput(Scanner scanner, String prompt){
        double input = 0;
        boolean valid = false;

        while(!valid){
            System.out.print(prompt);

            if(scanner.hasNextDouble()){
                input = scanner.nextDouble();
                valid = true;
            } else{
                System.out.println("Input tidak valid. Silahkan masukkan angka yang benar.");
                scanner.next();
            }
        }

        return input;
    }

    public static void mainProgram(){
        Scanner scanner = new Scanner(System.in);

        double totalJamKerja = getDoubleInput(scanner, "Masukkan jumlah jam kerja karyawan (dalam jam. Contoh: 5): ");
        double tarifPerJam = getDoubleInput(scanner, "Masukkan tarif per jam (dalam Rupiah. Contoh: 1000000): Rp ");
        System.out.println( "---------------------------------------------------------------------------------------------" );
        System.out.println("Hasil Perhitungan Gaji Karyawan: ");
        System.out.println("Jumlah jam kerja: " + totalJamKerja);
        System.out.println("Tarif per jam (bukan lembur): " + tarifPerJam);
        System.out.println("Tarif per jam (jika lembur. ini berlaku jika jumlah jam kerja melebihi 40 jam): " + (tarifPerJam * 1.5));
        System.out.println();

        double jamLembur = 0;
        double totalTarifLembur = 0;
        double totalTarifBiasa = 0;
        if(totalJamKerja > 40){
            totalTarifBiasa = 40 * tarifPerJam;
            jamLembur = totalJamKerja - 40;
            totalTarifLembur = jamLembur * (tarifPerJam * 1.5);
        } else{
            totalTarifBiasa = totalJamKerja * tarifPerJam;
        }

        System.out.println("Total tarif (bukan lembur): Rp " + totalTarifBiasa);
        System.out.println("Total tarif (lembur untuk " + jamLembur + " jam): Rp " + totalTarifLembur);

        System.out.println();

        System.out.println("Total keseluruhan: Rp " + (totalTarifBiasa + totalTarifLembur));
        System.out.println( "---------------------------------------------------------------------------------------------" );
    }

    public static void main( String[] args )
    {
        header();
        System.out.println();
        mainProgram();
    }
}
