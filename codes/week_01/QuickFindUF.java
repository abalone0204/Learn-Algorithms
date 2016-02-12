import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickFindUF {
    private int[] id;
    private int count;
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }
    public int count() {
        return count;
    }
    /**
    * Returns the component identifier for the component containing site <tt>p</tt>.
    * 找到 p 對應到的 identifier
    * @param  p the integer representing one site
    * @return the component identifier for the component containing site <tt>p</tt>
    * @throws IndexOutOfBoundsException unless <tt>0 &le; p &lt; N</tt>
    */
    public int find(int p) {
        validate(p);
        return id[p];
    }
    private void validate(int p) {
        int N = id.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N-1));
        }
    }
    // 展示目前 id array的樣子
    public void show_array() {
        String s = "";
        for (int i = 0; i < id.length; i++) {
            s += " "+id[i];
        }  
        StdOut.println(s);
    }
    // 測試 p 跟 q 兩點有沒有連結
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }
    // 連結兩個點
    // 將 p 的點連接到 q
    // e.q
    // before: [1,2,3]
    // union(1,3)
    // after: [3,2,3]
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pId = id[p];
        int qId = id[q];
        if(pId == qId) return;
        for (int i= 0; i < id.length; i++) {
            if(id[i] == pId) id[i] = qId;
        }
        count--;

    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N); 
        uf.show_array();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            uf.show_array();
            // StdOut.println(p + " " + q);

        }

    }
}
