// t:nlogn s:n
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(deck[deck.length-1]);
        for (int i=deck.length-2; i>=0; i--) {
            deque.offerFirst(deque.pollLast());
            deque.offerFirst(deck[i]);
        }
        int index = 0;
        for (int num : deque) {
            deck[index++] = num;
        }
        return deck;
    }
}