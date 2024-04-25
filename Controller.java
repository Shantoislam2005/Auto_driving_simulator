/* @Author Shanto2005 */
public class Controller extends Component {
    public SUIButton Accelerator;
    public SUIButton Brake;
    public SUIButton GearD;
    public SUIButton GearR;
    public SUIButton LightON;
    public SUIButton LightOFF;
    public SUIButton Cam1;
    public SUIButton Cam2;
    
    public VehicleWheel BLW;
    public VehicleWheel BRW;
    
    public SpatialObject ui;
    
    public int TorqueD = 500;
    public int TorqueR = -400;
    
    boolean Gear = true;
    
  /// Run only once
  void start() {
      TorqueD = 700;
  }
  
  // Gear management
  public void gear() {
      if(GearR.isDown()) {
          Gear = false;
          ui.findChildObject("Gear R").setEnabled(false);
          ui.findChildObject("Gear D").setEnabled(true);
      }
      if(GearD.isDown()) {
          Gear = true;
          ui.findChildObject("Gear D").setEnabled(false);
          ui.findChildObject("Gear R").setEnabled(true);
      }
  }


  /// Repeat every frame
  void repeat() {
      gear();
      
    // Accelerator
    if(Accelerator.isPressed()) {
        if(Gear == true) {
            BLW.setTorque(TorqueD);
            BRW.setTorque(TorqueD);
        } else if(Gear == false) {
            BLW.setTorque(TorqueR);
            BRW.setTorque(TorqueR);
        }
    } else {
        BLW.setTorque(0);
        BRW.setTorque(0);
    }
    // Brake System
    if(Brake.isPressed()) {
        BLW.setBrake(100);
        BRW.setBrake(100);
    } else {
        BLW.setBrake(0);
        BRW.setBrake(0);
    }
      // Camera change 
      if(Cam1.isDown()) {
          myObject.findChildObject("Cam").findChildObject("Cam2").setEnabled(false);
          myObject.findChildObject("Cam").findChildObject("Cam1").setEnabled(true);
          ui.findChildObject("Cam1").setEnabled(false);
          ui.findChildObject("Cam2").setEnabled(true);
      } 
      if(Cam2.isDown()) {
          myObject.findChildObject("Cam").findChildObject("Cam2").setEnabled(true);
          myObject.findChildObject("Cam").findChildObject("Cam1").setEnabled(false);
          ui.findChildObject("Cam1").setEnabled(true);
          ui.findChildObject("Cam2").setEnabled(false);
      }
  }
} 
