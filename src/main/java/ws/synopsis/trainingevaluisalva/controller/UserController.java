package ws.synopsis.trainingevaluisalva.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return this.userService.list();
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
    @PutMapping("/{idUser}")
	public ResponseEntity<?> update(@PathVariable("idUser") String idUser, @RequestBody UserRequest userReq) throws TrainingFieldException{
		if(userReq.getLastName().equals("")) {
			throw new TrainingFieldException("Los apellidos no pueden estar vac\\u00EDos");
		}
		
		if(userReq.getName().equals("")) {
			throw new TrainingFieldException("Los nombres no pueden estar vac\\u00EDos");
		}
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{idUser}")
	public User getUser(@PathVariable("idUser") String idUser) throws TrainingFieldException {
		return this.userService.getUser(idUser);
	}
	
	@DeleteMapping("/{idUser}")
	public ResponseEntity<?> remove(@PathVariable("idUser") String idUser) throws TrainingFieldException{
		if(!userService.remove(idUser)) {
			throw new TrainingFieldException("El ID de usuario no existe");
		}
		return ResponseEntity.ok().build();
	}

}