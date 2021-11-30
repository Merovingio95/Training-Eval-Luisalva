package ws.synopsis.trainingevaluisalva.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.trainingevaluisalva.bean.request.UserRequest;
import ws.synopsis.trainingevaluisalva.exception.TrainingFieldException;
import ws.synopsis.trainingevaluisalva.model.User;
import ws.synopsis.trainingevaluisalva.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody UserRequest beanReq) throws TrainingFieldException {

        if(StringUtils.isBlank(beanReq.getName())) {
            throw new TrainingFieldException("Nombre no puede estar vac\u00EDo.");
        }

        if(StringUtils.isBlank(beanReq.getLastName())) {
            throw new TrainingFieldException("Apellido no puede estar vac\u00EDo.");
        }

        userService.add(beanReq);
        return ResponseEntity.ok().build();
    }

}