const arr = [3, 7, 44, 2, 1, 9, 10, 8, 6, 20, 11, 5, 4, 13]

function swap(i, j) {
    let temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
function quick(begin, end) {
    if (begin == end) return
    let pivot = begin + 1
    let tmp = begin + 1
    while (tmp != end) {
        if (arr[tmp] < arr[begin]) swap(tmp, begin)
        else tmp++
    }
    pivot--
    swap(pivot, begin)
    quick(begin, pivot)
    quick(pivot + 1, end)
}
quick(0, arr.length)
console.log(arr)
