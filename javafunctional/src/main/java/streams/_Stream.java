package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
      //List.of is Java 9 feature
      /*  List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );
        
        */
    	
    	List<Person> people = Arrays.asList(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

    	
    	//1st way
        people.stream()
                .map(person -> person.name) //take a function
                .mapToInt(String::length)//length of each name
                .forEach(System.out::println);	
        
        
        //2nd way //Although 2nd way is what we have implemented in the first way
        //so basically we dont have to write all this thing, instead we can make inline everything
        Function<Person,String> personStringFunction=(person) -> person.name;
        ToIntFunction<String> length=x-> x.length();   //String::length;
        IntConsumer  println=x->System.out.println(x);//System.out::println;
        
        people.stream().map(personStringFunction).mapToInt(length).forEach(println);

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
