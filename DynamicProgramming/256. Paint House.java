// t:n s:1
class Solution {
    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0) return 0;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for (int i=1; i<costs.length; i++) {
            int prevRed = red;
            int prevBlue = blue;
            int prevGreen = green;
            red = Math.min(prevBlue, prevGreen) + costs[i][0];
            blue = Math.min(prevRed, prevGreen) + costs[i][1];
            green = Math.min(prevRed, prevBlue) + costs[i][2];
        }
        return Math.min(Math.min(red, blue), green);
    }
}

// t:n s:1
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs[0].length == 0) return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int n = costs.length - 1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}

// t:n s:n
class Solution {
    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0) return 0;
        int n = costs.length;
        int[] red = new int[n];
        int[] blue = new int[n];
        int[] green = new int[n];
        red[0] = costs[0][0];
        blue[0] = costs[0][1];
        green[0] = costs[0][2];
        for (int i=1; i<n; i++) {
            red[i] = Math.min(blue[i-1], green[i-1]) + costs[i][0];
            blue[i] = Math.min(red[i-1], green[i-1]) + costs[i][1];
            green[i] = Math.min(blue[i-1], red[i-1]) + costs[i][2];
        }
        return Math.min(Math.min(red[n-1], blue[n-1]), green[n-1]);
    }
}