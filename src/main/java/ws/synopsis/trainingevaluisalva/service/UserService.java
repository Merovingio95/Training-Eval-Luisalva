package ws.synopsis.trainingevaluisalva.service;

import ws.synopsis.trainingevaluisalva.bean.request.UserRequest;
import ws.synopsis.trainingevaluisalva.model.User;

import java.util.List;

public interface UserService {
    public List<User> list();
    public void add(UserRequest beanReq);
}
