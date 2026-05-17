import java.util.*;


class Tuple{
int node;
int wt; 
int p;

  public Tuple(int node,int wt,int p){
this.node=node;
this.wt=wt;
this.p=p;
}
}

class Node{

int node;
int wt;
public Node(int node,int wt){
this.node=node;
this.wt=wt;
}
}

public class Prims{

 public static void primsAlgo( List<List<Node>> adj,int N){

   boolean visi[]=new boolean[N];
    PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));

    pq.add(new Tuple(0,0,-1));
int cost=0;
    while(!pq.isEmpty()){
     Tuple n=pq.poll();
     int w=n.wt;
     int v=n.node;
     int parent=n.p;

      if(visi[v]) continue; 
      visi[v]=true;
       System.out.println(parent+"----"+v);
      cost+=w;
         for(Node adjNode:adj.get(v)){
                 int adjV=adjNode.node;
                int adjWt=adjNode.wt; 
                  if(!visi[adjV]) pq.add(new Tuple(adjV,adjWt,v));      
}
}
   System.out.println(cost);

}


public static void main(String[] args){
  List<List<Node>> adj=new ArrayList<>();

  int N=5;
for(int i=0;i<N;i++){
adj.add(new ArrayList<>());
}


 adj.get(0).add(new Node(3,6));
 adj.get(0).add(new Node(1,2));

 adj.get(1).add(new Node(0,2));
 adj.get(1).add(new Node(3,8));
 adj.get(1).add(new Node(4,5));
 adj.get(1).add(new Node(2,3));

 adj.get(3).add(new Node(1,8));
 adj.get(3).add(new Node(0,6));

 adj.get(2).add(new Node(1,3));
 adj.get(2).add(new Node(4,7));

 adj.get(4).add(new Node(1,5));
 adj.get(4).add(new Node(2,7));



 primsAlgo(adj,N);
}

}