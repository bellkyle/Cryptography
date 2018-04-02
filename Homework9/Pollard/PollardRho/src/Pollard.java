
public class Pollard {
	public Pollard(int rhoValue, int generatorValue, int aValue)
	{
		int RHO = rhoValue;
		int GENERATOR = generatorValue;
		int VALUE = aValue;
		
	}
	
	public int getNextX(int rho, int generator, int aValue, int previousX)
	{
		if((previousX >= 0) && previousX < (rho/3))
			return (previousX*generator) % rho;
		else if((previousX >= (rho/3) && (previousX < (2*rho)/3)))
			return (previousX * previousX) % rho;
		else
			return (previousX * aValue) % rho;
	}

	public int getNextAlpha(int rho, int previousAlpha, int x)
	{
		if((x >= 0) && (x < (rho/3)))
			return (previousAlpha + 1) % (rho - 1);
		else if((x >= (rho/3)) && (x < (2*rho)/3))
				return (previousAlpha * 2) % (rho - 1);
		else
			return previousAlpha;
	}
	
	public int getNextBeta(int rho, int previousBeta, int x)
	{
		if((x >= 0) && (x < (rho/3)))
			return previousBeta;
		else if((x >= (rho/3)) && (x < (2*rho)/3))
			return (previousBeta*2) % (rho - 1);
		else
			return (previousBeta + 1) % (rho - 1);
	}
	
	public int getNextY(int rho, int generator, int aValue, int previousY)
	{
		int temp = 0;

		if((previousY >= 0) && previousY < (rho/3))
			temp = (previousY*generator) % rho;
		else if((previousY >= (rho/3) && (previousY < (2*rho)/3)))
			temp = (previousY * previousY) % rho;
		else
			temp = (previousY * aValue) % rho;
		
		if((temp >= 0) && temp < (rho/3))
			return (temp*generator) % rho;
		else if((temp >= (rho/3) && (temp < (2*rho)/3)))
			return (temp * temp) % rho;
		else
			return (temp * aValue) % rho;
		
	}
	
	public int getNextGamma(int rho, int previousGamma, int x)
	{
		int temp;
		
		if((x >= 0) && (x < (rho/3)))
			temp = (previousGamma + 1) % (rho - 1);
		else if((x >= (rho/3)) && (x < (2*rho)/3))
			temp = (previousGamma * 2) % (rho - 1);
		else
			temp = previousGamma;
		
		if((x >= 0) && (x < (rho/3)))
			return (temp + 1) % (rho - 1);
		else if((x >= (rho/3)) && (x < (2*rho)/3))
			return (temp * 2) % (rho - 1);
		else
			return temp;
	}
}
