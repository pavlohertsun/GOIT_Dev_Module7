package constants;

public class SQLInsertConstants {
    public static final String INSERT_WORKER = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?);";
    public static final String INSERT_CLIENT = "INSERT INTO client (name) VALUES (?);";
    public static final String INSERT_PROJECT = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?);";
    public static final String INSERT_PROJECT_WORKER = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?);";
}
