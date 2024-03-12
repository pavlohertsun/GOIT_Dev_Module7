package output_data;

import java.util.Objects;

public class ProjectPrice {
    private int id;
    private double projectCost;
    public ProjectPrice(String output){
        String[] parts = output.split(" ");
        id = Integer.parseInt(parts[0]);
        projectCost = Double.parseDouble(parts[1]);
    }

    @Override
    public String toString(){
        return "Id of the project: " + id + "; His price: " + projectCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPrice that = (ProjectPrice) o;
        return id == that.id && Double.compare(that.projectCost, projectCost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectCost);
    }
}
