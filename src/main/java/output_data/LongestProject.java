package output_data;

import java.util.Objects;

public class LongestProject {
    private int id;
    private int duration;

    public LongestProject(String output){
        String[] parts = output.split(" ");
        id = Integer.parseInt(parts[0]);
        duration = Integer.parseInt(parts[1]);
    }

    @Override
    public String toString(){
        return "Id of project: " + id + "; Duration: " + duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongestProject that = (LongestProject) o;
        return id == that.id && duration == that.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration);
    }
}
