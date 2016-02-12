# Recap

- Quick Union-find 可能會讓樹的高度長太高

> Quick Union-find 連接的方式就是無腦將第二棵接到第一科上面

# 1. weighted quick-union

- 想法：在連接兩個樹的 root 前，先確認哪棵樹的 size（**不是高度喔**），將較小的樹連接到較大的樹下面

- smaller tree go below

- 讓樹的高度盡量扁平（減少 find 需要花的時間）

```java
// weighted quick-union 
i = root(p);
j = root(q);

if(i == j) return; // 兩者已經 union 在一起了
// i 的 tree 高度較低的話，將 i 的 tree 連接到 root 為 j 的下方
// 並且將 i 的 size 加到 j的上面去
if(sz[i] < sz[j]) {id[i] = j; sz[j] += sz[i];}
else              {id[j] = i; sz[i] += sz[j];} 
```

- weighted quick-union 的時間複雜度為 lg(N)

- pf:
  - 假設現在有一個size為 x 的tree: `T1` 要 merge 到 `T2`
  - key-understanding: 
    - sz(T2) >= sz(T1)

# Implementation: Weighted Quick-Union

- Optional: 更改一下 `show_array` 這個 method，把 size 也一起印出來

```java
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
```

- Data Structure: 需要多宣告一個 integer 的 array `size`

- 記得將 size[0]~ size[N-1] 都初始化為 1。

> N = 節點的數量

- 重點會放在 `union` 時，要怎樣根據 size 決定 tree 該如何連接

> 小提醒: 在這個 Data Structure 底下，root 的值跟 index 是相同的

```java
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
            id[qRoot] = pRoot;
        }
        count--;
    }
```

> 注意：這裡是根據 size，而不是 tree height

# 2. Path compression

- 只要在 root 中多加一行

```java
private int root(int i) {
  while(i != id[i]) {
    id[i] = id[id[i]];
    i = id[i];
  }
  return i;
}
```
