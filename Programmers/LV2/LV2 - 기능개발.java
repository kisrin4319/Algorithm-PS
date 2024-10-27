import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		int[] times = new int[progresses.length];
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			times[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
		}

		int completedWorkIndex = 0;

		while (completedWorkIndex < times.length) {
			int currentDays = times[completedWorkIndex];
			int count = 0;

			// 현재 작업과 함께 배포할 수 있는 작업 수 계산
			while (completedWorkIndex < times.length && times[completedWorkIndex] <= currentDays) {
				completedWorkIndex++;
				count++;
			}

			result.add(count);
		}
		return result.stream().mapToInt(i->i).toArray();
    }
}
