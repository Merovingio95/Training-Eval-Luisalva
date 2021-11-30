package ws.synopsis.trainingevaluisalva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long idUser;
    private String name;
    private String lastName;
	
   
    
}
