
def max_seats(num_rows, S):

    if not S:
        return num_rows*2

    S = S.split(" ")

    # BCDE
    # DEFG
    # FGHJ
    max_seats = 0

    for idx in range(1, num_rows+1):

        l1 = [f"{idx}B", f"{idx}C", f"{idx}D", f"{idx}E"]
        l2 = [f"{idx}F", f"{idx}G", f"{idx}H", f"{idx}J"]

        result1 = any(ele in S for ele in l1)
        result2 = any(ele in S for ele in l2)

        if not result1 and not result2:
            max_seats+=2
            continue

        if not result1:
            max_seats+=1
            continue

        if not result1:
            max_seats+=1
            continue
        

        l1 = [f"{idx}D", f"{idx}E", f"{idx}F", f"{idx}G"]
        
        result = any(ele in S for ele in l1)

        if not result:
            max_seats+=1
            continue
    
    return max_seats


print(max_seats(2, ''))

