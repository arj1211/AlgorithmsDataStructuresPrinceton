package StacksQueues;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.InputMismatchException;

public class ReverseStack
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty())
            try
            {
                stack.push(StdIn.readInt());
            } catch (InputMismatchException e)
            {
                break;
            }
        /*for (int i : stack)
            StdOut.print(i+" ");*/
        while (!stack.isEmpty())
            StdOut.print(stack.pop() + " ");
    }
}
