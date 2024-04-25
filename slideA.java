
  private String slideAxis = "slide";

  
  public float horizontalSensitivity = 10f;
  public float verticalSensitivity = 4;
  private float cameraMinAngle = -89;
  private float currentAngle;
  private float cameraMaxAngle = 89;
  private Characterbody cb;
  private Vector2 slideVec = new Vector2();
  private Vector3 dir = new Vector3(0,0,0);
  private float appliedSpeed = 0;
  private float speed;
  public SpatialObject camera;
  
  @Override
  public void start() {
    camera = myObject.findChildObject("Cam2");
    
  }

  @Override
  public void repeat() {
   try{
    Axis slide = Input.getAxis(slideAxis);
    slideVec.setX(-slide.getValue().getX());
    slideVec.setY(-slide.getValue().getY());
    } catch(Exception e) {}
    // horizontal slide
    myObject.getTransform().rotateInSeconds(0, slideVec.getX() * horizontalSensitivity * 360 * 0.0040f, 0);

    // vertical slide
    currentAngle += slideVec.getY() * verticalSensitivity * 90 * 0.0008f;
    
   // verticalSlide();
          currentAngle = Math.clamp(cameraMinAngle, currentAngle, cameraMaxAngle);
          float cos = Math.cos(currentAngle);
          float sin = Math.sin(currentAngle);
          dir.set(0, sin, cos);
          camera.getTransform().getRotation().localLookTo(dir);

   
    
}
