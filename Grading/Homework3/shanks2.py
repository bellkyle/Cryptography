from math import ceil, sqrt

def bsgs(g, h, p):
    '''
    Solve for x in h = g^x mod p given a prime p.
    '''
    N = ceil(sqrt(p - 1))
    N = int(N)

    # Store g^{1...m} (mod p). Baby step.
    tbl = {pow(g, i, p):i for i in range(N)}

    # Fermat's Little Theorem
    c = pow(g, N * (p - 2), p)

    # Search for an equivalence in the table. Giant step.
    for j in range(N):
        y = (h * pow(c, j, p)) % p
        if y in tbl: return j * N + tbl[y]

    # Solution not found
    return None

print(bsgs(650, 2213, 3571))
