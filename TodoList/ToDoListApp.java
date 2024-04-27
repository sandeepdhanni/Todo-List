package task1;
	import java.util.ArrayList;
	import java.util.Scanner;

	public class ToDoListApp {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        TaskManager taskManager = new TaskManager();

	        int choice;
	        do {
	            System.out.println("1. Add your Task");
	            System.out.println("2. Edit your Task");
	            System.out.println("3. Delete Task");
	            System.out.println("4. View Tasks");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter your task description: ");
	                    String description = scanner.nextLine();
	                    taskManager.addTask(description);
	                    break;
	                case 2:
	                    System.out.print("Enter task ID to edit: ");
	                    int editId = scanner.nextInt();
	                    scanner.nextLine(); 
	                    System.out.print("Enter new description: ");
	                    String newDescription = scanner.nextLine();
	                    taskManager.editTask(editId, newDescription);
	                    break;
	                case 3:
	                    System.out.print("Enter task ID to delete: ");
	                    int deleteId = scanner.nextInt();
	                    taskManager.deleteTask(deleteId);
	                    break;
	                case 4:
	                    taskManager.viewTasks();
	                    break;
	                case 0:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!!!!");
	            }
	        } while (choice != 0);
	    }
	}

	class Task {
	    private int id;
	    private String description;

	    public Task(int id, String description) {
	        this.id = id;
	        this.description = description;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }
	}

	class TaskManager {
	    private ArrayList<Task> tasks = new ArrayList<>();
	    private int taskIdCounter = 1;

	    public void addTask(String description) {
	        tasks.add(new Task(taskIdCounter++, description));
	        System.out.println("Task added successfully.");
	    }

	    public void editTask(int id, String newDescription) {
	        boolean found = false;
	        for (Task task : tasks) {
	            if (task.getId() == id) {
	                task.setDescription(newDescription);
	                found = true;
	                System.out.println("Task updated successfully.");
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Task not found!");
	        }
	    }

	    public void deleteTask(int id) {
	        boolean removed = tasks.removeIf(task -> task.getId() == id);
	        if (removed) {
	            System.out.println("Task deleted successfully.");
	        } else {
	            System.out.println("Task not found!");
	        }
	    }

	    public void viewTasks() {
	        if (tasks.isEmpty()) {
	            System.out.println("No tasks to display.");
	        } else {
	            System.out.println("Tasks:");
	            for (Task task : tasks) {
	                System.out.println(task.getId() + ". " + task.getDescription());
	            }
	        }
	    }
	}


