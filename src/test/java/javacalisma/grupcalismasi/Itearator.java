package javacalisma.grupcalismasi;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Itearator {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");

        System.out.println(myList);
        String data = "ekleme";
        ListIterator<String> myIterator = myList.listIterator();
        while (myIterator.hasNext()) {
            myIterator.next();
//ikisini ayni anda calistiramiyoruz. Mantık hatasi var muhtemelen
//myIterator.add(data);
//myIterator.set("for dongusu");
        }
        myIterator.previous();
        while (myIterator.hasNext()) {
            myIterator.next();
            System.out.println(myList);
        }
/*
for (String string: myList) {
System.out.println(string);
}
*/
    }
}
