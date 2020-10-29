class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var chars=""
        var i=0
        while(i<s.length){
            var index = chars.indexOf(s[i])
            if(index==-1){
                chars+=s[i++]
                if(max<chars.length) max = chars.length
            }else chars = chars.substring(index+1)
        }
        return max
    }
}

fun main(args: Array<String>){
    for (element in args){
        var solution = Solution()
        var res = solution.lengthOfLongestSubstring(element)
        println(res)
    }
}
