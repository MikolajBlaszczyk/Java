public class Product {
    public void setId(int id) {
        Id = id;
    }
    private int Id;

    public void setName(String name) {
        Name = name;
    }
    private String Name;

    public void setPrice(float price) {
        Price = price;
    }

    private float Price;
    private float X; //mm
    private float Y; //mm
    private float Z; //mm
    private float Weight; //kg

    public Product() {
        this.setId(0);
        this.setName("Product");
        this.setPrice(0);
        this.setDimValues(0,0,0);
        this.setWeight(0);
    }

    public static void main(String[] args) {
        Product testProduct = new Product();
        System.out.println(testProduct.toString());

        testProduct.setDimValues(2,3,4);
        System.out.println(testProduct.toString());

    }

    public void setDimValues(float x, float y, float z){
        X = x;
        Y = y;
        Z = z;
    }
    public void setWeight(float weight){
        Weight =weight;
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
