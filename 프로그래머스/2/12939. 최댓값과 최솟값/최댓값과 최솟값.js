function solution(s) {
    const nums = s.split(' ').map(Number);

    let max = nums[0];
    let min = nums[0];

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i];
        }
        if (nums[i] < min) {
            min = nums[i];
        }
    }

    return min + ' ' + max;
}
