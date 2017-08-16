package StacksQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{

    private Node front, back;
    private int len = 0;

    public Deque() // construct empty deque
    {
    }

    public boolean isEmpty() // is the deque empty?
    {
        return len == 0;
    }

    public int size() // return number of items on the deque
    {
        return len;
    }

    public void addFirst(Item item) // add the item to the front
    {
        if (item == null)
        {
            throw new IllegalArgumentException();
        }

        //copies over the front node to a temp var, and makes the front new node
        Node oldFront = front;
        front = new Node();

        //node after the new front one is the old front one
        front.after = oldFront;
        //current node is item passed
        front.item = item;
        //if the deque is already 1 or more node(s) long, the new first node is BEFORE the old first node
        if (len > 0)
            oldFront.before = front;
            //else, there is only 1 node now in the deque, and so the first and last nodes are the same
        else
            back = front;

        len++;
    }

    public void addLast(Item item) // add the item to the back
    {
        if (item == null)
        {
            throw new IllegalArgumentException();
        }
        //copies over the back node to a temp var, and makes the back new node
        Node oldBack = back;
        back = new Node();

        //node after the new back one is the old back one
        back.before = oldBack;
        //current node is item passed
        back.item = item;
        //if the deque is already 1 or more node(s) long, the new back node is AFTER the old back node
        if (len > 0)
            oldBack.after = back;
            //else, there is only 1 node now in the deque, and so the first and last nodes are the same
        else
            front = back;

        len++;
    }

    public Item removeFirst() // remove and return item from front
    {
        if (this.isEmpty()) throw new NoSuchElementException();


    }

    public Item removeLast(Item item) // remove and return item from back
    {
        if (this.isEmpty()) throw new NoSuchElementException();


    }

    @Override
    public Iterator<Item> iterator() // return an iterator over items in order from front to back
    {
        return l.iterator();
    }

    private class Node
    {
        private Item item;
        private Node after, before;
    }
}
