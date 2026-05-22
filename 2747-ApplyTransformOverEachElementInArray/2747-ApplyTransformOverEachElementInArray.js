// Last updated: 22/05/2026, 11:19:39
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const temp = [];
    for(i = 0; i < arr.length; i++){
        temp[i] = fn(arr[i], i);
    }
    return temp;
};