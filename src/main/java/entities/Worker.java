package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Worker {
    private String name;
    private LocalDate birthday;
    private String level;
    private double salary;

    public Worker(String name, LocalDate birthday, String level, double salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getLevel() {
        return level;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Double.compare(worker.salary, salary) == 0 && Objects.equals(name, worker.name) && Objects.equals(birthday, worker.birthday) && Objects.equals(level, worker.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, level, salary);
    }
}
