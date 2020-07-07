package lambda_streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition. 
        List<String> cleaned = capsFirst(animals, false);
        System.out.println("cleaned: " + cleaned);
       
        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        //---------------------------------------

//        capsFirst(animals,true);
//        System.out.println("Caps First: " + capsFirst(animals, false));
//
//        List<String> lowered = lowerFirst(animals,false);
//        System.out.println("lOWER cASE: " + lowered);
//
//        flipAnimals(false);
//        System.out.println(animals);
//
//        sortAnimals(true);
//        System.out.println(animals);

        System.out.println("-------");
        System.out.println("Lambdas");
        System.out.println("-------");

        System.out.println("Caps First: " + capsFirstLam.apply(animals, false));
        System.out.println("lOWER fIRST: " + lowerFirstLam.apply(animals, false));
        System.out.println("Trippin`: " + animals);
        System.out.println("Flippin`: " + flipAnimalsLam.apply(false));
        System.out.println("Sorted: " + sortAnimalsLam.apply(false));

    }
  // Lambdas

    interface LamProcess<A,B, R> {
        R apply (A a, B b);
    }
    static  LamProcess<List<String>, Boolean, List<String>> capsFirstLam = (List<String> animalList, Boolean mutate) ->{
        if(!mutate){
            animals = animalList.stream().map(x -> x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase()).collect(Collectors.toList());
        } else {
            return animalList.stream().map(x -> x.substring(0,1).toUpperCase()+ x.substring(1).toLowerCase()).collect(Collectors.toList());
        }
        return animalList;
    } ;

    static Function <String, String> addAnimalLam = (animal ) -> {
        ArrayList<String> tempList = new ArrayList<>(animals);
        tempList.add(animal);
        animals = tempList;
        return animal;
    };

    static  LamProcess<List<String>, Boolean, List<String>>  lowerFirstLam = (List<String> animalList, Boolean mutate) ->{
        if(!mutate){
            animalList = animalList.stream().map(x -> x.substring(0,1).toLowerCase() + x.substring(1).toUpperCase()).collect(Collectors.toList());
        } else {
            return animalList.stream().map(x -> x.substring(0,1).toLowerCase()+ x.substring(1).toUpperCase()).collect(Collectors.toList());
        }
        return animalList;
    };

    static Function <Boolean, List<String>> flipAnimalsLam = (mutate) -> {
        if(mutate){
            Collections.reverse(animals);
            return animals;
        } else {
            List<String> newAnimalList = animals;
            Collections.reverse(newAnimalList);
            return newAnimalList;
        }
    };

    static Function <Boolean, List<String>> sortAnimalsLam = (mutate) -> {
        if(mutate){
            animals = animals.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            return animals;
        } else {
            List<String> newAnimalList = animals.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            return newAnimalList;
        }
    };


    static List<String> capsFirst(List<String> animalList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercase. Use a stream to accomplish this task.
        // Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array stored as a static class field.  if the flag is set to 'true', mutate the animals and return the animals out of the function.
        // if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function, WITHOUT modifying the original animals array.
//        for(String a : animalList)
       if(!mutate){
           animalList = animalList.stream().map(x -> x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase()).collect(Collectors.toList());
        } else {
           List<String> newAnimalList = animalList;
           return newAnimalList.stream().map(x -> x.substring(0,1).toUpperCase()+ x.substring(1).toLowerCase()).collect(Collectors.toList());
       }
        return animalList;
    }


    static String addAnimal(String animal) {
        //add an animal to the animal list.
        ArrayList<String> tempList = new ArrayList<>(animals);
        tempList.add(animal);
        animals = tempList;
        return animal;
    };


    static List<String> lowerFirst(List<String> animalList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.
        // Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream operations on a 'copy' of the animals list.
        // return the list out of hte function in both cases.
        if(!mutate){
            animalList = animalList.stream().map(x -> x.substring(0,1).toLowerCase() + x.substring(1).toUpperCase()).collect(Collectors.toList());
        } else {
            List<String> newAnimalList = animalList;
            return newAnimalList.stream().map(x -> x.substring(0,1).toLowerCase()+ x.substring(1).toUpperCase()).collect(Collectors.toList());
        }
        return animalList;
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.
        // If the booleaen parameter is true, reverse the static animals array list by mutating the array.
        // if the mutate boolean is false, flip a 'copy' of the animals list, then return that list of flipped animals, WITHOUT mutating the static animals array.
        // return the flipped list in both cases.
        List<String> instructions = Arrays.asList("Flip","the","animals","list","."," ","Mutate","the","animals","only","if","flag","true");
      //  Collections.reverse
        if(mutate){
            Collections.reverse(animals);
            return animals;
        } else {
            List<String> newAnimalList = animals;
            Collections.reverse(newAnimalList);
            return newAnimalList;
        }
    }

    static List<String> sortAnimals(boolean mutate) {
    //sort the animals in alphabetical order.
        // If the boolean parameter is true, mutating the animals list.
        // if the mutate boolean is false, sort a 'copy' of the animals list, then return that list of sorted animals
        // , WITHOUT mutating the static animals array. return the sorted list in both cases.
        if(mutate){
            animals = animals.stream().sorted().collect(Collectors.toList());
            return animals;
        } else {
            List<String> newAnimalList = animals.stream().sorted().collect(Collectors.toList());
            return newAnimalList;
        }
    }



}
