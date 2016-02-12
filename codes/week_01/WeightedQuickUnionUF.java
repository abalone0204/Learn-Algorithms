import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private int[] id;
    private int count;
    private int[] size;
    public WeightedQuickUnionUF(int N){
        id = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i<N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    private void validate(int p) {
        int N = id.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N-1));
        }
    }
    public void show_array() {
        String arrS = "id  : ";
        String sizeS = "size: ";
        for (int i = 0; i < id.length; i++) {
            arrS += id[i]+" ";
            sizeS += size[i]+ " ";
        }  
        StdOut.println(arrS);
        StdOut.println(sizeS);
    }
    private int find(int p) {
        validate(p);
        while(id[p] != p) {
            p = id[p];
        }
        return p;
    }
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return find(p) == find(q);
    }
    public void union(int p, int q){
        validate(p);
        validate(q);
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;

        if (size[pRoot] < size[qRoot]) {
            size[qRoot] += size[pRoot];
            id[pRoot] = qRoot;
        } else {
            size[pRoot] += size[qRoot];
            // 假如兩棵 tree size 相同，會將後者的 root point to 前者的
            id[qRoot] = pRoot;
        }
        count--;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N); 
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