
result = {}
with open('/home/kumar-sanchay/interview.csv', 'r') as f:

    line = f.readline()
    val_list = line.split(',')
    result[val_list[3]] = val_list[-1]

print(result)