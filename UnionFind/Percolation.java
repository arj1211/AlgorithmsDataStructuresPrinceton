// package UnionFind;


import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation
{

    static final private int virtualTop = 0;
    final private WeightedQuickUnionUF wQUUF;
    final private int N;
    final private int virtualBottom;


    private int openSites = 0;
    private boolean[][] open;


    public Percolation(int n) // create n*n grid, all sites blocked
    {
        if (n <= 0) throw new IllegalArgumentException("Call to Percolation() : grid dimensions invalid");
        N = n;
        virtualBottom = xyTo1D(N, N) + 1;
        open = new boolean[N + 1][N + 1]; // natural indexed
        wQUUF = new WeightedQuickUnionUF(N * N + 2); // extra for top and bottom virtual sites
    }

    private int xyTo1D(int x, int y) // converts 2D natural coordinates to 1D natural coordinate
    {
        return (x - 1) * N + y;
    }

//    private int xyTo1D_ind(int n, int m) //converts 2D natural coordinates to 1D natural index
//    {
//        return (n+1)*(m+1);
//    }

    public void open(int row, int col) // open site (row, col) if not open already
    {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException("Call to open() : row/col out of bounds");
        if (open[row][col]) return;
        open[row][col] = true;
        openSites++;

        if (row == 1) wQUUF.union(virtualTop, xyTo1D(row, col));
        if (row == N) wQUUF.union(virtualBottom, xyTo1D(row, col));
        if (((row - 1) >= 1) && open[row - 1][col]) // site above
        {
            wQUUF.union(xyTo1D(row - 1, col), xyTo1D(row, col));
        }
        if (((row + 1) <= N) && open[row + 1][col]) // site below
        {
            wQUUF.union(xyTo1D(row + 1, col), xyTo1D(row, col));
        }
        if (((col - 1) >= 1) && open[row][col - 1]) // site on left
        {
            wQUUF.union(xyTo1D(row, col - 1), xyTo1D(row, col));
        }
        if (((col + 1) <= N) && open[row][col + 1]) // site on right
        {
            wQUUF.union(xyTo1D(row, col + 1), xyTo1D(row, col));
        }
    }

    public boolean isOpen(int row, int col) // is site (row, col) open?
    {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException("Call to isOpen() : row/col out of bounds");
        return open[row][col];
    }

    public boolean isFull(int row, int col) // is site (row, col) full?
    {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException("Call to isFull() : row/col out of bounds");
        return wQUUF.connected(virtualTop, xyTo1D(row, col));
    }

    public int numberOfOpenSites() // # of open sites
    {
        return openSites;
    }

    public boolean percolates() // does the system percolate?
    {
        return wQUUF.connected(virtualTop, virtualBottom);
    }


    /* public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Percolation p = new Percolation(sc.nextInt());

        int reps = (int) (Math.random() * p.N * p.N) + 1;

        for (int i = 0; i < reps; i++)
        {
            int r = (int) (Math.random() * 4) + 1;
            int c = (int) (Math.random() * 4) + 1;
            System.out.println("[" + r + ", " + c + "]");
            p.open(r, c);
        }

        System.out.println("Percolates: " + p.percolates());
        System.out.println("Open Sites: " + p.numberOfOpenSites());

    } */

}
