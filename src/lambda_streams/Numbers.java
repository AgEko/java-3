package lambda_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results where ever possible.
        System.out.println(nums);
        System.out.println(addLam.apply(nums));
        System.out.println(subLam.apply(nums));
        System.out.println(multiLam.apply(nums));
        System.out.println(divLam.apply(nums));
        System.out.println(maxLam.apply(nums));
        System.out.println(minLam.apply(nums));
        System.out.println(compare(2, 4));//comLam
        appLam.apply(1337);
        System.out.println(nums);




        //printTest(nums , (c) -> c % 2 != 0);



        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...

        */



    }

    //todo: need a functional interface for lambdas





    public static void printTest(List<Integer> nums, Predicate<Integer> predicate){
        for (Integer a : nums) {
            System.out.println(a);
            System.out.println(predicate.test(a));
        }
    }


    ///////////////////////////////////

    static Function<Integer, Boolean> isOddLam = (i) -> i % 2 != 0;
    static Function<Integer, Boolean> isEvenLam = (i) -> i % 2 == 0;
    static Function<Integer, Boolean> isPrimeLam = (i) -> {
        for(int n = 2; n < i; ++i) {
            if (i % n == 0) {
                return false;
            }
        }
        return true;
    };
    static Function<List<Integer>, Integer> addLam = (List<Integer> numList) -> {
        int result = 0;
        for(int i : numList){
            result += i;
        }
        return result;
    };
    static Function<List<Integer>, Integer> subLam = (List<Integer> numList) -> {
        int result = 0;
        for(int i : numList){
            result -= i;
        }
        return result;
    };
    static Function<List<Integer>, Long> multiLam = (List<Integer> numList) -> {
        long result = 1;
        for(int i : numList){
            result = result * i;
        }
        return result;
    };
    static Function<List<Integer>, Double> divLam = (List<Integer> numList) -> {
        double result =  nums.get(0);
        for (int i : numList){
            result = result / i;
        }
        return result;
    };
    static Function<List<Integer>, Integer> maxLam = (List<Integer> numList) -> numList.stream().max(Integer::compareTo).get();
    static Function<List<Integer>, Integer> minLam = (List<Integer> numList) ->  numList.stream().min(Integer::compareTo).get();
//    static Function<List<Integer>, Integer> comLam = (List<Integer> numList ) -> {
//        if (nums.get(a) > nums.get(b)){
//            return 1;
//        }
//        return -1;
//    };//todo get this to work ^^^
    static Function<Integer, Integer> appLam = (Integer n) -> {
        ArrayList<Integer> newList = new ArrayList<>(nums);
        newList.add(n);
        nums = newList;
        return n;
    };




    //todo

    static boolean isOdd(int i) {
        return i % 2 != 0;
    }
    static boolean isEven(int i) {
        return i % 2 == 0;
    }
    static boolean isPrime(int i) {
        for(int n = 2; n < i; ++n) {
            if (i % n == 0) {
                return false;
            }
        }
        return true;
    }
    static int added(List<Integer> numList) {
        int result = 0;
        for(int i : numList){
            result += i;
        }
        return result;
    }

    static int subtracted(List<Integer> numList) {
       int result = 0;
       for(int i : numList){
           result -= i;
       }
        return result;
    }

    static long multipled(List<Integer> numList) {
        long result = 1;
        for(int i : numList){
            result = result * i;
        }
        return result;
    }

    static double divided(List<Integer> numList) {
        double result =  nums.get(0);
        for (int i : numList){
            result = result / i;
        }
        return result;
    }

    static int findMax(List<Integer> numList) {
         return numList.stream().max(Integer::compareTo).get();
    }

    static int findMin(List<Integer> numList) {
        return numList.stream().min(Integer::compareTo).get();
    }

    static int compare(int a, int b) {
        if (nums.get(a) > nums.get(b)){
            return 1;
        }
        return -1;
    };
//TODO get this into a Lambda

    static int append(int n) {
        ArrayList<Integer> newList = new ArrayList<>(nums);
        newList.add(n);
        nums = newList;
        return n;
    };

}
