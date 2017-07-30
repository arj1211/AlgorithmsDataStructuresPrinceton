package StacksQueues;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.InputMismatchException;

public class StatsBag
{
    public static void main(String[] args)
    {
        Bag<Double> nums = new Bag<>();
        while (!StdIn.isEmpty())
            try
            {
                nums.add(StdIn.readDouble());
            } catch (InputMismatchException e)
            {
                break;
            }
        int N = nums.size();

        double sum = 0;
        for (double x : nums)
            sum += x;
        double mean = sum / N;
        //reset sum
        sum = 0;
        for (double x : nums)
            sum += (x - mean) * (x - mean);
        double stddev = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Stddev: %.2f\n", stddev);
    }
}
