class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class TaskList {
    Task head = null;

    // Time Complexity: O(1)
    public void addTask(Task t) {
        t.next = head;
        head = t;
    }

    // Time Complexity: O(n)
    public Task search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Time Complexity: O(n)
    public void delete(int id) {
        if (head != null && head.taskId == id) {
            head = head.next;
            return;
        }
        Task prev = head;
        Task curr = head.next;
        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
