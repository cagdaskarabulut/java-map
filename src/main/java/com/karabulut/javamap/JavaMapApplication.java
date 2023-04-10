package com.karabulut.javamap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class JavaMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMapApplication.class, args);
        exerciseMap();

        //Find second largest number in given list
        findSecondLargestNumber(List.of(4,12,8,3,9,1));

        //Find missing number in sequential numbers list
        List sequentialNumbersList = new ArrayList<Integer>(List.of(1,3,5,2,4,9,8,6));
        findMissingNumberInSequentialNumbersList(sequentialNumbersList);
    }

    public static void exerciseMap(){
        //create map
        System.out.println("Java Map Examples");
        Map<String ,Integer> map=new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.put("E",5);

        //sum with for loop before 1.8
        Collection<Integer> values = map.values();
        int total=0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            total+=map.get(entry.getKey());
        }
        System.out.println("before 1.8 sum = " + total);

        //sum with for loop after 1.8
        List<Integer> list = new ArrayList(map.values());
        Integer total2 = list.stream().reduce(0, Integer::sum);
        System.out.println("after 1.8 sum = " + total);
        System.out.println();

        synchronizedMapExample();
        System.out.println();


        whatWillBeTheOutput1();
        System.out.println();

    }

    public static void synchronizedMapExample() {

        // HashMap with mapping containing country and their currency
        Map<String, String> currencies = new HashMap<String, String>();

        currencies.put("USA", "USD");
        currencies.put("England", "GBP");
        currencies.put("Canada", "CAD");
        currencies.put("HongKong", "HKD");
        currencies.put("Australia", "AUD");

        // Synchronizing HashMap in Java
        currencies = Collections.synchronizedMap(currencies);

        // Make sure to synchronize Map while Iterating
        // getting key set can be outside synchronized block
        Set<String> keySet = currencies.keySet();

        // Synchronizing on HashMap, not on Set
        synchronized(currencies) {
            Iterator<String> itr = keySet.iterator();
            // Must be in synchronized block
            while (itr.hasNext()){
                System.out.println(itr.next());
            }
        }

    }

    public static void whatWillBeTheOutput1() {
        ArrayList list = new ArrayList();
        list.add(5);
        list.add('5');
        list.add("5");
        System.out.println(list);
    }

    private static void findSecondLargestNumber(List<Integer> numbers){
        List<Integer> descList = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("findSecondLargestNumber: " + descList.get(1));
    }

    public static int findMissingNumberInSequentialNumbersList(List<Integer> integerList){
        int missingNumber = 0;
        Collections.sort(integerList);
        //integerList = integerList.stream().sorted().collect(Collectors.toList());

        List<Integer> draftList = new ArrayList<Integer>();
        for (int i = 0; i < integerList.size(); i++) {
            if(i==0){
                draftList.add(integerList.get(i));
            } else {
                if((draftList.get(i-1))+1 != integerList.get(i)){
                    missingNumber = (draftList.get(i-1)+1);
                    break;
                } else {
                    draftList.add(integerList.get(i));
                }
            }
        }
        System.out.println("findMissingNumberInSequentialNumbersList:" + missingNumber);
        return missingNumber;
    }
}
