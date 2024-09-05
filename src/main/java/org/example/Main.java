package org.example;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Array:A[0]=9 A[1]=3 A[2]=9 A[3]=3 A[4]=9 A[5]=7 A[6]=9
        int [] numbers = {9,3,9,3,9,7,9};
        Main main = new Main();
        main.solution(numbers);

    }

    public int solution(int [] A){

        int numWithNoPair = 0;
        List<Integer> numbers = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());

        Map<Integer,Integer> frequency = new LinkedHashMap<>();
        for(int i = 0; i<numbers.size();i++){
            if (frequency.get(numbers.get(i)) == null){
                frequency.put(numbers.get(i), 1);
            } else {
                frequency.put(numbers.get(i), frequency.get(numbers.get(i))+1);
            }
        }
        for(Map.Entry<Integer,Integer> map: frequency.entrySet()){
            int numFrequency = map.getValue();
            if(numFrequency == 1){
                numWithNoPair = map.getKey();
            }
        }

        System.out.println("sorted "+ numbers);
        System.out.println("frequency "+ frequency);
        System.out.println("No paired number "+ numWithNoPair);

        return numWithNoPair;
    }
}