def solution(bandage, health, attacks):
    answer = 0
    max_health = health
    time, i = 0, 0
    bandage_time = 0
    
    while i < len(attacks):
        if time == attacks[i][0]:
            health -= attacks[i][1]
            bandage_time = 0
            i += 1
        else:
            bandage_time += 1
            if health + bandage[1] <= max_health:
                health += bandage[1]
            else:
                health = max_health
                
            if bandage_time == bandage[0]:
                if health + bandage[2] <= max_health:
                    health += bandage[2]
                else:
                    health = max_health
                bandage_time = 0

        time += 1
        if health <= 0:
            return -1
        
    return health