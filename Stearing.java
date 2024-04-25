/* @Author Shanto2005 */
public class Stearing extends Component {
  public VehicleWheel FW;
  public SUIButton Left;
  public SUIButton Right;
  /// Run only once
  void start() {}

  /// Repeat every frame
  void repeat() {
      if(Left.isPressed()) {
          FW.setSteerRelativeVelocity(35);
      } else if(Right.isPressed()) {
          FW.setSteerRelativeVelocity(-35);
      } else {
          FW.setSteerRelativeVelocity(0);
      }
  }
} 
