package ws.synopsis.trainingevaluisalva.repository.impl;

import org.springframework.stereotype.Repository;
import lombok.AllArgsConstructor;
import ws.synopsis.trainingevaluisalva.exception.TrainingFieldException;
import ws.synopsis.trainingevaluisalva.model.User;
import ws.synopsis.trainingevaluisalva.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<Long, User> USERS = new HashMap<Long, User>();
    private static Long id = 1L;

	@Override
	public boolean add(User user) {
		List<User> users = USERS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
		user.setIdUser(id);
		USERS.put(id++, user);
		return true;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return USERS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
	}

	@Override
	public boolean update(User user) throws TrainingFieldException {
		User userToChange = USERS.get(user.getIdUser());
		if (userToChange==null) return false;
		List<User> users = USERS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
		userToChange.setName(user.getName());
		userToChange.setLastName(user.getLastName());
		return true;
	}

	@Override
	public User getUser(Long idUser) throws TrainingFieldException{
		// TODO Auto-generated method stub
		User userToGet = USERS.get(idUser);
		if (userToGet==null) throw new TrainingFieldException("El Id ingresado no existe en la BD");
		return USERS.get(idUser);
	}

	@Override
	public boolean remove(Long idUser) {
		// TODO Auto-generated method stub
		User userToDelete = USERS.get(idUser);
		if(userToDelete==null) return false;
		USERS.remove(idUser);
		return true;
	}
}
