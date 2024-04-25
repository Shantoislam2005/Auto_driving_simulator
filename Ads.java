/* @Author Shanto2005 */
public class Ads extends Component {
    public RewardedAd RAd = new RewardedAd("ca-app-pub-8044986194146692/9144038792");
   
  /// Run only once
  void start() {
      RAd.load();
      
  }

  /// Repeat every frame
  void repeat() {
      if(RAd.isLoaded()) {
          RAd.show();
      }
  }
} 
