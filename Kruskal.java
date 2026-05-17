import java.util.*;



class DisjointSet{

int[] parent;
int[] size;
DisjointSet(int N){
this.parent=new int[N];
this.size=new int[N];
for(int i=0;i<N;i++){
    parent[i]=i;
    size[i]=1;
}
}
 
int findUP(int val){
if(val==parent[val]) return val;

return parent[val]=findUP(parent[val]);
}  


void unionBySize(int u,int v){
int upU=findUP(u);
int upV=findUP(v);

if(upU==upV) return;

if(size[upU]<size[upV]){
parent[upU]=upV;
size[upV]+=size[upU];
}

else{
parent[upV]=upU;
size[upU]+=size[upV];

}
}

}



public class Kruskal{
 
  

public static void main(String[] args){
int[][] edge={{1,1,4},{2,1,2},{3,2,3},{3,2,4},{4,1,5},{5,3,4},{7,2,6},{8,3,6},{9,4,5} };
int N=7;
Arrays.sort(edge,(a,b)->Integer.compare(a[0],b[0]));
DisjointSet ds=new DisjointSet(N);

int cost=0;
for(int[] node:edge){
int wt=node[0];
int u=node[1];
int v=node[2];


if(ds.findUP(u)==ds.findUP(v)) continue;
    
   ds.unionBySize(u,v);
    System.out.println(u+"-----"+v);
   cost+=wt;
} 
System.out.println(cost);
}


}