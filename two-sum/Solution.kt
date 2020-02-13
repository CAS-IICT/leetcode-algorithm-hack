class Solution {
    fun twoSum(arr:IntArray,target:Int):IntArray?{
        for(i:Int in arr.indices){
            for(j:Int in arr.indices){
                if(i==j) continue
                if((arr[i]+arr[j])==target) return intArrayOf(i,j)
            }
        }
        return null
    }

}
