package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream3.Gender.*;

public class _Stream3 {

    public static void main(String[] args) {
     
    	
    	List<Person> people = Arrays.asList(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

    	
    	//to check whether the List contains Females Only
    	Predicate<Person>  femalesOnlyPredicate=person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales=  
    		  people.stream()
                    .allMatch(femalesOnlyPredicate);
        
        System.out.println(containsOnlyFemales);
        
        
        //if we have atleast one Female then  anyMatch will return True
        boolean atleastOneFemales=  
      		  people.stream()
                     .anyMatch(femalesOnlyPredicate);
          
          System.out.println(atleastOneFemales);
          
          
          //NotPresent // noneMatch will give  True if at all NotPresent  is not at all available
          Predicate<Person>  NotPresentPredicate=person -> "NotPresent".equals(person.gender);
          boolean NotPresent=  
        		  people.stream()
                         .noneMatch(NotPresentPredicate);
            
            System.out.println(NotPresent);
                 
               

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
