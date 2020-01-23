package ru.gb.jtwo.lthree.online;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("January", 10);
        System.out.println(map);
        System.out.println(map.get("May"));

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

    }

    private static void treeSetExample() {
        Box b1 = new Box(1,1);
        Box b2 = new Box(2,2);
        Box b3 = new Box(3,3);
        TreeSet<Box> set = new TreeSet<>();
        set.add(b2);
        set.add(b1);
        set.add(b3);
        System.out.println(set);
    }

    private static void boxSetExample() {
        Box b6 = new Box(1, 1);
        HashSet<Box> set = new HashSet<>();
        set.add(new Box(1, 1));
        set.add(new Box(2, 2));
        set.add(new Box(3, 3));
        set.add(new Box(1, 3));
        set.add(new Box(6, 1));
        //set.add(b6);
        System.out.println(set);
    }

    private static void arrListExample(Box b1, Box b2, Box b3, Box b4) {
        ArrayList<Box> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        Object o;
        System.out.println(list);
        System.out.println(list.contains(new Box(1, 1)));
        System.out.println(Integer.toHexString(b1.hashCode()));
        System.out.println(Integer.toHexString(b4.hashCode()));
    }

    private static void arrayListExample() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next(); // immutable
            System.out.println(s);
        }
        System.out.println(list);
        list.remove(list.size()-1); // stack
    }
}
