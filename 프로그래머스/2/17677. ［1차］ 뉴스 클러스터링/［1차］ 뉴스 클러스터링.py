from collections import Counter

def solution(str1, str2):
    str1, str2 = str1.upper(), str2.upper()
    s1, s2 = [], []

    for i in range(len(str1) - 1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            s1.append(str1[i:i+2])

    for i in range(len(str2) - 1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            s2.append(str2[i:i+2])

    if not s1 and not s2:
        return 65536

    counter1 = Counter(s1)
    counter2 = Counter(s2)

    common_s = sum((counter1 & counter2).values())
    sum_s = sum((counter1 | counter2).values())

    answer = common_s / sum_s

    return int(answer * 65536)