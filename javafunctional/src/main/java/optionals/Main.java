package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
    	
    	Object value= Optional.ofNullable("some Value")
    	                      .orElseGet(()-> "default Value");
    	
    	System.out.println(value);
    	
    	Object value2= Optional.ofNullable(null)
                                .orElseGet(()-> "default Value");

        System.out.println(value2);  
        
        
        Object value3= Optional.ofNullable("hello")
                               .orElseThrow(() -> new IllegalStateException("some exception message!"));

        System.out.println(value3);  
        
        
        
      //  Optional.ofNullable(null)
      //                        .ifPresent(()->System.out.println("can not send email"));
                         

     

    	
    	
    	
    	
    	
    	
    	

       /* Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));*/

    }
}
