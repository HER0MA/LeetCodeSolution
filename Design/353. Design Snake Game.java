class SnakeGame {
    // point is stored in the form (row * width + col)
    private Deque<Integer> deque;
    private Set<Integer> set;
    private int width;
    private int height;
    private int[][] food;
    private int fdIdx;
    private int score;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    // t:1
    public SnakeGame(int width, int height, int[][] food) {
        deque = new LinkedList<>();
        set = new HashSet<>();
        deque.offerFirst(0);
        set.add(0);
        this.width = width;
        this.height = height;
        this.food = food;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    // t:1
    public int move(String direction) {
        if (score==-1) return -1;
        int row = deque.peekFirst() / width;
        int col = deque.peekFirst() % width;
        switch (direction) {
            case "U" : row --;
                break;
            case "L" : col --;
                break;
            case "D" : row ++;
                break;
            default : col ++;
        }
        int head = row*width + col;
        // corner case: head==deque.peekLast()
        set.remove(deque.peekLast());
        if (row<0 || row==height || col<0 || col==width || set.contains(head)) {
            score = -1;
            return -1;
        }
        set.add(head);
        deque.offerFirst(head);
        if (fdIdx<food.length && food[fdIdx][0]==row && food[fdIdx][1]==col) {
            fdIdx ++;
            score ++;
            set.add(deque.peekLast());
            return score;
        }
        deque.pollLast();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */