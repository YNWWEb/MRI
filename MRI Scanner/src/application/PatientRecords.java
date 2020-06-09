package application;


import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
public class PatientRecords extends Application {

   public static void main(String[] args) {
      Application.launch(args);
   }

   @Override
   public void start(Stage stage) throws Exception {

      GridPane root = new GridPane();
      FlowPane leftbanner = new FlowPane();
      leftbanner.setPrefWidth(200);
      String bgStyle = "-fx-background-color: lightblue;"
         + "-fx-background-radius: 0%;"
         + "-fx-background-inset: 5px;";
         leftbanner.setStyle(bgStyle);

         root.add(leftbanner, 0, 0, 1, 1);
         root.add(createGridPane(), 1, 0, 1, 1);
         Scene scene = new Scene(root, 850, 900);
         stage.setTitle("MRI Scan");
         stage.setScene(scene);
         stage.show();
   }

   public GridPane createGridPane() {
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10));
      grid.setHgap(10);
      grid.setVgap(10);

      Text txt = new Text("Patient Records");
      txt.setFont(Font.font("Dialog", FontWeight.BOLD, 12));

      grid.add(txt, 0, 0, 1, 1);
      grid.add(new Separator(), 0, 1, 3, 1);

      grid.add(new Label("Name:"), 0, 2, 1, 1);
      grid.add(new TextField(), 1, 2, 1, 1);
      
      grid.add(new Label("Date of birth:"), 0, 3, 1, 1);
      grid.add(new DatePicker(), 1, 3, 1, 1);
     

      grid.add(new Label("Address:"), 0, 4, 1, 1);
      grid.add(new TextField(), 1, 4, 1, 1);
      
      grid.add(new Label("Gender:"), 0, 5, 1, 1);
      grid.add(new RadioButton("Male"), 1, 5, 1, 1);
      grid.add(new RadioButton("Female"), 2, 5, 1, 1);
      
      grid.add(new Label("Phone Number:"), 0, 6, 1, 1);
      grid.add(new TextField(), 1, 6, 1, 1);
      grid.add(new Label("Email:"), 0, 7, 1, 1);
      grid.add(new TextField(), 1, 7, 1, 1);

      grid.add(new Separator(), 0, 8, 3, 1);
      grid.add(new Label("Medicare Card Number"), 0, 9,1,1);
      grid.add(new TextField(), 1, 9, 1, 1);
      grid.add(new Label("The insurance company"), 0, 10,1,1);
      grid.add(new TextField(), 1, 10, 1, 1);

      grid.add(new Label("Insurance Card Number"), 0, 11,1,1);
      grid.add(new TextField(), 1, 11, 1, 1);

      grid.add(new Separator(), 0, 12, 3, 1);
      grid.add(new Label("Implanted metal devices or objects"), 0, 13,1,1);

      grid.add(new CheckBox("Metal clips on blood vessels in your brain"), 0, 14, 3, 1);
      grid.add(new CheckBox("A pacemaker or implanted defibrillator"), 0, 15, 3, 1);
      grid.add(new CheckBox("A surgically implanted joint/pin"), 0, 16, 3, 1);
      grid.add(new CheckBox("Artificial heart valves"), 0, 17, 3, 1);
      grid.add(new CheckBox("A deep brain stimulator"), 0, 18, 3, 1);
      grid.add(new CheckBox("A cochlear implant"), 0, 19, 3, 1);
      grid.add(new CheckBox("None of them"), 0, 20, 3, 1);
      
      grid.add(new Separator(), 0, 21, 3, 1);
      grid.add(new Label(" MRI scan examine:"), 0, 22,1,1);

    
      ChoiceBox locationchoiceBox = new ChoiceBox(); 
      locationchoiceBox.getItems().addAll
         ("Brain and spinal cord", "Bones and joints", "Breasts", "Heart and blood vessels", "Internal organs");
      grid.add(locationchoiceBox, 1, 22,1,1);
      
      grid.add(new Separator(), 0, 28, 3, 1);
      Button quotation = new Button("Quotation");
      quotation.setOnAction(new QuotationListener());
		
      FlowPane fp = new FlowPane(Orientation.HORIZONTAL, 10, 10);
      fp.setAlignment(Pos.CENTER_RIGHT);
      fp.getChildren().addAll(
         new Button("< Back"),
         new Button("Next >"),
         new Button("Finish"),
         new Button("Cancel"),
         //new Button("Quotation")
         quotation);
      grid.add(fp, 0, 29, 3, 1);

      return grid;
      
   }
   
	   private class QuotationListener implements EventHandler<ActionEvent> {

			@Override
			public void handle(ActionEvent e) {
				
				Scene scene = new Scene(new Group());
				Stage stage = new Stage();
			    stage.setTitle("Quotation");
			    stage.setWidth(300);
			    stage.setHeight(190);

			    VBox vbox = new VBox();
			    vbox.setLayoutX(20);
			    vbox.setLayoutY(20);
			    

			    final String content = "Getting Quotation.................................";
			    final Text text = new Text(10, 20, "");
			    
			    final Animation animation = new Transition() {
			        {
			            setCycleDuration(Duration.millis(2000));
			        }
			        protected void interpolate(double frac) {
			            final int length = content.length();
			            final int n = Math.round(length * (float) frac);
			            text.setText(content.substring(0, n));
			        }
			    
			    };
			    animation.play();

			    vbox.getChildren().add(text);
			    vbox.setSpacing(10);
			    ((Group) scene.getRoot()).getChildren().add(vbox);

			    stage.setScene(scene);
			    stage.show();
			}
		}
}
