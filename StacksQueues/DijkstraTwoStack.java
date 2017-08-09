package StacksQueues;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DijkstraTwoStack
{

    public static void main(String[] args)
    {


        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty())
        {


            String s = StdIn.readString();
            try
            {
                if (s.equals("(")) ;
                else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                    ops.push(s);
                else if (s.equals("sqrt")) ops.push(s);
                else if (s.equals(")"))
                {
                    String op = ops.pop();
                    double v = vals.pop();

                    if (op.equals("+")) v = vals.pop() + v;
                    if (op.equals("-")) v = vals.pop() - v;
                    if (op.equals("*")) v = vals.pop() * v;
                    if (op.equals("/")) v = vals.pop() / v;
                    if (op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                } else vals.push(Double.parseDouble(s));

            } catch (Exception e)
            {
                break;
            }
        }
        StdOut.println(vals.pop());
    }
}