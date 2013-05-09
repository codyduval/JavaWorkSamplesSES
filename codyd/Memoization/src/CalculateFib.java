
public class CalculateFib {

		public int calculateFibonannci (int n) {
			if ((n == 0) ||  (n == 1)) {
				return n;
			}
			else {
				return calculateFibonannci(n-1) + calculateFibonannci(n-2);
			}
		}
}





