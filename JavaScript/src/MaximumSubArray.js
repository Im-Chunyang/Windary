/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * Accepted.
 */


/**
 * @param {number[]} nums
 * @return {number}
 */
let maxSubArray = function (nums) {
    let tmp = 0;
    let max = nums[0];

    nums.forEach(function (i) {
        tmp += i;
        if (tmp > max) {
            max = tmp;
        }

        if (tmp < 0) {
            tmp = 0;
        }
    });

    return max;
};


if (maxSubArray([1]) === 1) {
    console.log("pass")
} else {
    console.error("failed")
}

if (maxSubArray([-4, -2]) === -2) {
    console.log("pass")
} else {
    console.error("failed")
}

if (maxSubArray([1, 0, -1]) === 1) {
    console.log("pass")
} else {
    console.error("failed")
}

if (maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]) === 6) {
    console.log("pass")
} else {
    console.error("failed")
}