package me.shouheng.guava;

import com.google.common.collect.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class CollectionExample {

    public static void main(String...args) {
        System.out.println("\n-----------------------------------");
        immutableSetExample();

        System.out.println("\n-----------------------------------");
        multisetExample();

        System.out.println("\n-----------------------------------");
        multiMapExample();

        System.out.println("\n-----------------------------------");
        biMapExample();

        System.out.println("\n-----------------------------------");
        tableExample();

        System.out.println("\n-----------------------------------");
        collections2Example();

        System.out.println("\n-----------------------------------");
        collectionExample();
    }

    private static void immutableSetExample() {
        ImmutableSet<String> immutableSet = ImmutableSet.of("A", "B", "C", "D", "E", "F");
        ImmutableSet<String> immutableSet2 = ImmutableSet.copyOf(immutableSet);
        ImmutableSet<String> immutableSet3 = ImmutableSet.<String>builder().add("A").add("B").addAll(Arrays.asList("C", "D", "E")).build();

        immutableSet.forEach(System.out::print);
        immutableSet2.forEach(System.out::print);
        immutableSet3.forEach(System.out::print);
    }

    private static void multisetExample() {
        Multiset<String> multiset = LinkedHashMultiset.create();
        multiset.add("A");
        multiset.add("B");
        multiset.add("A");
        multiset.add("C");

        System.out.println(multiset.count("A"));

        multiset.setCount("C", 3);
        System.out.println(multiset.count("C"));
    }

    private static void multiMapExample() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("A", "a1");
        multimap.put("A", "a2");
        multimap.put("A", "a3");
        multimap.put("B", "b1");
        System.out.println(multimap);
        System.out.println(multimap.get("A")); // this will return a set object
    }

    private static void biMapExample() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("sina", "www.sina.com");
        biMap.put("baidu", "www.baidu.com");
        biMap.put("weibo", "www.weibo.com");
        biMap.put("weibo", "www.weibo2.com");
        System.out.println(biMap.get("weibo"));
    }

    private static void tableExample() {
        Table<Integer, Integer, String> table = HashBasedTable.create();
        table.put(1, 1, "1.1");
        table.put(1, 2, "1.2");
        table.put(4, 5, "4.5");
        table.put(8, 1, "8.1");
        table.put(9, 0, "9.0");
        table.column(1).forEach((integer, s) -> System.out.print(integer + " " + s + "\n"));
        table.row(1).forEach((integer, s) -> System.out.print(integer + " " + s + "\n"));
    }

    private static void collections2Example() {
        List<Integer> list = Arrays.asList(1, 3, 1, 23, 13, 34, 4, 8);
        Collections2.filter(list, integer -> integer > 15).forEach(System.out::println);
        List<Date> dates = Arrays.asList(new Date(0), new Date());
        Collections2.transform(dates, date -> new SimpleDateFormat("yyyy-MM-dd").format(date)).forEach(System.out::println);
    }

    private static void collectionExample() {
        Set<Integer> set1= Sets.newHashSet(1, 2, 3, 4, 5);
        Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6);
        Sets.intersection(set1,set2).forEach(System.out::print); //
        System.out.println();
        Sets.difference(set1,set2).forEach(System.out::print); // 差集,在A中不在B中
        System.out.println();
        Sets.union(set1,set2).forEach(System.out::print); // 并集
    }
}
