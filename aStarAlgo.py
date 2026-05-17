graphNode={
'A':[('B',6),('F',3)],
'B':[('C',3),('D',2)],
'C':[('D',1)],
'D':[('C',1),('E',8)],
'E':[('I',5),('J',5)],
'F':[('G',1),('H',7)],
'G':[('I',3)],
'H':[('I',2)],
'I':[('E',5),('J',3)],

}


def get_neighbor(v):
    if v in graphNode:
        return graphNode[v]
    return None


def h(v):
  H_dist = {
            'A': 10,
            'B': 8,
            'C': 5,
            'D': 7,
            'E': 3,
            'F': 6,
            'G': 5,
            'H': 3,
            'I': 1,
            'J': 0             
        }
  return H_dist[v];


def aStarAlgo(startNode,endNode):
  
   


  openSet=set(startNode)
  closeSet=set()
  g={}
  parent={}
  g[startNode]=0;
  parent[startNode]=startNode

  while(len(openSet)>0):
   n=None
   
   for v in openSet:
    if(n==None or g[n]+h(n)>g[v]+h(v)):
     n=v;
    
   if(n==None):
     print("path not exist")
     return None 
   
   if(n==endNode):
      path=[]
       
      while(parent[n]!=n):
        path.append(n);
        n=parent[n];  
      path.append(startNode)
      
      path.reverse()
   
      print("path is ",path)
      return path
   
   
   for (m,weight) in get_neighbor(n):
     if(m not in openSet and m not in closeSet):
      g[m] = g[n] + weight
      parent[m]=n
      openSet.add(m)
     
     else:
      if(g[m]>g[n]+weight ):
        g[m] = g[n] + weight
        parent[m]=n

        if(m in closeSet):
          closeSet.remove(m)
          openSet.add(m) 
        
   
   openSet.remove(n)
   closeSet.add(n) 
     
   
  print("Path not exist")
  return None   




aStarAlgo('A','J')








 
 