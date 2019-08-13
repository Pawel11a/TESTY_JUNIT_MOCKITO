package pl.testing;

public class Account {

    private Boolean active;
    private Address defaulrDeliveryAddress;

    public Account() {
        this.active = false;
    }

    public Account(Address defaulrDeliveryAddress) {
       this.defaulrDeliveryAddress = defaulrDeliveryAddress;
       if(defaulrDeliveryAddress != null){
           activate();
       }else{
           this.active = false;
       }
    }

    public void activate() {
        this.active = true;
    }

    public boolean isActivate() {
        return this.active;
    }
}
