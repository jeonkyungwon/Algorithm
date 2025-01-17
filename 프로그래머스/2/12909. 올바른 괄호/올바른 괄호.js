function solution(s){
    let result = 0;
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] === "(") {
            result += 1;
        }
        else {
            if (result === 0) {
                return false;
            }
            result -= 1;
        }
    }

    if (result === 0) {
        return true;
    }
    return false;
}

/*
    조건문 부분에서 ? 함수 적극 이용하기
    ex) result === 0 ? true : fasle;
*/
