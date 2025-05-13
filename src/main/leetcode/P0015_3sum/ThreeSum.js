/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    const result = [];
    nums.sort((a, b) => a - b);

    for(let i = 0; i < nums.length; i++) {
        if(i > 0 && nums[i] === nums[i - 1]) continue;
        let left = i + 1;
        let right = nums.length - 1;
        let curr = nums[i];

        while(left < right) {
            const sum = curr + nums[left] + nums[right];
            if(sum === 0) {
                result.push([curr, nums[left], nums[right]]);
                left++;
                right--;
                while(left < right && nums[left - 1] === nums[left]) left++;
                while(left < right && nums[right + 1] === nums[right]) right--;

            } else if(sum < 0) {
                left++;
            } else {
                right--;
            }

        }
    }
    return result;
};