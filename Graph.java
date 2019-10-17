import java.util.*;
public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    public int[] mutualFriend(int n1 ,int n2){
        int arr[] = new int[adj[n1].size()];
        int arr1[] = new int[adj[n2].size()];
        int a[] = new int[V];
        Iterator<Integer> i1 = adj[n1].iterator();
        Iterator<Integer> i2 = adj[n2].iterator();
        int i,j;
        i=j=0;
        while (i1.hasNext()){
            arr[i]=(Integer) i1.next();
            i++;
        }
        while (i2.hasNext()){
            arr1[j]=(Integer)i2.next();
            j++;
        }
        int count=0;
        //System.out.print("friends of " +n1 +" are ");
        /*for (int n: arr)
            System.out.print(n + " ");
        System.out.println();*/
        //System.out.print("friends of " +n2 +" are ");
        /*for (int m: arr1)
            System.out.print(m + " ");*/
        System.out.println();
        System.out.println();
        //System.out.print("Mutual friends of " + n1 + " & " + n2);
        System.out.println();
        for (int i3=0;i3<adj[n1].size();i3++){
            for (int i4=0;i4<adj[n2].size();i4++){
                if(arr[i3]==arr1[i4]){
                    count++;
                    a[arr[i3]]++;
                    break;
                }
            }
        }
        //System.out.println("\nTotal mutual friends are " + count);
        int mutual[] = new int[count];
        int k=0;
        for(int i5=0;i5<a.length;i5++){
            if (a[i5]>0){
                mutual[k]=i5;
                k++;
            }
        }
        return mutual;
    }
    public void suggestedFriend(int n1){
        int a[] = new int[V];
        int arr[] = new  int[adj[n1].size()];
        Iterator<Integer> i = adj[n1].iterator();
        int j=0;
        while (i.hasNext()) {
            arr[j] = (Integer)i.next();
            j++;
        }
        for(int k=0;k<arr.length;k++){
            Iterator<Integer> i1 = adj[arr[k]].iterator();
            while (i1.hasNext()){
                a[(Integer)i1.next()]++;
            }
            /*System.out.println(arr[k]);
            for (int p:a)
                System.out.print(p +" ");
            System.out.println();*/
        }
        for (int n: a){
            System.out.print(n+" ");
        }
        System.out.println();
        int l1=0;
        for(int l=0;l<a.length;l++){
            if (a[l] > 1) {
                for (l1 = 0; l1 < arr.length; l1++) {
                    if (l == arr[l1] || l==n1)
                        break;
                }
                if (l1==arr.length)
                    System.out.print(l+" ");
            }
            else
                continue;
        }
    }
}
