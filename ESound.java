/* @Author Shanto2005 */
public class ESound extends Component {
public SoundPlayer E;
public SoundPlayer G;
public SUIText speedT;

public VehiclePhysics vp;
public Time T;

  /// Run only once
  void start() {
      vp = myObject.physics.vehiclePhysics;
  }
  
  // Gear system
  public int gear(int s) {
      if(s == 0 ) {
          return 0;
      } else if (s > 0 && s <= 5) {
          return 1;
      } else if(s > 5 && s <= 20) {
          return 2;
      } else if(s > 20 && s <= 40) {
          return 3;
      } else if(s > 40) {
          return 4;
      } else {
          return 0;
      }
  }

  /// Repeat every frame
  void repeat() {
      float Speed = vp.getSpeedKMH();
      speedT.setText(Math.abs((int) Speed));
      int gearNumber = gear((int) Speed) ;
      if (gearNumber == 0) {
        E.setPitch(1.0f);
      } else if (gearNumber == 1) {
          E.setPitch(Math.lerp(1.0f, 2.0f, vp.getSpeedKMH() / 20));
      } else if(gearNumber == 2) {
          E.setPitch(Math.lerp(1.2f, 2.0f, (vp.getSpeedKMH() - 5 )/ 20));
      } else if (gearNumber == 3) {
          E.setPitch(Math.lerp(1.2f, 2.0f, (vp.getSpeedKMH() - 20 )/ 80));
      } else if(gearNumber == 4) {
          E.setPitch(Math.lerp(1.1f, 2.0f, (vp.getSpeedKMH() -40  )/ 100));
      } 
      
  }
} 
