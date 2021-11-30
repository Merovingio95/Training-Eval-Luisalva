package ws.synopsis.trainingevaluisalva.repository.impl;

import org.springframework.stereotype.Repository;
import ws.synopsis.trainingevaluisalva.model.User;
import ws.synopsis.trainingevaluisalva.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<Long, User> USERS;

    static {
    	USERS = new HashMap<Long, User>();
    	USERS.put(1L, User.builder().idUser(1L).name("Elvis").lastName("Perez").build());
    	USERS.put(2L, User.builder().idUser(2L).name("Jhonatan").lastName("Evan\u00E0n").build());
    	USERS.put(3L, User.builder().idUser(3L).name("Arturo").lastName("Nu\u00F1ez").build());
    	USERS.put(4L, User.builder().idUser(4L).name("Luis").lastName("Quinto").build());
    }

    @Override
    public List<User> list() {
        return USERS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
    }

    @Override
    public void add(User user) {
        long id = (long) USERS.size();
        user.setIdUser(id);
        USERS.put(id, user);
    }
}
