/**
 * @param {string} s
 * @return {number}
 * use slide window
 */
const lengthOfLongestSubstring = function(s) {
    let chars = ''
    let max = 0
    let i = 0
    while (i < s.length) {
        let index = chars.indexOf(s[i])
        if (index == -1) {
            chars += s[i++]
            max = max > chars.length ? max : chars.length
        } else {
            //chars = chars.slice(index + 1, chars.length)
            chars = chars.substr(1)
        }
    }
    return max
}

/**
 * @param {string} s
 * @return {number}
 * use hash Map
 */
const lengthOfLongestSubstring2 = function(s) {
    if (!s || s.length == 0) return 0
    let index = -1,
        max = 0
    const chars = new Map()
    for (let i = 0; i < s.length; i++) {
        const lastIndex = chars.get(s[i])
        if (lastIndex != undefined && lastIndex > index) index = lastIndex
        chars.set(s[i], i)
        max = max > i - index ? max : i - index
    }
    return max
}

let args = process.argv.splice(2)
for (let opt of args) {
    console.log(lengthOfLongestSubstring(opt))
}
