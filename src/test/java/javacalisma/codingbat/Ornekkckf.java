package javacalisma.codingbat;

import java.util.Scanner;

public class Ornekkckf {
    public static void main(String[] args)throws Exception {
       int x = 3+'d';
      //  System.out.println((char) x);//g

     //   System.out.println(((char) 'd') +3);

        double kare=Math.pow(3.9,2);
      //  System.out.println(kare<50);

       // Tam adınızı girdi olarak alan ve görüntülenen soyadı hariç ilk ve ikinci adların kısaltmalarını
        // görüntüleyen bir program yazın. Örneğin, adınız Robert Brett Roser ise, çıktı RBRoser olmalıdır.
        Scanner scan=new Scanner(System.in);
        String cumle=scan.nextLine();
//        String [] kelime=null;
//       kelime=cumle.split(" ");
//        System.out.println(kelime);


        //String[] kelime1 = cumle.split("");
        System.out.println(cumle);
        for(int i=0; i< cumle.length(); i++) {
            System.out.print( i +" . kelime" + cumle.substring(0,1));
        }
    }
}
