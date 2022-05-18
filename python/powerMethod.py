import numpy as np


#factors out largest element in vector
#effectively making it = 1
def normalize(x):
    fac = abs(x).max()
    x_n = x / x.max()
    return fac, x_n

def main():
    x = np.array([1, 1])
    a = np.array([[0, 2], [2, 3]])

for i in range(8):
    x = np.dot(a, x)
    lambda_1, x = normalize(x)

print('Eigenvalue:', lambda_1)
print('Eigenvector:', x)



if __name__ == "__main__"
    main()
