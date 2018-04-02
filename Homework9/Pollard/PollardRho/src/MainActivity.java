
public class MainActivity {

	public static void main(String[] args) {
		int rho = 48611;
		int generator = 19;
		int aValue = 24717;
		int x = 1;
		int y = 1;
		int alpha = 0;
		int beta = 0;
		int gamma = 0;
		Pollard test = new Pollard(rho, generator, aValue);
		System.out.println("i: 0   x: " + x + "   y: " + y + "   alpha: " + alpha + "   beta: " + beta + "   gamma: " + gamma);
		for(int i = 1; i < 549; i++)
		{
			int tempX = x;
			int tempY = y;
			int tempAlpha = alpha;
			int tempBeta = beta;
			int tempGamma = gamma;
			x = test.getNextX(rho, generator, aValue, tempX);
			y = test.getNextY(rho, generator, aValue, tempY);
			alpha = test.getNextAlpha(rho, tempAlpha, tempX);
			beta = test.getNextBeta(rho, tempBeta, tempX);
			gamma = test.getNextGamma(rho, tempGamma, tempY);
			
			System.out.println("i: " + i + "   x: " + x + "   y: " + y + "   alpha: " + alpha + "   beta: " + beta + "   gamma: " + gamma);
		}

	}

}
