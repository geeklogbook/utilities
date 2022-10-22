package datastructures.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Java2DArrayList {

    public static void main(String[] args) {
        List<List<String>> arrayList2d = new ArrayList<List<String>>();

        List<String> list1 = new ArrayList<String>();
        list1.add("List1_Str1");
        list1.add("List1_Str2");
        list1.add("List1_Str3");

        List<String> list2 = new ArrayList<String>();
        list2.add("List2_Str1");
        list2.add("List2_Str2");
        list2.add("List2_Str3");

        List<String> list3 = new ArrayList<String>();
        list3.add("List3_Str1");
        list3.add("List3_Str2");
        list3.add("List3_Str3");
        list3.add("List3_Str4");

        arrayList2d.add(list1);
        arrayList2d.add(list2);
        arrayList2d.add(list3);

        System.out.println("2nd element in list3 : " + arrayList2d.get(2).get(1));
        System.out.println("3nd element in list1 : " + arrayList2d.get(0).get(2));
        System.out.println("1nd element in list2 : " + arrayList2d.get(1).get(0));
    }

}
