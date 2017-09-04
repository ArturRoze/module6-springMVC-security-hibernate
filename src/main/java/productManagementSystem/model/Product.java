package productManagementSystem.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private BigDecimal cost;
    @Column
    private String description;
    @Column
    private String vendor;

    public Product() {
    }

    public Product(String name, BigDecimal cost, String description, String vendor) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.vendor = vendor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        if (!cost.equals(product.cost)) return false;
        if (!description.equals(product.description)) return false;
        return vendor == product.vendor;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + cost.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + vendor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", vendor=" + vendor +
                '}';
    }
}
