import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickUnionUF {
    private int[] id;
    private int count;
    public QuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }
    private void validate(int p) {
        int N = id.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N-1));
        }
    }
    public void show_array() {
        String s = "";
        for (int i = 0; i < id.length; i++) {
            s += " "+id[i];
        }  
        StdOut.println(s);
    }
    private int find(int p) {
        validate(p);
        while(id[p] != p) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return find(p) == find(q);
    }
    public int count() {
        return count;   
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N); 
        uf.show_array();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            uf.show_array();
        }
    }
}