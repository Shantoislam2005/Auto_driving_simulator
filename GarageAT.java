/** @Author Shanto2005 */
public class GarageAT extends Component {

public AreaTrigger at;
public SpatialObject ob;
public SpatialObject GarageB;
public SUIButton in;
public SUIButton out;
public SpatialObject ui;


  /// Run only once
  @Override
  public void start() {
      ob = (SpatialObject) myObject;
      at = (AreaTrigger) ob.getPhysics().getPhysicsEntity();
  }


  /// Repeat every frame
  @Override
  public void repeat() {
    if (at.colliderWithName("Auto")) {
        GarageB.setEnabled(true);
      
    } else{
        GarageB.setEnabled(false);
    }
    if(in.isDown()) {
        ui.setEnabled(true);
    }
    if(out.isDown()) {
        ui.setEnabled(false);
    }
  }
} 
