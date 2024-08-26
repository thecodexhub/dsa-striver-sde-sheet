package greedy_algorithm.job_sequencing;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static int maxProfit(Job[] jobs) {
        Arrays.sort(jobs, new SortJobsByProfit());
        int maxProfits = 0, maxDeadline = -1;

        for (Job job: jobs) {
            maxDeadline = Math.max(maxDeadline, job.getDeadline());
        }

        int[] hash = new int[maxDeadline + 1];
        Arrays.fill(hash, -1);

        for (Job job : jobs) {
            for (int j = job.getDeadline(); j >= 0; j--) {
                if (hash[j] == -1) {
                    hash[j] = job.getId();
                    maxProfits += job.getProfit();
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(hash));
        return maxProfits;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[8];

        jobs[0] = new Job(1, 4, 20);
        jobs[1] = new Job(2, 5, 60);
        jobs[2] = new Job(3, 6, 70);
        jobs[3] = new Job(4, 6, 65);
        jobs[4] = new Job(5, 4, 25);
        jobs[5] = new Job(6, 2, 80);
        jobs[6] = new Job(7, 2, 10);
        jobs[7] = new Job(8, 2, 22);

        int profit = maxProfit(jobs);
        System.out.println(profit);
    }
}

class Job {
    private final int id;
    private final int deadline;
    private final int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getId() {
        return this.id;
    }

    public int getDeadline() {
        return this.deadline;
    }

    public int getProfit() {
        return this.profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}

class SortJobsByProfit implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return job2.getProfit() - job1.getProfit();
    }
}
