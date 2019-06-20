// t:nlogn s:n
/**
 * ratio is wage / quality
 * pay group according to max{ratio}
 * sort according to ratio
 * when there are more than K workers
 * remove the one with highest quality
 */
class Solution {
    private class Worker {
        int quality;
        double ratio;
        
        Worker(int quality, int wage) {
            this.quality = quality;
            ratio = (wage + 0.0) / quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[wage.length];
        for (int i = 0; i < wage.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        int qualitySum = 0;
        double res = Double.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < workers.length; i++) {
            qualitySum += workers[i].quality;
            pq.offer(workers[i].quality);
            if (pq.size() > K) qualitySum -= pq.poll();
            // it doesn't matter if remove current worker
            // the correct value has already included by previous calculation
            if (pq.size() == K) res = Math.min(res, workers[i].ratio * qualitySum);
        }
        return res;
    }
}