package UnionFind;

import java.util.Scanner;

/*
 * Uses int array of length N to store a union's "id".
 * p and q are connected if and only if they have the same id.
 *
 * Find: check if p and q have same id
 *
 * Union: when merging p and q components,
 * change all entries whose id is id[p] to id[q]
 *
 * Steps:
 *
 * 1. All entries initially have different
 * ids (meaning no two or more objects form a component)
 * 		- set the id of each object i to i ( id[i]=i )
 * 2. if id[p]==id[q] then p and q connected, else not connected
 *
 * 3. when creating a union between p and q,
 * 		id[i] = id[q] , where i is any object connected
 * 					to p (including p itself, so
 * 					id[p] = id[q] )
 */

public class QuickFind {

    private static int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    void union(int p, int q) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p]) id[i] = id[q];
        }
    }

    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        QuickFind qf = new QuickFind(N);
        String s;

        while (true) {
            s = sc.nextLine().trim();
            if (s.toLowerCase().equals("x")) break;

            int p = Integer.parseInt(s.charAt(0) + "");
            int q = Integer.parseInt(s.charAt(2) + "");

            qf.union(p, q);
        }

        for (int i = 0; i < id.length; i++) {
            System.out.println(i + " " + id[i]);
        }
    }
}