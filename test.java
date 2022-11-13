
import java.util.Queue;
import java.util.LinkedList;

public class test {
   public static void main(String[] args) {
      Queue<String> customers = new LinkedList<String>();

      customers.add("Rio");
      customers.add("Amy");
      customers.add("Ava");
      customers.add("Ina");
  
      customers.remove();
      System.out.println(customers.element());
      System.out.println(customers.peek());
      System.out.println(customers.poll());
   }
}