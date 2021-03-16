package javacalisma.codingbat;

import java.util.Scanner;

public class ertyu {
    public static void main(String[] args) {
       /* “NestedIfStatements” class olusturun.

        Kullanicidan 2 kisi icin dogum gunu girmesini isteyin.

        Yılı, ayi ve günü tamsayı olarak alın e NestedIf kullanarak kimin yas olarak daha buyuk oldugunu ekrana yazdirin.
        Examples:
        int birthYearOfYusuf=2000, birthMonthOfYusuf=12, birthDayOfYusuf=12,
        int birthYearOfMehmet=2000,birthMonthOfMehmet=12, birthDayOfMehmet=21;
        Yusuf is Older */


        Scanner scan = new Scanner(System.in);
        System.out.println("Lutfen Ayse'nin dogum gununu gun ay yil olarak giriniz");
        int birthdayYearOfAyse = scan.nextInt();
        int birthMonthOfAyse = scan.nextInt();
        int birthDayOfAyse = scan.nextInt();

        System.out.println("Lutfen Ahmet'in dogum gununu gun ay yil olarak giriniz");
        int birthYearOfAhmet = scan.nextInt();
        int birthMonthOfAhmet = scan.nextInt();
        int birthDayOfAhmet = scan.nextInt();


        if (birthdayYearOfAyse == birthYearOfAhmet) {
            if (birthMonthOfAyse == birthMonthOfAhmet) {
                if (birthDayOfAyse < birthDayOfAhmet) {
                    System.out.println("Ayse Ahmet'ten gun olarak buyuk");
                } else if ((birthDayOfAyse > birthDayOfAhmet)) {
                    System.out.println("Ahmet Ayse'den gun olarak  buyuk");
                } else {
                    System.out.println("Ahmet ve Ayse ayni yasta");
                }
            } else if (birthMonthOfAyse < birthMonthOfAhmet) {
                System.out.println("Ayse Ahmet'ten ay olarak buyuk");
            } else {
                System.out.println("Ahmet Ayse'den ay olarak buyuk");
            }

        } else if (birthdayYearOfAyse < birthYearOfAhmet) {
            System.out.println("ayse yil olarak buyuk");
        } else {
            System.out.println("Ahmet yil olarak buyuk");
        }
    }
}