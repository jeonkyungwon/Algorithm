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

/*
    split('원하는 구분자') -> 원하는 구분자로 문자열 나누기
    map(Number) -> 정수형으로 변환
    최대, 최소 구하는 함수 -> Math.max() / Math.min()
*/
