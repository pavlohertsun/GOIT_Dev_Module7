package output_data;

import java.util.Objects;

public class MaxProjectsClient {
    private String name;
    private int projectsCount;

    public MaxProjectsClient(String output){
        String[] parts = output.split(" ");
        name = parts[0];
        projectsCount = Integer.parseInt(parts[1]);
    }

    @Override
    public String toString(){
        return "Name of the client: " + name + "; His project count: " + projectsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxProjectsClient that = (MaxProjectsClient) o;
        return projectsCount == that.projectsCount && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectsCount);
    }
}
