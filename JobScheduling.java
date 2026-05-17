import java.util.*;

class Job {

    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling{


public static void main(String[] args){

Job[] jobs=new Job[5];
jobs[0]=new Job(1,2,100);
jobs[1]=new Job(2,1,19);
jobs[2]=new Job(3,2,27);
jobs[3]=new Job(4,1,25);
jobs[4]=new Job(5,3,15);

Arrays.sort(jobs, (a,b) -> b.profit - a.profit);
int maxDeadline=3;
boolean[] slot = new boolean[maxDeadline + 1];
int count=0;
int profit=0;
for(Job job : jobs) {

    for(int j = job.deadline; j >= 1; j--) {

        if(!slot[j]) {
               System.out.println(job.id+"  "+job.deadline+"  "+job.profit);
            slot[j] = true;
            profit += job.profit;
            count++;

            break;
        }
    }
}
System.out.println(count+"   "+ profit);
}
}