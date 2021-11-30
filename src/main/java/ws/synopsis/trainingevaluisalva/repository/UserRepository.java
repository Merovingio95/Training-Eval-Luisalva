package ws.synopsis.trainingevaluisalva.repository;

import ws.synopsis.trainingevaluisalva.model.User;

import java.util.List;

public interface UserRepository {
    public List<User> list();
    public void add(User user);
}

