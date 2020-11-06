class Solution {
    public int[] sortByBits(int[] arr) {
        // myidea：easy problem pass
        int n = arr.length;
        Arrays.sort(arr);
        Integer[] temp = new Integer[n];
        for(int i = 0;i<n;i++) temp[i] = arr[i];
        Arrays.sort(temp,(o1,o2) -> (numOfOne(o1) - numOfOne(o2) ));
        for(int i = 0;i<n;i++) arr[i] = temp[i];
        return arr;
    }
    // 计算一个数字二进制中1的个数
    public int numOfOne(int x){
        int res = 0;
        while(x != 0){
            res++;
            x&=(x-1);
        }
        return res;
    }
}