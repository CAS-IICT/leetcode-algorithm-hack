/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let arr = []
    let i = nums1.length == 0 ? Infinity : 0
    let j = nums2.length == 0 ? Infinity : 0
    while (i < nums1.length || j < nums2.length) {
        if (j == Infinity || (nums1[i] <= nums2[j] && i != Infinity)) {
            arr.push(nums1[i])
            i = i + 1 < nums1.length ? i + 1 : Infinity
            continue
        }
        if (i == Infinity || (nums2[j] < nums1[i] && j != Infinity)) {
            arr.push(nums2[j])
            j = j + 1 < nums2.length ? j + 1 : Infinity
            continue
        }
    }
    return arr.length % 2 == 0
        ? (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2
        : arr[parseInt(arr.length / 2)]
}

const test=[
    [[1,2,3],[4,5,6]],
    [[],[4]],
    [[1],[]],
    [[2,5,8],[1,1,1]],
    [[3,5,11],[2,20,100]],
    [[1,2,8],[1,11,7,8,9,12]]
]
for (let i in test) {
    console.log(findMedianSortedArrays(test[i][0],test[i][1]))
}
