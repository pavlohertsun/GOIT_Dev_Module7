package entities;

import java.util.Objects;

public class ProjectWorker {
    private int projectId;
    private int workerId;

    public ProjectWorker(int projectId, int workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getWorkerId() {
        return workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectWorker that = (ProjectWorker) o;
        return projectId == that.projectId && workerId == that.workerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, workerId);
    }
}
