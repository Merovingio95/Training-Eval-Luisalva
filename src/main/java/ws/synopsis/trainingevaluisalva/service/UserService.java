package ws.synopsis.trainingevaluisalva.service;

import ws.synopsis.trainingevaluisalva.bean.request.UserRequest;
import ws.synopsis.trainingevaluisalva.exception.TrainingFieldException;
import ws.synopsis.trainingevaluisalva.model.User;

import java.util.List;

public interface UserService {
	boolean add(UserRequest userReq);
	boolean update(UserRequest userReq, String idUser) throws TrainingFieldException;
	User getUser(String idUser) throws TrainingFieldException;
	boolean remove(String idUser);
	List<User> list();
}
