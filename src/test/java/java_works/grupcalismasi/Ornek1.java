package java_works.grupcalismasi;

import java.util.Scanner;

public class Ornek1 {

    //1- Kullanicidan iki basamakli uc adet sayi aliniz. Alinan sayilardan en az ikisinin birler basamagi ayni ise
    // ekrana true yoksa false yazdiriniz. (Orn 52,72,93 => true 36,57,78 => false)
    public static void main(String[] args) {




        Scanner scan=new Scanner(System.in);
        System.out.println("iki basamakli 3 sayi giriniz");
        int num1=scan.nextInt();
        int num2=scan.nextInt();
        int num3=scan.nextInt();

        boolean sayi1=num1%10==1;
        boolean sayi2=num2%10==1;
        boolean sayi3=num3%10==1;

        if(sayi1==sayi2 || sayi2==sayi3) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }



}
