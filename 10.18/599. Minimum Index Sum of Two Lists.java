class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int sum = Integer.MAX_VALUE;
        ArrayList<String> ans = new ArrayList<String>();
        List<String> listTwo = Arrays.asList(list2);
        int tempIndex = 0;
        for(int i=0; i<list1.length; i++){
            if(listTwo.contains(list1[i]) && i+listTwo.indexOf(list1[i])<=sum) {
                sum = i+listTwo.indexOf(list1[i]);
                ans.add(list1[i]);
                System.out.println(list1[i]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}