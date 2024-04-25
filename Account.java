/* @Author Shanto2005 */
public class Account extends Component {
    public SUIButton Fuel;
    public SUIButton Garage;
    public SUIProgressBar FuelP;
    public SUIProgressBar GarageP;
    public SUIText Money;
    private double money;
    private float fuelValue;
    private float garageValue;
    public SpatialObject FuelPanel;
    public SpatialObject GaragePanel;
    public SUIText FuelPanelText;
    public SUIText GaragePanelText;
    private double fuelCost;
    public double garageCost;
    public SUIButton CloseTutorial;
    public SpatialObject TutorialUI;
  /// Run only once
  void start() {
      money = 1000.0;
  }

  public String USD(double value) {
    if (Math.abs(value) < 1000) {
      return String.format("%.2f", value);
    } else if (Math.abs(value) < 1e6) {
      return String.format("%.1fK", value / 1000);
    } else if (Math.abs(value) < 1e9) {
      return String.format("%.1fM", value / 1e6);
    } else {
      return String.format("%.1fB", value / 1e9);
    }
  }


  /// Repeat every frame
  void repeat() {
      fuelValue = FuelP.getValue();
      garageValue = GarageP.getValue();
      Money.setText(USD(money));
      FuelPanelText.setText("Total cost : " +USD(fuelCost));
      GaragePanelText.setText("Total cost : "+USD(garageCost));
      
      // get cost
      garageCost = (5000 / 100) * (100 - garageValue);
      fuelCost = (2000.0 / 1500.0) * (1500 - fuelValue);
      
      
      // Garage
      if(Garage.isDown()) {
          if(money >= garageCost) {
              GarageP.setValue(100);
              GaragePanel.setEnabled(false);
              money -= garageCost;
              Toast.showText("Fixed", 5);
          } else{
              Toast.showText("Not enough money", 5);
          }
      }
      // Fuel
      if(Fuel.isDown()) {
          if(money >= fuelCost) {
              FuelP.setValue(1500);
              FuelPanel.setEnabled(false);
              money -= fuelCost;
              Toast.showText("Done", 5);
          } else {
              Toast.showText("Not enough money", 5);
          }
      }
      if(CloseTutorial.isDown()) {
          TutorialUI.setEnabled(false);
      }
      
  }
} 

