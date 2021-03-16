package javacalisma.codingbat;

import java.util.Scanner;

public class java_sorulari {
    //--JAVA ORNEK
    //1-Kullanıcıdan bir tam sayı alıniz
    //Bu sayıdan küçük kaç tane tam kare sayı olduğu bulunuz ve adet bilgisi konsol ekrana çıktı olarak yazdırıniz
    //2-kullanicindan 2 sayi aliniz buyuk sayi ve kucuk sayi olarak ekrana yazdiriniz


     public static void main(String[] args) {

         Scanner scan=new Scanner(System.in);
         System.out.println("lutfen bir tam sayi giriniz");
         int num=scan.nextInt();

         int elimizdekisayi=0;
         for(int i=1; Math.pow(i,2)<=num; i++){
             System.out.println(i);
             elimizdekisayi++;
         }
         System.out.println(num + "' a kadar " + elimizdekisayi + " tane karesi olan sayi var");

/////////////////*********************
//         Scanner sc = new Scanner (System.in);
//         System.out.println("lutfen uc sayi giriniz");
//         int sayi1 = scan.nextInt();
//         int sayi2 = scan.nextInt();
//         int sayi3=scan.nextInt();
//		if (sayi1 > sayi2 ) {
//			System.out.println("buyuk sayi= " + sayi1 + "kucuk sayi= " + sayi2);
//		} else if (sayi2 > sayi1) {
//			System.out.println("buyuk sayi= " + sayi2 + "kucuk sayi= " + sayi1);
//		}else {
//			System.out.println("sayilar esit");
//		}
//
//		String result=sayi1>=sayi2? "buyuk sayi= " + sayi1 + "kucuk sayi= " + sayi2: "buyuk sayi= " + sayi2 + "kucuk sayi= " + sayi1;
//		System.out.println(result);
//
//         ///uc sayiyi kiyaslama
//         int max=0;
//         if (sayi1>sayi2) {
//             max=sayi1;
//         }else if (sayi2>sayi1){
//             max=sayi2;
//         }else if(sayi3>max) {
//             max=sayi3;
//         }
//         System.out.println("buyuk sayi=" + max);
//
//		/*ternary ile uc sayiyi kiayslama
//		 Kullanicidan 3 Numara isteyiniz ve bu numaralarin en buyuk ve
//		    en kucuk olanlarini konsola yazdiriniz
//		    int num1
//		    int num2
//		    int num3
//		*/
//
//         Scanner scan1 = new Scanner (System.in);
//         System.out.println("Lutfen 3 sayi giriniz!");
//         int num1 = scan1.nextInt();
//         int num2 = scan1.nextInt();
//         int num3 = scan1.nextInt();
//
//         if(num1 >= num2  && num1 >= num3) {
//             System.out.println(num1+" en buyuk sayidir");
//
//             if(num2 >= num3) {
//                 System.out.println(num3+" en kucuk sayidir");
//             }else {
//                 System.out.println(num2+" en kucuk sayidir");
//             }
//         }else if(num2 >= num1 && num2 >= num3) {
//
//             System.out.println(num2 +" en buyuk sayidir");
//
//             if(num1 >= num3) {
//                 System.out.println(num3+" en kucuk sayidir");
//             }else {
//                 System.out.println(num1 +" en kucuk sayidir");
//             }
//
//         }
//
     }




}
