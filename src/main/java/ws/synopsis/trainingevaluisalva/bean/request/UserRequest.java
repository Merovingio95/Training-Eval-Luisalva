package ws.synopsis.trainingevaluisalva.bean.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserRequest {
    private String name;
    private String lastName;
}

