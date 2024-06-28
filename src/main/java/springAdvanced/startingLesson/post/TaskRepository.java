package springAdvanced.startingLesson.post;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final String TASKS_SELECT_QUERY = "select * from tasks";

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> getAll() {
        return jdbcTemplate.query(TASKS_SELECT_QUERY, BeanPropertyRowMapper.newInstance(Task.class));

    }
}
