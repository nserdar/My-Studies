package main.java.oop;

// Tüm sınıflar için temel sınıf
abstract class Hesap {
    //protected: Alt sınıfların (subclass) erişebileceği ama dışarıdan erişimin kısıtlandığı bir erişim
    protected String hesapSahibi;
    protected int hesapNumarasi;
    protected double bakiye;

    public Hesap(String hesapSahibi, int hesapNumarasi, double bakiye){
        this.hesapSahibi = hesapSahibi;
        this.hesapNumarasi = hesapNumarasi;
        this.bakiye = bakiye;
    }

    // Para yatırma
    public void paraYatir(double miktar){
        if (miktar > 0){
            bakiye += miktar;
            System.out.println(miktar + " TL yatırıldı. Güncel bakiye: " + bakiye);
        }
    }

    //Para çekme, bu metot alt sınıflar tarafından özelleştirilebilir
    public abstract void paraCek(double miktar);

    //Bakiye sorgulama
    public double bakiyeSorgula(){
        return bakiye;
    }

}













