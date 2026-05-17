public class NQueens{

static int N=4;
static int[] upperRow=new int[N];
static int[] leftDiagonal=new int[2*N-1];
static int[] rightDiagonal=new int[2*N-1];
 
public static boolean solve(int row,char[][] board){
 
if(row==N) return true;

for(int col=0;col<N;col++){

if( upperRow[col]==0 &&
    leftDiagonal[N-1+row-col]==0 &&
    rightDiagonal[row+col]==0){

    upperRow[col]=1;
    leftDiagonal[N-1+row-col]=1;
    rightDiagonal[row+col]=1;
    board[row][col]='Q';

    if(solve(row+1,board)) return true;
    
    upperRow[col]=0;
    leftDiagonal[N-1+row-col]=0;
    rightDiagonal[row+col]=0;
    board[row][col]='.';



}
}

return false;
}

public static void main(String[] args){
  
char[][] board=new char[N][N];
for(int i=0;i<N;i++){

for(int j=0;j<N;j++){
board[i][j]='.';
}

}

solve(0,board);
for(int i=0;i<N-1;i++){
System.out.print("-----");

}
System.out.println(" ");

for(int i=0;i<N;i++){

System.out.print("| ");

   for(int j=0;j<N;j++){
     System.out.print(board[i][j]+" |");
     
   }

System.out.println(" ");

}
for(int i=0;i<N-1;i++){
System.out.print("-----");

}
}

}