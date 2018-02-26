#include <iostream>
    using std::cout;
    using std::cin;

const long long N = 1889570071;
const long long e1 = 1021763679;
const long long e2 = 519424709;
const long long c1 = 1244183534;
const long long c2 = 732959706;

long long EGCD(long long , long long, long long &, long long &);
long long FastModularExponentialtion(long long, long long);


int main()
{
    long long m, x, y;
    EGCD(e1,e2,x,y);
   // cout << "x =" << x << "\n"
    //     << "y = " << y << "\n";
        long long x2 = 0;
        long long y2  = y;
       long long   C2 =  EGCD(c2,N,x2,y2);  
    //   cout << "x2: " << x2 << "\n";
    m =  FastModularExponentialtion(c1, x ) * FastModularExponentialtion(x2+ N, y) % N; //x2 is less than zero
    cout << "m = " << m << "\n";
    
    return 0;
}
long long EGCD(long long a, long long b, long long & x, long long &y)
{
    long long result , t;
    if(b == 0)
    {
        x = 1;
        y = 0;
        return a;
    }
    result = EGCD(b, a%b , x,y);
    t = x;
    x = y;
    y = t - ( a / b ) * y;
    return result;
}




long long FastModularExponentialtion(long long a, long long b)
{
 //   cout << "a: " << a << " b : " << b << "\n";
    long long result = 1;
    a %= N;
    while (b)
    {
        if(b  & 1)
        {
            result =  (result *a)%N;
        }
            a = (a*a) % N;
            b /= 2;
        
    }
  //  cout << "result : "<< result << "\n";
    return result;
}