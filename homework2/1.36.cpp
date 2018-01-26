/**
 * cryptography
 *
 * problem 1.36
 *
 *@Author: ying.fan
 *@Date :1/25/2018
 */

#include <iostream>
#include <cmath>
    using std::cout;
    using std::cin;
int function(int ); 
int main()
{
    int p = 0;
  
  /*  //promot the user 
    cout << "Enter the value p: \n";
    cin >> p;
    int result = 0;
    result = pow(2, (p-1)/2);
    result %=7;
   
    cout << "The result is: " << result << "\n";
  */
    int prime = 3;
    for(int i = 3; i <= 20; i++)
    {
        if( i % 2 == 1 )
        {
            cout << "The value of prime number " << i
            << " is: " << function(i) << "\n";
        }
    }
    return 0;
}
int function(int x)
{
  int  result = pow(2, (x-1)/2);
       result %= 7;
  return result; 
}
