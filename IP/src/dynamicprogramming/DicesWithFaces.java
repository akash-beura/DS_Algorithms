package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class DicesWithFaces {

	int[][] dp;

	public int solve(int dices, int faces, int sum) {
		if (dices == 0 || faces == 0 || sum == 0) {
			return 0;
		}
		int result = 0;
		for (int i = faces; i >= 1; i--) {
			int temp = result;
			if (i <= sum) {
				temp = 1 + solve(dices - 1, faces, sum - i) + solve(dices - 1, faces, sum);
			} else {
				continue;
			}
			result += temp;
		}
		new TreeSet<>().descendingSet();
		return result;
	}

	public int numRollsToTarget(int d, int f, int target) {
		dp = new int[d + 1][target + 1];
		return solve(d, f, target);
	}

	public static void main(String[] args) {
//		System.out.println(new DicesWithFaces().numRollsToTarget(1, 6, 3));

		System.out.println(" ".trim());
	}
}

class Vertex {
	
	int discoveryNumber;
	int vertexNumber;
	int destination;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destination;
		result = prime * result + vertexNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (destination != other.destination)
			return false;
		if (vertexNumber != other.vertexNumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vertex [discoveryNumber=" + discoveryNumber + ", vertexNumber=" + vertexNumber + ", destination="
				+ destination + "]";
	}
	
	
	
	
	
	
	

}
