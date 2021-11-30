package ws.synopsis.trainingevaluisalva.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.trainingevaluisalva.bean.request.UserRequest;
import ws.synopsis.trainingevaluisalva.model.User;
import ws.synopsis.trainingevaluisalva.exception.TrainingFieldException;
import ws.synopsis.trainingevaluisalva.repository.UserRepository;
import ws.synopsis.trainingevaluisalva.service.UserService;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
	public boolean add(UserRequest userReq) {
		return this.userRepository.add(User.builder().name(userReq.getName()).lastName(userReq.getLastName()).build());
	}
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userRepository.list();
	}
	@Override
	public boolean update(UserRequest userReq,String idUser) throws TrainingFieldException {
		return userRepository.update(User.builder().idUser(Long.parseLong(idUser)).name(userReq.getName()).lastName(userReq.getLastName()).build());
		
	}
	@Override
	public User getUser(String idUser) throws TrainingFieldException {
		// TODO Auto-generated method stub
		return userRepository.getUser(Long.parseLong(idUser));
	}
	@Override
	public boolean remove(String idUser) {
		// TODO Auto-generated method stub
		return this.userRepository.remove(Long.parseLong(idUser));
	}

}
