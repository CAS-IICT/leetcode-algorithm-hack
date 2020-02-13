/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
function twoSum (nums, target) {
    for(let i in nums){
        for(let j in nums){
            if(i==j) continue
            if((nums[i]+nums[j])==target){
                return [i,j]
            }
        }
    }
    return null
}
