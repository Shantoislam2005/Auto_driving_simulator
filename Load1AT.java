/** @Author Shanto2005 */
public class Load1AT extends Component {

public AreaTrigger at;
public SpatialObject ob;
public SpatialObject B;
private SpatialObject Auto;

  /// Run only once
  @Override
  public void start() {
      ob = (SpatialObject) myObject;
      at = (AreaTrigger) ob.getPhysics().getPhysicsEntity();
      Auto = WorldController.findObject("Auto").findChildObject("Sit");
  }


  /// Repeat every frame
  @Override
  public void repeat() {
    if (at.colliderWithName("Auto")) {
        B.setEnabled(true);
      
    } else{
        B.setEnabled(false);
    }
    String S1 = ob.findChildObject("S1").getChildAt(0).getName();
    if(Input.getKey("P1").isDown()) {
        Auto.setEnabled(true);
        B.setEnabled(false);
        ob.setEnabled(false);
    }
  }
} 
