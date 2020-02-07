package functionalinterface;


import java.util.List;
import java.util.function.Supplier;
import java.util.Arrays;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlsSupplier.get());
        System.out.println(getDBConnectionUrlsSupplier1.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    //using Supplier 
    static Supplier<String> getDBConnectionUrlsSupplier = () -> "jdbc://localhost:5432/users";
   
            
          
    
    //using Supplier, Supplier returns any kind of Value that you want
    static Supplier<List<String>> getDBConnectionUrlsSupplier1 = ()->Arrays.asList("jdbc://localhost:5432/users","jdbc://localhost:5431/users");
    
    
    //using Supplier, Supplier returns any kind of Value that you want//List of is Java 9 features
    //static Supplier<List<String>> getDBConnectionUrlsSupplier2 = ()->List.of("jdbc://localhost:5432/users");
           
  
    
  

}
