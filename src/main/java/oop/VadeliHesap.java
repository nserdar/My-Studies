package main.java.oop;

public class VadeliHesap extends Hesap{
    private double faizOrani;

    //bir sınıf başka bir sınıftan (superclass) türetilmişse, alt sınıfın (subclass) yapıcısında
    // (constructor) üst sınıfın yapıcısı çağrılmalıdır. Üst sınıfın yapıcı metodu, üst sınıfın
    // sahip olduğu özellikleri (değişkenleri) başlatmak için gereklidir. Alt sınıf, üst sınıfın
    // özelliklerini devraldığı için, bu özelliklerin uygun şekilde başlatılması önemlidir.
    // Kalıtım Hiyerarşisi: Alt sınıfın yapıcısı çağrıldığında, önce üst sınıfın yapıcısı çalıştırılır.
    // Bu, hiyerarşik yapıyı korur ve alt sınıf nesnesi oluşturulmadan önce üst sınıf nesnesinin
    // doğru bir şekilde oluşturulmasını sağlar.Alt sınıf yapıcısında super(...) ifadesi ile üst sınıfın yapıcısı çağrılır
    public VadeliHesap(String hesapSahibi, int hesapNumarasi, double bakiye, double faizOrani) {
        super(hesapSahibi, hesapNumarasi, bakiye);
        this.faizOrani = faizOrani;
    }

    @Override
    public void paraCek(double miktar) {
        if (miktar > 0 && miktar <= bakiye) {
            bakiye -= miktar;
            System.out.println(miktar + " TL çekildi. Güncel bakiye: " + bakiye);
        } else {
            System.out.println("Yetersiz bakiye.");
        }
    }

    // faiz hesaplama
    public void faizHesapla(){
        double faiz = bakiye * faizOrani / 100;
        bakiye += faiz;
        System.out.println("Yıllık faiz eklendi. Güncel bakiye: " + bakiye);
    }

}
