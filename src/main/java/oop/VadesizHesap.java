package main.java.oop;

public class VadesizHesap extends Hesap{

    public VadesizHesap(String hesapSahibi, int hesapNumarasi, double bakiye) {
        super(hesapSahibi, hesapNumarasi, bakiye);
    }

    @Override
    public void paraCek(double miktar) {
        if (miktar>0 && miktar<bakiye){
            bakiye -= miktar;
            System.out.println(miktar + " TL çekildi. Güncel bakiye: " + bakiye);
        }else {
            System.out.println("Yetersiz bakiye.");
        }
    }

}
