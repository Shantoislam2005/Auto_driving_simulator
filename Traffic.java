/* @Author Shanto2005 */
public class Traffic extends Component {
   
    public Time t;
    private float dt;
    private int i;
    public Random r;
    private Vector3 GP = new Vector3 (0f, 0f, 0f);
    private Vector3 RP = new Vector3 (0f, 0f, 0f);
    private Quaternion GR = new Quaternion (0f, 0f, 0f, 0f);
    private Quaternion RR = new Quaternion (0f, 0f, 0f, 0f);
    public SpatialObject Go;
    public SpatialObject Return;
    public SpatialObject Rrr;
    private int n;
    
    public SpatialObject [] Ob = new SpatialObject [20];
    public SpatialObject [] Rb = new SpatialObject [20];
    
    

  /// Run only once
  void start() {
      
      dt = 10;
      i = 0;
      GP =  Go.getPosition();
      RP = Return.getPosition();
      GR = Go.getRotation();
      RR = Return.getRotation(); 
      n = 0;
       }

 

  /// Repeat every frame
  void repeat() {
      dt -= t.deltaTime();
      
      if(dt < 2 && dt > 0 && i == 0) {
          Ob[n].setEnabled(true);
          Rb[n].setEnabled(true);
          n++;
          i++;
          dt = 15;
      } if(dt > 9) {
          i = 0;
      }
  }
} 
