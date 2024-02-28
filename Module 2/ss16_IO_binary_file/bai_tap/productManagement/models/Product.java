package ss16_IO_binary_file.bai_tap.productManagement.models;

import java.io.Serializable;

public class Product implements Serializable {
    private static final Long serialVersionUID = -98438L;
    private String code;
    private String name;
    private Long price;
    private String typeOfGoods;
    private String description;

    public Product() {
    }

    public Product(String code, String name, Long price, String typeOfGoods, String description) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.typeOfGoods = typeOfGoods;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTypeOfGoods() {
        return typeOfGoods;
    }

    public void setTypeOfGoods(String typeOfGoods) {
        this.typeOfGoods = typeOfGoods;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", typeOfGoods='" + typeOfGoods + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
