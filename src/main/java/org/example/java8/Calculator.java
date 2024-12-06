package org.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    public static void main(String args[]){
        //int result = sum(3,8);
        //System.out.println(result);
        MyFuncInterface obj = (x,y) -> x+y;
        System.out.println(obj.add(4,8));
        IntPredicate pred = n -> n%2==0;
        System.out.println(pred.test(7));

        List<Integer> numberList = Arrays.asList(1,6,3,8,2);
        Stream<Integer> numStream = numberList.stream();

        //numStream.filter(x->x>2).map(a->a*a).sorted().forEach(System.out::println);
        Optional<Integer> maxNum = numStream.filter(x->x>2).map(a->a*a).max(Integer::compareTo);
       // numberList.parallelStream().filter(n->n>1).forEach(System.out::println);
        if(maxNum.isPresent()){
            System.out.println(maxNum.get());
        }
        //ArrayList sqrdNumbers = (ArrayList) numStream.filter(x->x>2).map(a->a*a).collect(Collectors.toList());
    }
//    private static int sum(int x, int y){
//        return x+y;
//    }

}

// Intermediate operations - n number of int operations
// Terminal operations - single terminal operation
