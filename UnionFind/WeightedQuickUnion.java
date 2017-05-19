package UnionFind;

import java.util.Scanner;

/*
 * Uses int array of length N to store a union's "id".
 * p and q are connected if they have the same 'root'
 *
 * id[i] is 'parent' of i
 *
 * id[id[id[...id[i]...]]] is 'root' of i
 *
 * sz[i] is the size of the tree structure whose root is i
 *
 * Find: check if p and q have same root
 *
 * Union: when merging components containing p and q,
 * root of smaller tree becomes child of root of larger tree
 *
 * Steps:
 *
 * 1. All entries initially have different
 * ids (meaning no two or more objects form a component)
 * 		- set the id of each object i to i ( id[i]=i )
 *
 * 2. if root(p)==root(q) then p and q connected, else not connected
 *
 * 3. when creating a union between p and q,
 * 		id[root(smaller tree)] = max(root(p),root(q))
 */


public class WeightedQuickUnion
{

    private static int id[], sz[];

    public WeightedQuickUnion(int N)
    {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
    }

    int root(int i)
    {
        // root of i
        while (i != id[i]) // while i is not its own parent
        {
            // set immediate parent of i to be the grandparent of i
//          id[i] = id[id[i]];
            i = id[i]; // set i equal to its grandparent

            /*
             * this implementation makes i 'skip a generation' per iteration, effectively halving the iterations of the loop
             * the parent-->grandparent assignment is done before the child-->parent assignment so the initial iteration of the loop is child-->grandparent rather than child-->parent
             */
        }
        // now i==id[i], meaning current i is equal to the root of the argument passed into the method
        return i; // return the root of passed parameter
    }

    boolean connected(int p, int q)
    {
        // checks if p and q are connected
        return root(p) == root(q); // if p and q have same root, they are
        // connected, else not connected
    }

    void union(int p, int q)
    {
        if (connected(p, q)) return;

        int a = root(p), b = root(q);

        if (sz[a] < sz[b])
        {
            // if size of tree containing p is smaller than size of tree containing q
            id[a] = b; // direct parent of root(p) is now root(q)
            sz[b] += sz[a]; // tree whose root is q increases in size by sz[root(p)]
        } else
        {
            id[b] = id[a];
            sz[a] += sz[b];
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        WeightedQuickUnion wqu = new WeightedQuickUnion(N);

        String s;

        while (true)
        {
            s = sc.nextLine().trim();
            if (s.toLowerCase().equals("x")) break;

            int p = Integer.parseInt(s.charAt(0) + "");
            int q = Integer.parseInt(s.charAt(2) + "");

            wqu.union(p, q);
        }

        for (int i = 0; i < id.length; i++)
        {
            System.out.println("node: " + i + ", parent: " + id[i] + ", root: " + wqu.root(i));
        }
    }
}


/*

Sample Input:

10
4 3
3 8
6 5
9 4
2 1
5 0
7 2
6 1
7 3
x

Output:

node: 0, parent: 6, root: 6
node: 1, parent: 2, root: 6
node: 2, parent: 6, root: 6
node: 3, parent: 4, root: 6
node: 4, parent: 6, root: 6
node: 5, parent: 6, root: 6
node: 6, parent: 6, root: 6
node: 7, parent: 2, root: 6
node: 8, parent: 4, root: 6
node: 9, parent: 4, root: 6

*/



