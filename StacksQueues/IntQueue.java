package StacksQueues;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;
import java.util.InputMismatchException;

public class IntQueue
{
    public static void main(String[] args)
    {
        int[] nums = readInts();
        System.out.println(Arrays.toString(nums));
    }

    public static int[] readInts()
    {
        In in = new In();
        Queue<Integer> q = new Queue<>();
        while (!in.isEmpty())
            try
            {
                q.enqueue(in.readInt());
            } catch (InputMismatchException e)
            {
                break;
            }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }
}
