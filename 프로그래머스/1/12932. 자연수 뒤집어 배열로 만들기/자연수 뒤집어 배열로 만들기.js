function solution(n) {
    var answer = [];
    while (n > 0) {
        answer.push(n % 10)
        n = parseInt(n / 10)
    }
    return answer;
}

//Math.floor()도 알아두자
