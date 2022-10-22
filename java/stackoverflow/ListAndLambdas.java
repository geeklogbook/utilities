package stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAndLambdas
{
    public static void main(String[] args)
    {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(8);

        List<Integer> nums_two = Arrays.asList(4,7,2,3);


        for(int i : nums_two)
        {
            System.out.println(i);
        }

        //Lambda Expression

        nums_two.forEach(i -> System.out.println(i));


    }
}
