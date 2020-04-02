/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
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

findMedianSortedArrays = function(nums1, nums2) {
    if(nums1.length>nums2.length){
        let tmp=nums1
        nums1=nums2
        nums2=tmp
    }
    let start = 0
    let end = nums1.length
    let i = 0
    let j = 0
    let lefti = 0
    let leftj = 0
    let righti = 0
    let rightj = 0
    while(i<=nums1.length && i>=0){
        i = start>end?start:parseInt((start+end)/2)
        j = parseInt((nums1.length+nums2.length+1)/2 - i)
        
        lefti = (i==0?-Infinity:nums1[i-1])
        leftj = (j==0?-Infinity:nums2[j-1])
        righti = (i==nums1.length?Infinity:nums1[i])
        rightj = (j==nums2.length?Infinity:nums2[j])
        
        if(lefti<=rightj && leftj<=righti) break
        else{
            if(lefti>rightj) end=i-1
            if(righti<leftj) start=i+1
        }
    }
    maxLeft = Math.max(lefti,leftj)
    minRight = Math.min(righti,rightj)
    let result = (maxLeft+minRight)/2
    return (nums1.length+nums2.length)%2==0?result:maxLeft
}

const test = [
    [
        [1, 2, 3],
        [4, 5, 6]
    ],
    [[], [4]],
    [[1], []],
    [
        [2, 5, 8],
        [1, 1, 1]
    ],
    [
        [3, 5, 11],
        [2, 20, 100]
    ],
    [
        [1, 2, 8],
        [1, 11, 7, 8, 9, 12]
    ]
]
for (let i in test) {
    console.log(findMedianSortedArrays(test[i][0], test[i][1]))
}
