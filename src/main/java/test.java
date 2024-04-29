import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class test {

  public static void main(String[] args) {

    int [] nums = {1,5,7,99,98,97,3,5,95,90,10};

    System.out.println(periodIsLate(LocalDate.of(2024, 3, 25),LocalDate.of(2024, 4, 23),32));
      }

  public static boolean periodIsLate(LocalDate last,LocalDate today,int cycleLength) {
    Period period = Period.between(last, today);
    System.out.println(period.getDays());
    return period.getDays() > cycleLength;
  }


  public static List<List<Integer>> findPairsThatSumToTarget(int[] nums) {



    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == 100) {
          List<Integer> pair = new ArrayList<>();
          pair.add(nums[i]);
          pair.add(nums[j]);
          result.add(pair);
        }
      }
    }
    return result;
  }
}


