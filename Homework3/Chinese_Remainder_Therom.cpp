#include <iostream>
#include <algorithm>
#include <vector>
#include <ctime>
#include <map>
#include <set>
    using std::set;
    using std::map;
    using std::vector;
    using std::cout;
    using std::cin;
int remainder(vector<int> n, vector<int>a, int);
int inv(int a, int b);
int main()
{
     int temp[30];
    srand(time(NULL));
    vector<int> m = {3,5,7};
  // vector<int> m;
   
  /* 
    for(int i = 0; i < 30; i++)
    {
        temp[i] = rand()%10+1;
    }
    for(int i = 0; i < 30; i++)
    {
        if(temp[i] % 2 == 1&&(temp[i]!= 1)&&m.size()<3)
        {
          cout << temp[i] <<"\n";
            m.push_back(temp[i]);
        }
    }
 */ 
    cout <<"divisors list: ";
    for(int i = 0; i< m.size(); i++)
    {
        cout << m[i] << " ";
    }
  vector<int>a;
 //  vector<int>a = {2,3,2};
  
   for(int i = 0; i < 30; i++)
    {
        temp[i] = rand()%10+1;
    }
   for(int i = 0; i < m.size();i++)
   { 
      
      a.push_back(temp[i]);
   }
  
   cout << "\nremainder list: ";

   for(int i = 0; i <a.size(); i++)
    {
       cout << a[i] << " ";
    }
 
  cout <<  "\nx is: " << remainder(m, a, a.size()); 
   
    
    return 0;
}
int remainder(vector<int> n, vector<int>a, int len)
{
    int result = 0;
    int p, i, prod = 1,sum =0;
    for(i = 0; i < len; i++)
    {
        prod *= n[i];
    }
    for(i = 0; i < len; i++)
    {
        p = prod/n[i];
        sum  += a[i] * inv(p, n[i]) * p;
    }
    result = sum% prod;
    return result;
    
}
int inv(int a, int b)
{
    int b0 = b, t, q;
    int x0 = 0, x1 = 1;
    if(b == 1)
    {
        return 1;
    }
    while(a > 1)
    {
        q = a/b;
        t = b,
        b = a%b,
        a = t;
        t = x0, x0 = x1-q*x0,x1 = t;
    }
    if(x1 <0)
    {
        x1 += b0;
    }
    
    return x1;
}