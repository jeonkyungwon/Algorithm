function solution(x) {
    let xCopy = x
    let y = 0;
    
    while (x > 0) {
        y += x % 10;
        x = parseInt(x / 10);
    }
    
    if (xCopy % y == 0) {
        return true
    } else {
        return false
    }
}