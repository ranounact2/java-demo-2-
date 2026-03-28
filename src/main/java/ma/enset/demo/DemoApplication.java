package ma.enset.demo;

import ma.enset.demo.entities.Product;
import ma.enset.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List; // Importation ajoutée

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Ajout du point-virgule manquant et correction des noms si nécessaire
       // productRepository.save(new Product(null, "Computer", 4300, 3));
       // productRepository.save(new Product(null, "Printer", 4300, 3));
       // productRepository.save(new Product(null, "Smart Phone", 4300, 3)); // Point-virgule ajouté ici

        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString()); // println en minuscule
        });

        // valueOf avec un V majuscule
        Product product = productRepository.findById(1L).orElse(null);

        if (product != null) {
            System.out.println("********");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getQuantity());
            System.out.println("********");
            System.out.println("-----------------------");

            List<Product> productList = productRepository.findByNameContains("C");
            productList.forEach(p->{
                System.out.println(p);
            });


            System.out.println("-------------------");
            List<Product> productList2= productRepository.search ("%C%");
            productList.forEach(p->{
                System.out.println(p);
            });
            System.out.println("-------------------");
            List<Product> productList3= productRepository.searchByPrice(3000);
            productList.forEach(p->{
                System.out.println(p);
            });



        }
    }
}