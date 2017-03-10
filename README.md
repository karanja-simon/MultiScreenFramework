# MultiScreenFramework
A clean JavaFX framework for managing multiple screens or views.

#### Getting Started
Clone the repo and grab the MultiScreeFramework.jar in the dist directory and import it to your project, then see the installation
section on how to use it.
To contribute, please see the contribution section.

#### Prerequisites
Ensure you have a minimum of Java 8 installed. If you are building from sources, ensure you have the latest JDK or atleast JDK8 and above.

#### Usage
To use the library, follow the steps carefully. 
> Please note that only an AnchorPane is fully supported as the wrapper container.
###### STEP 1
Add the MultiScreenFramework.jar to your project libraries
###### STEP 2
Create class, preferrably a Singleton to hold your screens say Screen.java and define all your screens/views with their corresponding   ids E.g
	
```java
public class Screens {

    private static final Screens INSTANCE = new Screens();

    private Screens() {
    }

    public static Screens getInstance() {
        return INSTANCE;
    }

    // Define all the screens/containers here
    // Give a descriptive screen name
    public String SCREEN_1_NAME = "screen_001";
    public String SCREEN_2_NAME = "screen_002";
    public String SCREEN_3_NAME = "screen_003";

    // Define the package where your view files are located
    public String PACKAGE_VIEW = "/multiscreenframeworkdemo/views/";

    // The actual screen/ui .fxml
    public String SCREEN_1_FXML = "screen_001.fxml";
    public String SCREEN_2_FXML = "screen_002.fxml";
    public String SCREEN_3_FXML = "screen_003.fxml";

}
```
###### STEP 3
 Foreach of the screens/views controllers, implement the IScreenController and implement the single method setScreenLoader() E.g
	
```java
public class Screen_001Controller implements Initializable, IScreenController {

    private ScreenLoader loader;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreenLoader loader) {
        this.loader = loader;
    }
    
}
```
###### STEP 3
In your main screen controller
```java

public class MainViewController implements Initializable {
    @FXML
    private Button view2Button;
    @FXML
    private Button view1Button;

    @FXML
    private AnchorPane wrapperAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
	ScreenLoader loader = new ScreenLoader();
	Screens screen = Screens.getInstance();
	// Configure loader
	loader.allowAnimation(AnimationSettings.ANIMATION_ON);
	loader.setAnimationType(AnimationSettings.ANIMATION_FADE);
	loader.setAnimationDuration(1);
	// Load screens
	loader.loadScreen(screen.SCREEN_1_NAME, screen.PACKAGE_VIEW + screen.SCREEN_1_FXML);
	loader.loadScreen(screen.SCREEN_2_NAME, screen.PACKAGE_VIEW + screen.SCREEN_2_FXML);
	loader.loadScreen(screen.SCREEN_3_NAME, screen.PACKAGE_VIEW + screen.SCREEN_3_FXML);

	// Load the initial (first) screen
	loader.setScreen(screen.SCREEN_1_NAME);
	// Set the parent container [Must be AnchorPane]
	loader.setWrapperAnchorPane(wrapperAnchorPane);


view1Button.setOnAction((ActionEvent event) -> {
    loader.setScreen(screen.SCREEN_1_NAME);
});
view2Button.setOnAction((ActionEvent event) -> {
    loader.setScreen(screen.SCREEN_2_NAME);
});

}
```

##### Demo
The framework comes bundled with a sample application. The sample is available on demo folder. Just navigate to MultiScreenFrameworkDemo folder and launch the JavaFXMultiScreenDemo.jar in the dist folder.
##### Screenshots

![shot_001](/MultiScreenFrameworkDemo/screenshots/shot_001.png)
![shot_001](/MultiScreenFrameworkDemo/screenshots/shot_002.png)



##### Built With

* [Netbeans](https://netbeans.org/) - Netbeans 8.0.2

##### Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

##### Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

##### Authors

* **Simon Karanja** - *Initial work* - [zilabs](http://zilabs.pe.hu)

##### License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

##### Acknowledgments

* Margret Kibe
