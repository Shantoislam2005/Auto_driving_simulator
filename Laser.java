/** @Author Shanto2005 */
public class Laser1 extends Component {
  public SpatialObject cam;
  public float D;
  String oName;
 // public SUIText T;
  public Time t;
  private float dt;
  public Rigidbody rb;

  /// Run only once
  @Override
  public void start() {
    dt = 0;
    rb = (Rigidbody) myObject.getPhysics().getPhysicsEntity();
    cam = myObject.findChildObject("Cube");
  }

  /// Repeat every frame
  @Override
  public void repeat() {
    LaserHit lh = new Laser().trace(cam.getTransform().getGlobalPosition(), cam.getTransform().forward(), 50);
    try {
      D = (lh.getDistance());
    } catch (Exception e) {
    }
    try {
      oName = lh.getObject().getName();
    } catch (Exception e) {
    }

    try {
      if (oName == "Auto" && D < 5.0) {
        myObject.moveInSeconds(0, 0, 0);
      } else if ( oName == "Rn" && D < 6.0) {
        myObject.moveInSeconds(0, 0, 0);
      } else {
        myObject.moveInSeconds(0, 0, 10);
      }
  //    T.setText(oName + " " + D);
    } catch (Exception e) {
    }

    // time
    if (dt > 0) {
      dt -= t.deltaTime();
    }
    if (dt > 1 && dt < 3) {
      dt = 0;
      myObject.destroy();
    } 
    // Collition
   

    if (rb.colliderWithName("Auto") || rb.colliderWithName("Traffic")) {
      dt = 35;
    }
    if(rb.colliderWithName("Return end")) {
        myObject.setPosition(4341f,30f,4671f);
    }
  }
}
