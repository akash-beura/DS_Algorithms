package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class Zombie {

	int i;
	int j;

	public Zombie() {
	}

	public Zombie(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}

public class ZombieMatrix {

	public static int zombifyHuman(List<List<Integer>> grid) {
		Queue<Zombie> zombies = new LinkedList<Zombie>();
		HashSet<String> freshPeople = new HashSet<>();
		int minutes = 0;

		for (int i = 0; i < grid.size(); i++) {

			for (int j = 0; j < grid.get(i).size(); j++) {
				if (grid.get(i).get(j) == 2) {
					zombies.add(new Zombie(i, j));
				} else if (grid.get(i).get(j) == 1) {
					freshPeople.add("" + i + j);
				}
			}
		}

		// down,
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		// Loop through all the fresh people
		while (freshPeople.size() != 0) {
			// take a temp infected people list to keep track in each turn if any person
			// gets infected
			Queue<Zombie> infected = new LinkedList<>();
			// loop through all existing zombies
			for (Zombie zombie : zombies) {
				for (int[] direction : directions) {
					// we;re using the direction array to check if any person there at top, bottom,
					// left, right
					int nextI = direction[0] + zombie.i;
					int nextJ = direction[1] + zombie.j;
					// if any fresh people found, remove him from list, and update the nre infected
					// position.
					if (freshPeople.contains("" + nextI + nextJ)) {
						freshPeople.remove("" + nextI + nextJ);
						infected.add(new Zombie(nextI, nextJ));
					}
				}
			}
			// if the new infected position is 0 that means we're unable to zombify and new
			// person even though a person is present. Hence, return -1.
			if (infected.size() == 0) {
				return -1;
			}
			// update the zombies with new infected locations.
			zombies = infected;
			// incrementing the minute.
			minutes++;
		}
		return minutes;
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(2, 1, 1);

		List<Integer> l2 = Arrays.asList(0, 1, 1);

		List<Integer> l3 = Arrays.asList(1, 0, 1);

		List<List<Integer>> finalList = Arrays.asList(l1, l2, l3);
		
		System.out.println("moneypot".compareTo("moneypot"));
		TreeSet<Object> s1 = new TreeSet<>();
	}

}
