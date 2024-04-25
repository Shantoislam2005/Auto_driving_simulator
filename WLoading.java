/* @Author Shanto2005 */
public class WLoading extends Component {
    public WorldFile wf;
    public SUIProgressBar PBar;
    public SUIButton Play;
    public SpatialObject bUI;
    public SpatialObject pUI;
    private float value;
    public SoundPlayer sp;
    public SpatialObject ui;
    public SUIButton OK;
  /// Run only once
  void start() {}

  /// Repeat every frame
  void repeat() {
      
      PBar.setValue(WorldController.getLoadPercent());
      if(Play.isDown()) {
          sp.play();
          WorldController.loadWorldAsync(wf);
          pUI.setEnabled(true);
          bUI.setEnabled(false);
          
         
      }
      if(OK.isDown()) {
          ui.setEnabled(false);
      }
  }
} 
