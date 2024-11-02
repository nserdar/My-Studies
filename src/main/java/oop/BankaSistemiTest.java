package main.java.oop;

public class BankaSistemiTest {
    public static void main(String[] args) {
        // Vadesiz Hesap oluşturma
        Hesap vadesizHesap = new VadesizHesap("Ali", 1001, 5000);
        vadesizHesap.paraYatir(1500);
        vadesizHesap.paraCek(2000);
        System.out.println("Vadesiz Hesap Bakiyesi: " + vadesizHesap.bakiyeSorgula());

        // Vadeli Hesap oluşturma
        VadeliHesap vadeliHesap = new VadeliHesap("Ayşe", 1002, 10000, 5);
        vadeliHesap.paraYatir(2000);
        vadeliHesap.faizHesapla();
        vadeliHesap.paraCek(3000);
        System.out.println("Vadeli Hesap Bakiyesi: " + vadeliHesap.bakiyeSorgula());

        // Polimorfizm kullanımı
        Hesap hesap1 = new VadesizHesap("Ali", 1001, 5000);
        Hesap hesap2 = new VadeliHesap("Ayşe", 1002, 10000, 5);

        hesap1.paraCek(1000); // Vadesiz hesapta para çekme
        hesap2.paraCek(2000); // Vadeli hesapta para çekme

        System.out.println("Hesap 1 Bakiyesi: " + hesap1.bakiyeSorgula());
        System.out.println("Hesap 2 Bakiyesi: " + hesap2.bakiyeSorgula());
    }
}
