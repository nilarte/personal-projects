n=819
rev=0
while(n>0):
    dig=n%10 #remainder
    rev=rev*10+dig
    n=n//10
print("Reverse of the number:",rev)
