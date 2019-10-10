/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratkaisu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markulai
 */
public class Ratkaisu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] trees = {3, 4, 6, 8, 5, 3, 7};
        //int [] trees = A;
        int alice = 2;
        //int alice = K;
        int bob = 3;
        //int bob = L;

        int bigger_index = 0;
        int smaller_index = 0;
        if (alice > bob) {
            bigger_index = alice;
            smaller_index = bob;
        } else {
            bigger_index = bob;
            smaller_index = alice;
        }

        //lets find the bigger input number the biggest sum
        int bigger_start = find_greatest_sum_index(trees, bigger_index);
        int bigger_sum = summarize_apples(trees, bigger_start, bigger_index);
        System.out.println(bigger_sum);

        //then create two separate arrays for remaing
        List<Integer> remaining_left = new ArrayList<>();

        List<Integer> remaining_right = new ArrayList<>();

        for (int i = 0; i < bigger_start; i++) {
            remaining_left.add(trees[i]);
        }

        for (int i = bigger_start + bigger_index; i < trees.length; i++) {
            remaining_right.add(trees[i]);
        }

        System.out.println("Remaining left: " + remaining_left);
        System.out.println("Remaining right: " + remaining_right);

        //Integer[] remaining_a = (Integer[])remaining_left.toArray(new Integer[remaining_left.size()]);
        //Integer[] remaining_b = (Integer[])remaining_right.toArray(new Integer[remaining_right.size()]);
        int a_biggest_index = find_greatest_sum_index(remaining_left, smaller_index);
        int b_biggest_index = find_greatest_sum_index(remaining_right, smaller_index);

        int final_smaller_sum = 0;
        if (summarize_apples(remaining_left, a_biggest_index, smaller_index) > summarize_apples(remaining_right, b_biggest_index, smaller_index)) {
            final_smaller_sum = summarize_apples(remaining_left, a_biggest_index, smaller_index);
        } else {
            final_smaller_sum = summarize_apples(remaining_right, b_biggest_index, smaller_index);
        }

        int final_sum = bigger_sum + final_smaller_sum;
        System.out.println("components are, bigger 3-sum: " + bigger_sum + ", biggest smaller sum: " + final_smaller_sum + " which makes " + final_sum);

    }

    public static int find_greatest_sum_index(List<Integer> trees, int consequtives) {

        int max_sum = 0;
        int max_index = 0;
        int steps = trees.size() - consequtives;
        //Let's find the maximum consequtive figures
        for (int i = 0; i < steps; i++) {
            int sum = 0;
            for (int b = 0; b < consequtives; b++) {
                sum = sum + trees.get(i + b);
            }
            if (sum > max_sum) {
                max_sum = sum;
                max_index = i;
            }
        }

        return max_index;

    }

    public static int summarize_apples(int[] trees, int index, int consequtives) {
        int sum_of_apples = 0;
        for (int i = 0; i < consequtives; i++) {
            sum_of_apples = sum_of_apples + trees[index + i];
        }

        return sum_of_apples;
    }

    public static int summarize_apples(List<Integer> trees, int index, int consequtives) {
        int sum_of_apples = 0;
        for (int i = 0; i < consequtives; i++) {
            sum_of_apples = sum_of_apples + trees.get(index + i);
        }

        return sum_of_apples;
    }

    public static int find_greatest_sum_index(int[] trees, int consequtives) {

        int max_sum = 0;
        int max_index = 0;
        int steps = trees.length - consequtives;
        //Let's find the maximum consequtive figures
        for (int i = 0; i < steps; i++) {
            int sum = 0;
            for (int b = 0; b < consequtives; b++) {
                sum = sum + trees[i + b];
            }
            if (sum > max_sum) {
                max_sum = sum;
                max_index = i;
            }
        }

        return max_index;

    }

}
