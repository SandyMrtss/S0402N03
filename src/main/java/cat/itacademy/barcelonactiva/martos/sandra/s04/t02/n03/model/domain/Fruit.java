package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude
@Data
@Document(collection = "fruits")
public class Fruit {
    //TODO manage validation, always throws internal server error
    @Id
    private long id;

    //@NotEmpty(message = "Name cannot be empty nor null")
    @JsonProperty
    private String name;

    //@NotNull(message = "Amount cannot be null")
    //@Min(message = "Can't have negative amount", value = 0)
    @JsonProperty
    private int amountKg;

    public Fruit(){

    }

    public Fruit(long id, String name, int amountKg) {
        this.id = id;
        this.name = name;
        this.amountKg = amountKg;
    }

    public Fruit(String name, int amountKg) {
        this.name = name;
        this.amountKg = amountKg;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountKg() {
        return amountKg;
    }

    public void setAmountKg(int amountKg) {
        this.amountKg = amountKg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountKg=" + amountKg +
                '}';
    }
}
