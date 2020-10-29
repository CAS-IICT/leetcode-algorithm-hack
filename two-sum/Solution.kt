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

fun main(){
    val arr:IntArray = intArrayOf(2,7,11,15)
    val target:Int = 9
    val result = Solution().twoSum(arr,target)
    result?.let{
        var list = result.toList()
        println(list)
    }
}
