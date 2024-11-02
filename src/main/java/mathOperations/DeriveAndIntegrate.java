package main.java.mathOperations;

public class DeriveAndIntegrate {

     // Polinomun türevi:
    public static double[] derive(double[] coefficients){
        if (coefficients.length <= 1){
            return new double[]{0};
        }

        double[] derivative = new double[coefficients.length-1];

        for (int i = 1; i < coefficients.length; i++){
            derivative[i-1] = coefficients[i] * i;
        }

        return derivative;
    }
    /*
    Polinom: 3x^2 + 2x + 1 için coefficients dizisi: {1, 2, 3} olur. Döngüdeki adımlar şöyle işler:

	1.	i = 1: derivative[0] = coefficients[1] * 1 = 2 * 1 = 2 ➔ Türevin ilk terimi 2x^0, yani 2 olur.
	2.	i = 2: derivative[1] = coefficients[2] * 2 = 3 * 2 = 6 ➔ Türevin ikinci terimi 6x^1, yani 6x olur.

Sonuç: Polinomun türevi 6x + 2 şeklindedir.
     */

    // integral alma:
    public static double[] integrate(double[] coefficients){
        double[] integral = new double[coefficients.length+1];

        for (int i = 0; i < coefficients.length; i++){
            integral[i+1] = coefficients[i] / (i+1);
        }

        float c = 0;
        integral[0] = c;
        return integral;
    }

    // yazdırma işlemi:
    public static String polinomToString(double[] coefficients) {
        StringBuilder sb = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {   //en yüksek dereceden en düşük dereceye

            //Bu koşul, katsayısı sıfır olan terimleri atlar. Böylece gereksiz terimler (örneğin, 0x^3) stringde yer almaz.
            if (coefficients[i] != 0) {

                // !sb.isEmpty() kontrolü, eklenen her terimden sonra “+” işaretini eklemek için kullanılır. Bu, polinomun
                // ilk teriminden sonra pozitif bir katsayı varsa " + " eklenmesini sağlar. Negatif katsayılar otomatik olarak eksi işareti alır.
                if (!sb.isEmpty() && coefficients[i] > 0) {
                    sb.append(" + ");
                }

                //Katsayı coefficients[i] olarak eklenir. Eğer katsayı x^0 (sabit terim) değilse, x^ ifadesiyle değişken ve derecesi eklenir.
                sb.append(coefficients[i]);
                if (i > 0) sb.append("x^").append(i);

            }
        }
        return sb.toString();
        /*
        Örneğin, coefficients = {1, 2, 3} (yani 3x^2 + 2x + 1) olduğunda:

	•	i = 2: sb → "3x^2"
	•	i = 1: sb → "3x^2 + 2x"
	•	i = 0: sb → "3x^2 + 2x + 1"

Sonuç olarak polinom stringi "3x^2 + 2x + 1" olur.
         */
    }

    public static void main(String[] args) {
        // Örnek polinom: 3x^2 + 2x + 1
        double[] coefficients = {1, 2, 3};

        System.out.println("Polinom: " + polinomToString(coefficients));

        // Türev hesaplama
        double[] derivative = derive(coefficients);
        System.out.println("Türev: " + polinomToString(derivative));

        // İntegral hesaplama
        double[] integral = integrate(coefficients);
        System.out.println("İntegral: " + polinomToString(integral) + " + C");
    }


}













