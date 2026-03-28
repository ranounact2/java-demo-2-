package ma.enset.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.BatchSize;

@Entity

@Data   @NoArgsConstructor @AllArgsConstructor @Builder @Getter @Setter @ToString

public class Product {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;

}
