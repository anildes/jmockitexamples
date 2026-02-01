package jmockitunexpectedinvocation;
import mockit.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestOrderBuilder{
	
	@Mocked
	OrderBuilder realorderBuilder;


 @Test 
 public void testOrderBuilderFlow() {	 
	
	 //OrderBuilder realorderBuilder = new OrderBuilder();
     new Expectations() {{         
         realorderBuilder.build(); result = new Order();
     }};

     realorderBuilder
             .selectItem("Book")      // real method
             .applyDiscount(10)       // real method
             .build();          

     new FullVerifications() {{
         // If you leave this empty, JMockit will fail and say:
         // "Unexpected invocation: selectItem, applyDiscount, and build were called!"
    	 
    	 realorderBuilder.selectItem("Book"); times = 1;
    	 realorderBuilder.applyDiscount(10); times = 1;
     }};
     
     //assertNotNull(result);
 }
}
