package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.domain;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "fruits")
public class Fruit {

    @Id
    private String _id;

    @Indexed(unique = true)
    @NotEmpty(message = "Name cannot be empty nor null")
    private String name;

    @NotNull(message = "Amount cannot be null")
    @Min(message = "Can't have negative amount", value = 0)
    private Integer amountKg;

    public Fruit(String name, int amountKg) {
        this.name = name;
        this.amountKg = amountKg;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountKg() {
        return amountKg;
    }

    public void setAmountKg(int amountKg) {
        this.amountKg = amountKg;
    }

}
