// t:nlogn s:n
// sort cars, shortest distance to target first, compare arrive time 
class Solution {
    private class Car {
        int pos;
        double time;
        
        Car(int pos, int target, int speed) {
            this.pos = pos;
            time = (target - pos + 0.0) / speed;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[speed.length];
        for (int i = 0; i < speed.length; i++) {
            cars[i] = new Car(position[i], target, speed[i]);
        }
        Arrays.sort(cars, (a, b) -> a.pos - b.pos);
        int res = cars.length;
        for (int i = cars.length - 1; i > 0; i--) {
            if (cars[i - 1].time <= cars[i].time) {
                res--;
                cars[i - 1].time = cars[i].time;
            }
        }
        return res;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (speed.length < 2) return speed.length;
        TreeMap<Integer, Double> map = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < speed.length; i++) {
            map.put(position[i], (target - position[i] + 0.0) / speed[i]);
        }
        int res = map.size();
        Iterator<Map.Entry<Integer, Double>> iter = map.entrySet().iterator();
        Double prevTime = iter.next().getValue();
        while (iter.hasNext()) {
            double currTime = iter.next().getValue();
            if (currTime <= prevTime) {
                // not update prevTime
                res--;
            } else {
                prevTime = currTime;
            }
        }
        return res;
    }
}