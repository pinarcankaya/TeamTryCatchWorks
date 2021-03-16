package javacalisma.codingbat;
import java.util.*;
public class Queue {


     public static void main(String args[]) {
         //Hash her zaman kafasına göre siralama yaptigi icin en hizlisidir.
//Linked sizin girdiginiz siraya gore siralayacaktır.
//Tree.ler ise natural order yapar.

         List<String>myList = new ArrayList<>(Arrays.asList("ali","ahmet","ali","yusuf","derya"));
//list natural order siralama
         Collections.sort(myList);
         String[]myArray = {"ali","ahmet","ali","yusuf","derya"};
//array natural order siralama
         Arrays.sort(myArray);
         System.out.println("my array"+Arrays.toString(myArray));
         System.out.println(myList);
//set.e cevirerek natural order siralama+ayni varsa tek dondurur
         Set<String>mySet = new TreeSet<>(myList);

         PriorityQueue<String>myPriorityQueue = new PriorityQueue<>();
         myPriorityQueue.add("ali");
         myPriorityQueue.add("ahmet");
         myPriorityQueue.add("ali");
         myPriorityQueue.add("yusuf");
         myPriorityQueue.add("derya");
         System.out.println("myTreeSet" + mySet);
         System.out.println("myPriorityQueue" + myPriorityQueue);

//map.i treemap olarak olusturursan key.ler natural order.a gore dizilecektir.
         Map<Integer,String> myMap = new TreeMap<>();
         int keys = 1;
         for(String w : myList) {
             myMap.put(keys, w);
             keys++;
         }
         System.out.println(myMap);
         myMap.put(3, "zehra");
//sen yeni eklersen treemap ozelliginden uygun yere koyar kalanlar bir sira kayar.
         System.out.println(myMap);
     }
}

