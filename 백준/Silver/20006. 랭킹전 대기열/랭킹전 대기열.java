
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Player implements Comparable<Player>{
		int level;
		String nickname;
		
		public Player(int level, String nickname) {
			this.level = level;
			this.nickname = nickname;
		}

		
		@Override
		public String toString() {
			return "Player [level=" + level + ", nickname=" + nickname + "]";
		}

		@Override
		public int compareTo(Player o) {
			return this.nickname.compareTo(o.nickname);
		}
		
	}

	static class Room {
		int no;
		int cur;
		int level;
		ArrayList<Player> in = new ArrayList<>();
		boolean start = false;

		public Room() {

		}

		public Room(int no, int cur, int level) {
			super();
			this.no = no;
			this.cur = cur;
			this.level = level;
		}

		@Override
		public String toString() {
			return "Room [no=" + no + ", cur=" + cur + ", level=" + level + "]";
		}

		public void order() {
			Collections.sort(in);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); // 플레이어
		int m = Integer.parseInt(st.nextToken()); // 방의정원

		ArrayList<Room> list = new ArrayList<>();
		int cnt = 0;

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();

			boolean flag = false; // 방 찾았나 체크
			for (Room room : list) {
				if (room.cur < m && (level <= room.level + 10 && level >= room.level - 10)) {
					flag = true;
					room.cur++;
					room.in.add(new Player(level, nickname));

					if (room.cur == m)
						room.start = true;
					break;
				}
			}
			
			if (!flag) {
				list.add(new Room(++cnt, 1, level));
				list.get(cnt - 1).in.add(new Player(level, nickname));
			}

		}
		
		
		for (Room room: list) {
			if (room.start || m == 1) sb.append("Started!\n");
			else sb.append("Waiting!\n");
			
			room.order();
			
			for (Player player : room.in) {
				sb.append(player.level).append(" ").append(player.nickname).append("\n");
			}
			
			
		}
		
		System.out.println(sb);

	}

}