package ws.synopsis.trainingevaluisalva.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.trainingevaluisalva.bean.request.UserRequest;
import ws.synopsis.trainingevaluisalva.model.User;
import ws.synopsis.trainingevaluisalva.repository.UserRepository;
import ws.synopsis.trainingevaluisalva.service.UserService;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.list();
    }

    @Override
    public void add(UserRequest beanReq) {
        userRepository.add(
        		User.builder().name(beanReq.getName()).lastName(beanReq.getLastName()).build()
        );
    }

}
