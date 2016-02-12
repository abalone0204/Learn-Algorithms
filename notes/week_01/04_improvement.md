
# 1. weighted quick-union

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
    - 


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
