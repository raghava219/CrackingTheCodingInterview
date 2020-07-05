import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ladder { 
     public static void main(String[] args) { 
        List<String> numbers = Arrays.asList("1","2","3","4","4");
        Stream<String> output = numbers.stream().allMatch(c -> c.contains("spring"));
    }
     
 }