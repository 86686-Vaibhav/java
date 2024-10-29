import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Project implements Serializable {
    private int id;
    private String title;
    private int teamSize;
    private double projectCost;
    private String technology;

    public Project(int id, String title, int teamSize, double projectCost, String technology) {
        this.id = id;
        this.title = title;
        this.teamSize = teamSize;
        this.projectCost = projectCost;
        this.technology = technology;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public String getTechnology() {
        return technology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", teamSize=" + teamSize +
                ", projectCost=" + projectCost +
                ", technology='" + technology + '\'' +
                '}';
    }
}

public class Assignment_8 {
    private static final String FILE_NAME = "projects.dat";
    private HashSet<Project> projectSet = new HashSet<>();

    public static void main(String[] args) {
        Assignment_8 manager = new Assignment_8();
        manager.loadProjectsFromFile();
        manager.run();
        manager.saveProjectsToFile();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Project Management ---");
            System.out.println("1. Add Default Projects");
            System.out.println("2. Add Project from User");
            System.out.println("3. Display All Projects");
            System.out.println("4. Delete Project by ID");
            System.out.println("5. Copy Projects to ArrayList");
            System.out.println("6. Display Projects in ArrayList");
            System.out.println("7. Sort Projects by Cost in List");
            System.out.println("8. Find Project with Max Team Size");
            System.out.println("9. Count Java Projects");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addDefaultProjects();
                    break;
                case 2:
                    addProjectFromUser(scanner);
                    break;
                case 3:
                    displayProjects(projectSet);
                    break;
                case 4:
                    deleteProjectById(scanner);
                    break;
                case 5:
                    copyProjectsToArrayList();
                    break;
                case 6:
                    displayProjects(new ArrayList<>(projectSet));
                    break;
                case 7:
                    sortProjectsByCost();
                    break;
                case 8:
                    findProjectWithMaxTeamSize();
                    break;
                case 9:
                    countJavaProjects();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
        } while (choice != 0);
    }

    private void addDefaultProjects() {
        projectSet.add(new Project(1, "Student Management Section", 5, 5000000, "Java"));
        projectSet.add(new Project(2, "Education Management System", 3, 6000000, "Python"));
        projectSet.add(new Project(4, "Online Reservation System", 6, 3000000, "Java"));
        projectSet.add(new Project(5, "Handwritten Digit Recognition System", 2, 3000000, "Machine Learning"));
        projectSet.add(new Project(3, "Online Jewelry Shop", 4, 4000000, "Java"));
        projectSet.add(new Project(2, "Bus Reservation System", 3, 3500000, "JS")); 
        System.out.println("Default projects added.");
    }

    private void addProjectFromUser(Scanner scanner) {
        System.out.print("Enter project ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Enter project title: ");
        String title = scanner.nextLine();
        System.out.print("Enter team size: ");
        int teamSize = scanner.nextInt();
        System.out.print("Enter project cost: ");
        double projectCost = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter technology: ");
        String technology = scanner.nextLine();

        Project project = new Project(id, title, teamSize, projectCost, technology);
        if (projectSet.add(project)) {
            System.out.println("Project added.");
        } else {
            System.out.println("Project with this ID already exists.");
        }
    }

    private void displayProjects(Collection<Project> projects) {
        if (projects.isEmpty()) {
            System.out.println("No projects to display.");
        } else {
            projects.forEach(System.out::println);
        }
    }

    private void deleteProjectById(Scanner scanner) {
        System.out.print("Enter project ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = projectSet.removeIf(project -> project.getId() == id);
        System.out.println(removed ? "Project deleted." : "Project not found.");
    }

    private void copyProjectsToArrayList() {
        ArrayList<Project> projectList = new ArrayList<>(projectSet);
        System.out.println("Projects copied to ArrayList.");
    }

    private void sortProjectsByCost() {
        ArrayList<Project> projectList = new ArrayList<>(projectSet);
        projectList.sort(Comparator.comparingDouble(Project::getProjectCost));
        System.out.println("Projects sorted by cost:");
        displayProjects(projectList);
    }

    private void findProjectWithMaxTeamSize() {
        Project maxTeamSizeProject = Collections.max(projectSet, Comparator.comparingInt(Project::getTeamSize));
        System.out.println("Project with max team size: " + maxTeamSizeProject);
    }

    private void countJavaProjects() {
        long count = projectSet.stream()
                .filter(project -> "Java".equalsIgnoreCase(project.getTechnology()))
                .count();
        System.out.println("Number of Java projects: " + count);
    }

    private void loadProjectsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            projectSet = (HashSet<Project>) ois.readObject();
            System.out.println("Projects loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved projects found or error loading projects.");
        }
    }

    private void saveProjectsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(projectSet);
            System.out.println("Projects saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving projects.");
        }
    }
}