package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;
//chaining functions//BiFunction
public class _Function {

    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        //chaining of functions
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100)); //Normal Java Function
        
        //check this out
       /* System.out.println(
                incrementByOneAndMultiply(number: 4, numToMultiplyBy: 100)
        );
        */

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));//By Function

    }
    
    
    //Using Function
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;
     //Normal java Function       
    static int incrementByOne(int number) {
                return number + 1;
      }


    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

 
    
    
    //Below two does the same thing
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
