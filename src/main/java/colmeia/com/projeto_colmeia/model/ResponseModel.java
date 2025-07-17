package colmeia.com.projeto_colmeia.model;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel {

    private Object data;
    private List<String> messages;

    public ResponseModel(Object data, String message) {
        List<String> m = new ArrayList<String>();
        m.add(message);

        this.data = data;
        this.messages = m;
    }

    public ResponseModel(Object data, List<String> messages) {
        this.data = data;
        this.messages = messages;
    }

}
