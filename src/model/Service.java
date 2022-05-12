package model;

public class Service {
    private String nameFoodDrink;
    private int quantity;
    private int idService;


    public Service() {
    }

    public Service(String nameFoodDrink, int quantity, int idService) {
        this.nameFoodDrink = nameFoodDrink;
        this.quantity = quantity;
        this.idService = idService;
    }
    public String getNameFoodDrink() {
        return nameFoodDrink;
    }

    public void setNameFoodDrink(String nameFoodDrink) {
        this.nameFoodDrink = nameFoodDrink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }


    @Override
    public String toString() {
        return getNameFoodDrink() + "," + getQuantity() + "," + getIdService();
    }
}
