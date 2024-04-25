/* @Author Shanto2005 */
public class Damage extends Component {
    public Rigidbody rb;
    public SoundPlayer Crash;
    int i = 0;
    public SUIProgressBar PBar;
    float Value = 100;
  /// Run only once
  void start() {
      rb = (Rigidbody) myObject.getPhysics().getPhysicsEntity();
      
  }
  

  /// Repeat every frame
  void repeat() {
      Value = PBar.getValue();
      if(rb.isColliding()) {
          i++;
      } else {
          i = 0;
      }
      if(i == 1) {
          Value--;
          Crash.play();
      }
      // PBar
      PBar.setValue(Value);
  }
} 
