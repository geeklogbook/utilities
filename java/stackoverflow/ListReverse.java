package stackoverflow;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListReverse {

    public static void main(String[] args)
    {
        List<Integer>  nums = Arrays.asList(4,7,2,3);

        Collections.reverse(nums);

        nums.forEach(i -> System.out.print(i + " "));

        nums.forEach(i -> System.out.println(i));
    }
}
