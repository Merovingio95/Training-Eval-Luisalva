package ws.synopsis.trainingevaluisalva.repository;

import ws.synopsis.trainingevaluisalva.model.User;
import ws.synopsis.trainingevaluisalva.exception.TrainingFieldException;

import java.util.List;

public interface UserRepository {
	boolean add(User user);
	boolean update(User user) throws TrainingFieldException;
	boolean remove(Long idUser);
	User getUser(Long idUser) throws TrainingFieldException;
	public List<User> list();

}

