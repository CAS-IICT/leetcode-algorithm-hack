/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

function twoSum(nums, target) {
    for (let i in nums) {
        for (let j in nums) {
            if (i == j) continue
            if (nums[i] + nums[j] == target) return [parseInt(i), parseInt(j)]
        }
    }
    return null
}

// test
let nums = [2, 7, 11, 15]
let target = 9
console.log(twoSum(nums, target))
