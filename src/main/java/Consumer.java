import java.util.*;

public class Consumer {
  Map<Integer, Deque<String>> tasks = new HashMap<>();
  LinkedList<Integer> priorities = new LinkedList<>();

  private void addPriority (int priority) {
    this.priorities.add(priority);
    Collections.sort(priorities);
    Collections.reverse(priorities);
  }

  public void addTask (String task, int priority) {
    if (!this.priorities.contains(priority)) {
      addPriority(priority);
    }
    if (this.tasks.containsKey(priority)) {
      Deque<String> tasksByPriority = this.tasks.get(priority);
      tasksByPriority.add(task);
      this.tasks.put(priority, tasksByPriority);
    } else {
      if (!this.priorities.contains(priority)) {
        throw new IllegalArgumentException("Кривой приоритет");
      }
      Deque<String> tasksByPriority = new LinkedList<>();
      tasksByPriority.add(task);
      this.tasks.put(priority, tasksByPriority);
    }
  }


  public String getTask () {
    for (int currentPriority : this.priorities) {
      if (this.tasks.containsKey(currentPriority) && !this.tasks.get(currentPriority).isEmpty()) {
        return this.tasks.get(currentPriority).pollFirst();
      }
    }
    return null;
  }
}


// 2 метода: addTask, getTask
// add - 1 параметр задача (стринг), 2 параметр - важность
// get - вернуть задачу, добавленную раньше других, но не забыть про важность

// addPriority - добавить. Положительный int. Больше приоритет -> важнее задача
// добавить TestNG, собрать maven
// написать тесты для консьюмера