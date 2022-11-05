import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.file.FileSystemException;
import java.util.Random;

public class Product {
    private static int Identifier = 0;

    private int Id;
    private String Name;

    private float Price;
    private float X; //mm

    private float Y; //mm

    private float Z; //mm

    private float Weight; //kg
    public void setId() {
        Id = Identifier++;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setPrice(float price) {
        Price = price;
    }
    public void setDimValues(float x, float y, float z){
        if(x >= 0 && y >= 0 && z >= 0){
            X = x;
            Y = y;
            Z = z;
        }
    }
    public void setWeight(float weight){
        Weight = (weight < 0 || weight > 500) ? 0 : weight;
    }

    public Product() {
        this.setId();
        this.setName("Product");
        this.setPrice(0);
        this.setDimValues(0,0,0);
        this.setWeight(0);
    }
    public Product(float price, float x,float y, float z, float weight){
        this.setId();
        this.setName("Product "+Id);
        this.setPrice(price);
        this.setDimValues(x,y,z);
        this.setWeight(weight);
    }
    public Product(String name, float price, float x,float y, float z, float weight){
        this.setId();
        this.setName(name);
        this.setPrice(price);
        this.setDimValues(x,y,z);
        this.setWeight(weight);
    }


    public static void main(String[] args) {
//        Product productTest = new Product();
//        productTest.setDimValues(20,-2,4);
//        productTest.setWeight(200);
//        System.out.println(productTest.toString());
//
//
//        Product newConstructorTest = new Product("test",20,2,2,2,50);
//        System.out.println(newConstructorTest.toString());

        CreateRandomSet(10);
    }

    public static void SaveToFile(Product productToSave){

        try{
            FileWriter writer =  new FileWriter(productToSave.Name.replace(" ", "")+ "_"+ productToSave.Id +".txt");
            //might need to change saving to "this.name + /n" etc
            writer.write(productToSave.getInfoToSave());
            writer.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getInfoToSave() {
        return "   Name = '" + Name + '\'' + ",\n" +
                "   Price = " + Price + ",\n" +
                "   X = " + X + ",\n" +
                "   Y = " + Y + ",\n" +
                "   Z = " + Z + ",\n" +
                "   Weight = " + Weight + "\n";
    }

    public static void CreateRandomSet(int length){
        Random random = new Random();
        for(int i=0;i<10;i++){
            Product product = new Product(random.nextFloat(1000),random.nextFloat(1000),random.nextFloat(1000),random.nextFloat(1000), random.nextFloat(1000));
            SaveToFile(product);
        }
    }

    @Override
    public String toString() {
        return "{ " + "\n" +
                "   Id = " + Id + ",\n" +
                "   Name = '" + Name + '\'' + ",\n" +
                "   Price = " + Price + ",\n" +
                "   X = " + X + ",\n" +
                "   Y = " + Y + ",\n" +
                "   Z = " + Z + ",\n" +
                "   Weight = " + Weight + "\n" +
                "}";
    }
}
