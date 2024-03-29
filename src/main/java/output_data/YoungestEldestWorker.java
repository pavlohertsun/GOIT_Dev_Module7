package output_data;

import java.time.LocalDate;
import java.util.Objects;

public class YoungestEldestWorker {
    private String type;
    private String name;
    private LocalDate birthday;

    public YoungestEldestWorker(String output){
        String[] parts = output.split(" ");
        type = parts[0];
        name = parts[1];
        birthday = LocalDate.parse(parts[2]);
    }
    @Override
    public String toString(){
        return type + ": name of the worker - " + name + "; His birthday: " + birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YoungestEldestWorker worker = (YoungestEldestWorker) o;
        return Objects.equals(type, worker.type) && Objects.equals(name, worker.name) && Objects.equals(birthday, worker.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, birthday);
    }
}
