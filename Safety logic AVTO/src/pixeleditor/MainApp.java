package pixeleditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelFormat;
import javafx.scene.layout.VBox;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.event.*;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.application.Platform;
//import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType; 
import javafx.scene.control.Alert; 
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;

import javax.imageio.ImageIO;
 
import javafx.scene.input.MouseEvent;
import java.awt.Graphics;
    import java.awt.Toolkit;
    import java.awt.datatransfer.DataFlavor;
    import java.awt.datatransfer.Transferable;
    import java.awt.image.BufferedImage;
    import java.awt.image.RenderedImage;
    import java.io.ByteArrayInputStream;
    import java.io.ByteArrayOutputStream;
import java.io.File;




public class MainApp extends Application {

    private Stage primaryStage;
   
    protected Scene itemEditorScene = null;    //private WebView webView; 
    protected Scene ruleEditorScene = null;
    protected Scene firstWindowScene = null; 
    
    //@FXML
    //private WebView fontWebView;

    public Label lab1 = null; 
    public Label labItems = null; 
    public Label labPlace = null;
    public Button newGame=null;
    private Canvas canvas = null;
    
    private Canvas canvas0 = null;
    
   
	private Canvas canvas1 = null;
    
    private Label labErrorMessage = null;
    
    private GameModel model = null;
    private GameMouseController controller = null;

	public int canvas_width;

	public int canvas_height;
	

	
    
    public Canvas getCanvas() {
        return this.canvas;
    }

    
    @Override
    public void init() throws Exception {
        
        GameModel model = new GameModel(this);
        
        this.model = model;
        
        this.controller = new GameMouseController(model);
        
       
        //
        //ModelMap.loadData(model);
        //
        
        this.firstWindowScene = this.createFirstWindowScene();
        this.itemEditorScene = this.createItemEditorScene();
        this.ruleEditorScene = this.createRuleEditorScene();
       
    }
    
    private Scene createFirstWindowScene() {
		 
        this.canvas = new Canvas(this.canvas_width,this.canvas_height);
        
        this.canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY   -> controller.handlePrimaryClick(event);
                case SECONDARY -> controller.handleSecondaryClick(event);
			default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
            }
        });
        
          
        
       Button snapShotBtn = new Button("Copy to clipboard");
    
    snapShotBtn.setOnAction((ActionEvent t) -> {
    	
//    		WritableImage wi = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
//            WritableImage snapshot = canvas.snapshot(new SnapshotParameters(), wi);
//
//            ClipboardContent cc = new ClipboardContent();
//            cc.putImage(snapshot);
//            Clipboard.getSystemClipboard().setContent(cc);

            
    });

                 
       Button loadFromSnapShot = new Button("Paste from clipboard");
   
       loadFromSnapShot.setOnAction((ActionEvent t) -> {
         try {
//                     java.awt.Image image = getImageFromClipboard();
//                    if (image != null) {
//                        javafx.scene.image.Image fimage = awtImageToFX(image);
//                        
//                        
//                        
//                        GraphicsContext gc1 = canvas.getGraphicsContext2D();
//                        gc1.drawImage(fimage,0,0,canvas.getWidth(),canvas.getHeight());
//                        
//                        ImageColor im = new ImageColor(model.im.cols,model.im.rows);
//                        WritableImage snap = gc1.getCanvas().snapshot(null, null);
//                        
//                        for (int y = 0; y < im.rows; y++) {
//                            for (int x = 0; x < im.cols; x++) {
//                                
//                                Color c1  =  snap.getPixelReader().getColor(x*this.model.getWidthOfCols(), y*this.model.getHeightOfRows());
//                                Color c2  =  snap.getPixelReader().getColor(x*this.model.getWidthOfCols()+1, y*this.model.getHeightOfRows());
//                                System.out.println(c1+"--"+c2);
//                                
//                                im.set(x,y, new Field("meta",new ImagePoint(x,y),new ColorColor(c1,c2),"meta"));
//                       
//                            }
//                        }
//                        
//                        model.setImageColor(im);
//                        
//                        // ImagePointColor icp = null;
//                        // for (int y = 0; y < im.rows; y++) {
//                            // for (int x = 0; x < im.cols; x++) {
//                                // if(im.get(x,y).equals(Color.RED)) {
//                                    // icp = new ImagePointColor(x,y,Color.RED);
//                                    // break;
//                                // }
//                            // }
//                        // }
//                        
//                        // if(icp==null) { 
//                        
//                     // //      MainApp.defineHeroPositionAndSetHero();
//                           
//                        
//                           
//                        
//                        // }
//                        // else {
//                            
//                           // // ArrayList<ImagePointColor> list =  MainGraphics.pointColorsNear(im, icp.x, icp.y);
//                           // // Color maxColor = MainGraphics.getMaxColor(list);
//                            
//                            // //GameModel.heroPositionX = icp.x;
//                            // //GameModel.heroPositionY = icp.y;
//                            // //GameModel.underHeroColor =  maxColor;
//                         // //MainGraphics.setHero(  im, GameModel.heroPositionX, GameModel.heroPositionY ); 
//                        
//                    // }
//                     redrawBoard(); 
//                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
    });
    
   
    // Button btn = new Button("step");
    // btn.setOnAction( new EventHandler<ActionEvent>() {
        // @Override
        // public void handle(ActionEvent event) {
            // try 
            // {
                // step();
            // } 
            // catch (Exception ex) {
                  // ex.printStackTrace();
            // }
        // }
    // });
    
    newGame = new Button("New");
    newGame.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
                model.initGameFields();
                newGame.setVisible(false);
                // scale_plus(10);
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
Button checkIt = new Button("Look for");
    checkIt.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
                model.lookForItems();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    Button takeIt = new Button("Take item");
    takeIt.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
                model.takeSelected();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    
     Button remF = new Button("Drop item");
    remF.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
                model.dropSelectedItems();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    Button linkSel = new Button("Make item");
    linkSel.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
                 model.linkSelected();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    Button useSel = new Button("Use item");
    useSel.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
            	model.useSelectedItem();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    Button notUseSel = new Button("Not Use item");
    notUseSel.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
            	model.notUseSelectedItem();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
     Button repairSel = new Button("Repair item");
    repairSel.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
                model.repairSelectedItem();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
/////////////////////////////////////////////////////////////////////////////////        
    Button addItem = new Button("Add custom item");
    addItem.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
            	primaryStage.setScene(itemEditorScene);  
                //model.addCustomItem();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    Button addRule = new Button("Add custom rule");
    addRule.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
            	primaryStage.setScene(ruleEditorScene);  
                //model.addCustomRule();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
     
    
    Button cloneItem = new Button("Clone item (edit mode only)");
    cloneItem.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
 //               model.cloneItem();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    
    
    
    Button rnd = new Button("Summon random");
    rnd.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
     //           model.summonRandom();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    
    Button showStats = new Button("Show stats");
    showStats.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
            	model.showStats();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
    
    
    Button saveData = new Button("Save data");
    saveData.setOnAction( new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             try 
             {
            	 if(ModelMap.isDataLoaded()==true)
            		 ModelMap.saveData(model);
            	 else 
            		 GameModel.err("Load data before");
             } 
             catch (Exception ex) {
                   ex.printStackTrace();
             }
         }
     });
    
    
   Button loadData = new Button("Load data");
   loadData.setOnAction( new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try 
            {
            	ModelMap.loadData(model);
            	model.initGameFields();
            	redrawBoardPro();
            } 
            catch (Exception ex) {
                  ex.printStackTrace();
            }
        }
    });
    
  
        
       // ListView<String> listView = new ListView<String>();
        
        
        
        
        
        //wordsList.add(new Word("First Word", "Definition of First Word"));
        //wordsList.add(new Word("Second Word", "Definition of Second Word"));
    //    itemsList.add(new It(new ItemType("ddd","dsdsd","ffff", new ColorPoint())));
        
     //   ListView<It> listViewOfWords = new ListView<It>(itemsList);
        
        
        
        ListView<It> listView = new ListView<It>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
        listView.setPrefSize(250, 180);
      
        listView.setCellFactory(new Callback<ListView<It>, ListCell<It>>() {

            @Override
            public ListCell<It> call(ListView<It> param) {
                ListCell<It> cell = new ListCell<It>() {

                    @Override
                    protected void updateItem(It item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getEnLocaleName()+"["+item.getId()+"]");
                        } else {
                            setText("");
                        }
                    }
                };
                return cell;
            }

        });
        
        GameModel.getInventory().setListView(listView);
        GameModel.getInventory().refresh();
        //ObservableList<It> itemsList = GameModel.getInventory().getAllItems();//FXCollections.observableArrayList();
        
        //listView.setItems(itemsList);
        
        
//         
//        
//        
//        listView.setOnMouseClicked( new EventHandler<MouseEvent>() {
//
//                @Override
//                public void handle(MouseEvent event) {
//                    ObservableList<String> selectedItems =  listView.getSelectionModel().getSelectedItems();
//
//                    for(String s : selectedItems){
//                        System.out.println("selected item " + s.toString());
//                    }
//
//                }
//
//        });
//        
        model.getInventory().setListView(listView);
        
        
        ListView<String> listView4 = new ListView<String>();
       // listView4.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
        listView4.setPrefSize(250, 180);
        
        listView4.setOnMouseClicked( new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                 //   ObservableList<String> selectedItems =  listView.getSelectionModel().getSelectedItems();

                 //   for(String s : selectedItems){
                 //       System.out.println("selected item " + s.toString());
                 //   }

                }

        }); 
        
        model.getStats().setListView(listView4);
        
         
        model.setLabErrorMessageLink(labErrorMessage); 
        
        ListView<It> listView2 = new ListView<It>();
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
        listView2.setPrefSize(250, 80);
        
        listView2.setCellFactory(new Callback<ListView<It>, ListCell<It>>() {

            @Override
            public ListCell<It> call(ListView<It> param) {
                ListCell<It> cell = new ListCell<It>() {

                    @Override
                    protected void updateItem(It item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getEnLocaleName()+"["+item.getId()+"]");
                        } else {
                            setText("");
                        }
                    }
                };
                return cell;
            }

        });
        
        model.getInUseList().setListView(listView2);
        model.getInUseList().refresh();
        
        
        labPlace = new Label("");// + GameModel.getHeroPlace());
        lab1 = new Label("Gold: ");// + GameModel.gold_counter);
        // HBox line0 = new HBox( txt1, txt2, btn3, btn4 );
        HBox line01 = new HBox( );
        Label otd1 = new Label("test");
        HBox line_otd1 = new HBox( otd1 );
        Label otd2 = new Label("test");
        HBox line_otd2 = new HBox( otd2 );
        otd1.setVisible(false);
        otd2.setVisible(false);
        
         Label otd3 = new Label("test");
        HBox line_otd3 = new HBox( otd3 );
        otd3.setVisible(false);
        
        labErrorMessage = new Label("  ");
        model.setLabErrorMessageLink(labErrorMessage);
        
        VBox line7 =new VBox( new Label("With me:"),listView,new Label("In use:"),listView2,new Label("Stats:"),listView4); 
        HBox lineErrorMessage = new HBox( labPlace );
        HBox linePlace = new HBox( labPlace );
        HBox line0 = new HBox( newGame,  saveData,loadData );
        HBox line = new HBox(   checkIt, takeIt, remF, linkSel, useSel, notUseSel, repairSel  );//, btn );
        HBox lineEditor = new HBox(loadData,addItem,addRule,saveData);
      VBox line8 = new VBox(new Label("Map:"), getCanvas());
        
        line.setAlignment(Pos.CENTER);
        lineEditor.setAlignment(Pos.CENTER);
        line.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        line.setSpacing(10.0);
        lineEditor.setPadding(new Insets(10.0, 5.0, 5.0, 5.0));
        lineEditor.setSpacing(5.0);
        linePlace.setAlignment(Pos.CENTER);
        //snapShotBtn.setVisible(false);
        //loadFromSnapShot.setVisible(false); 
        newGame.setVisible(false);
        //VBox root = new VBox( line0, getCanvas(), line );
        //HBox line2 = new HBox(line7, new Label("[ + ]") ,getCanvas());
        HBox line2 = new HBox(line7, line8);
        line2.setSpacing(20.0);
        VBox root = new VBox( line01, lineEditor, line, labErrorMessage, line_otd1, linePlace, line_otd2, line2, line_otd3    ); 
        
        root.setAlignment(Pos.CENTER);
        line2.setAlignment(Pos.TOP_CENTER);
        line0.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 686, 650,Color.rgb(0,0,0));
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.isControlDown() && (event.getCode() == KeyCode.N)) {
                    System.out.println("New Game pressed");
                    try 
                    {
                      //  model.initGameFields();
                         
                    } 
                    catch (Exception ex) {
                          ex.printStackTrace();
                    }
                } else if (event.isControlDown() && (event.getCode() == KeyCode.C)) {
                    System.out.println("Exit pressed");
                    System.exit(1);
                } 
            }
        });
        
        
		return scene;
	}


	@Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(" Gold ");
     //   this.webView = new WebView(); //works!!!
     //   this.fontWebView = new WebView();
        
        initRootLayout();
        
        
        
        this.primaryStage.setOnCloseRequest( new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        } );
        
    }
 
        
    public void initRootLayout() {
       
        
       
        try {
           

           primaryStage.setScene(this.firstWindowScene);
                            
           
            
            //scale_plus(10);
             
            
            primaryStage.show(); 
            
             
            //model.initGameFields();
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public Scene createRuleEditorScene() {
    
    	
    	Button updateWhenAllChangesConfirmed = null;
    	
    	 ListView<ItemType> listView1 = new ListView<ItemType>();
    	 listView1.setCellFactory(new Callback<ListView<ItemType>, ListCell<ItemType>>() {

             @Override
             public ListCell<ItemType> call(ListView<ItemType> param) {
                 ListCell<ItemType> cell = new ListCell<ItemType>() {

                     @Override
                     protected void updateItem(ItemType item, boolean empty) {
                         super.updateItem(item, empty);
                         if (item != null) {
                             setText(item.getEnLocaleName()+"["+item.getId()+"]");
                         } else {
                             setText("");
                         }
                     }
                 };
                 return cell;
             }

         });
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 ListView<ItemType> listView2 = new ListView<ItemType>();
    	 listView2.setCellFactory(new Callback<ListView<ItemType>, ListCell<ItemType>>() {

             @Override
             public ListCell<ItemType> call(ListView<ItemType> param) {
                 ListCell<ItemType> cell = new ListCell<ItemType>() {

                     @Override
                     protected void updateItem(ItemType item, boolean empty) {
                         super.updateItem(item, empty);
                         if (item != null) {
                             setText(item.getEnLocaleName()+"["+item.getId()+"]");
                         } else {
                             setText("");
                         }
                     }
                 };
                 return cell;
             }

         });
    	 
    	
    	
    	Button btn5 = new Button("Confirm");
    	
    	
    	
    	Label lbl1 = new Label(" Add to beforeItemsCondition: ");
    	TextField textField1 = new TextField();
    	
    	TextField textField7 = new TextField();
    	
        textField1.setPrefColumnCount(11);
        Button btn1 = new Button("Add");
        btn1.setOnAction(event -> {
        	
        	//lbl1.setText(lbl1.getText() + " Input: " + textField1.getText());
        	
        	showAlertWithMessage("id=["+textField7.getText()+"]");
        	
        	String id = textField7.getText().trim();
        	if(id.equals("")) {
        		return;
        	}
        	listView1.getItems().add(new ItemType(ModelMap.getTypesOfItems().getById(id)));		
        
        });
    	
    	Label lbl2 = new Label("  Add to afterItemsCondition: ");
    	TextField textField2 = new TextField();
        textField2.setPrefColumnCount(11);
        Button btn2 = new Button("Add");
        btn2.setOnAction(event -> {
        	
        	showAlertWithMessage("id=["+textField7.getText()+"]");
        	
        	String id = textField7.getText().trim();
        	if(id.equals("")) {
        		return;
        	}
        	listView2.getItems().add(new ItemType(ModelMap.getTypesOfItems().getById(id)));
        	//updateWhenAllChangesConfirmed.setDisable(false);
        } );
        
        Label lbl3 = new Label(" Enter firstColor R,G,B: ");
    	TextField textField3 = new TextField();
        textField3.setPrefColumnCount(11);
        Button btn3 = new Button("Confirm");
        btn3.setOnAction(event -> {
        	//lbl3.setText(lbl3.getText() + " Input: " + textField3.getText());
        });
    	
    	Label lbl4 = new Label(" Enter secondColor R,G,B: ");
    	TextField textField4 = new TextField();
        textField4.setPrefColumnCount(11);
        Button btn4 = new Button("Confirm");
        btn4.setOnAction(event -> {
        	//lbl4.setText(lbl4.getText() + " Input: " + textField4.getText());
        });
        Label lblFile = new Label();
        Button browseFile = new Button("Browse for image 19x19");
        browseFile.setOnAction(event -> {
        	//lbl5.setText(lbl5.getText() + " Input: " + textField4.getText()));

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
             File file = fileChooser.showOpenDialog(this.primaryStage);
           
            if (file != null) {
                lblFile.setText(file.getName());
            }
            
        
        });
        
        
    	 Button switchToFirstWindowButton = new Button("Switch to main window");
    	  switchToFirstWindowButton.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	primaryStage.setScene(firstWindowScene);
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	  
    	  Button switchToItemEditorButton = new Button("Switch to item editor");
    	  switchToItemEditorButton.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	primaryStage.setScene(itemEditorScene);
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	  
    	
    	  
    	  updateWhenAllChangesConfirmed = new Button("Update When All Changes Confirmed");
    	  updateWhenAllChangesConfirmed.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	if((listView1.getItems().size()==0) || (listView2.getItems().size()==0)) {
    	            		showAlertWithMessage("Not ready left or right side");
    	            		return;	
    	            	}
    	            	showAlertWithMessage("Now we try to add new rull.");
    	            		showAlertWithMessage("Not implemented yet");
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	  
    	  Button discardAllChanges = new Button("Discard All Changes");
    	  discardAllChanges.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	listView1.getItems().clear();
    	            	listView2.getItems().clear();
    	            	//updateWhenAllChangesConfirmed.setDisable(true);
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	  
    	  Label lbl0 = new Label(" Enter enLocaleName: ");
      	TextField textField0 = new TextField();
          textField0.setPrefColumnCount(11);
          Button btn0 = new Button("Search");
          btn0.setOnAction(event -> {
          	
        	  textField7.setText("");
        	  String s = textField0.getText();
            	
            	TypesOfItems list = ModelMap.getTypesOfItems();
  			if(list == null) 
  			{
  				System.out.println("Types of items not found. Load data before");
  				return;
  			}
            	ItemType itemType = list.getByEnLocaleName(s);
  			 
            	 boolean switchValue = false; 
  		         textField1.setDisable(switchValue);
  		         btn1.setDisable(switchValue);
  		         textField2.setDisable(switchValue);
  		         btn2.setDisable(switchValue);
  		         textField3.setDisable(switchValue);
  		         btn3.setDisable(switchValue);
  		         textField4.setDisable(switchValue);
  		         btn4.setDisable(switchValue);
  		         browseFile.setDisable(switchValue);
  		         btn5.setDisable(switchValue);
  			
  		         if(itemType!=null) {
  				
  		        	 btn2.setDisable(false);
  		        	 btn1.setDisable(false);

            	}
  			else {
  			
  				textField1.setText("");	
  		        	textField2.setText("");	
  		        	 btn2.setDisable(true);
  		        	 btn1.setDisable(true);
  				
  				
  				//itemType = new ItemType();
  				//itemType.setColorPoint(HelperRandom.getRandomColorPoint());
  				showAlertWithMessage("Not found ["+s+"]");
  				return;
  			}
  			
  			    textField1.setText(itemType.getEnLocaleName());
            	textField2.setText(itemType.getEnLocaleName());
            	///	textField3.setText(""+HelperRandom.strColor(itemType.getColorPoint().getColor0()));
            	//	textField4.setText(""+HelperRandom.strColor(itemType.getColorPoint().getColor1()));
            	//	lblFile.setText(itemType.getImagePath()); 
            	textField7.setText(itemType.getId());
  			
			
          });
    	    
    	    
    	HBox line0 = new HBox(lbl0,textField0,btn0);
    	line0.setAlignment(Pos.CENTER);
    	HBox line1 = new HBox(lbl1,textField1,btn1);
    	line1.setAlignment(Pos.CENTER);
    	HBox line3 = new HBox( listView1, listView2 );
    	line3.setAlignment(Pos.CENTER);
    	HBox line2 = new HBox(lbl2,textField2,btn2);
    	line2.setAlignment(Pos.CENTER);
    	HBox line4 = new HBox(switchToFirstWindowButton, switchToItemEditorButton  );
    	line4.setAlignment(Pos.CENTER);
//    	line3.setAlignment(Pos.CENTER);
//    	HBox line4 = new HBox(lbl4,textField4,btn4);
//    
//    	
//		HBox line5 = new HBox(lblFile ,browseFile);
//    	line5.setAlignment(Pos.CENTER);
    	
    	HBox lineSubmit = new HBox(discardAllChanges, updateWhenAllChangesConfirmed );
    	lineSubmit.setAlignment(Pos.CENTER); 
    	VBox root = new VBox( new Label("Rule editor scene test ok") , line4, line0, line1, line2,line3, lineSubmit  ); 
         
         root.setAlignment(Pos.CENTER);
          
         
         Scene scene = new Scene(root, 686, 650,Color.rgb(0,0,0));
         root.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
         
        
    	
    	return scene;	
    }
    
	private void shuffleCells() {
		Collections.shuffle(model.cells);
		int n=0;
		for(int i=0;i<GameModel.windowWidth;i++) {
			for(int j=0;j<GameModel.windowHeight;j++) {
				Cell c = model.cells.get(n);
				c.x = i;
				c.y = j;
				n++;
			}	
		}
		model.app.redrawCanvases();
	}
	
    public Scene createItemEditorScene() {
    	
    	Button[] btns = new Button[5];
    	 
    	
    	Button btn1 =new Button("Confirm");
		btns[0]= btn1; 
         Button btn2 = new Button("Confirm");
		btns[1]= btn2;
         Button btn3 = new Button("Confirm");
		btns[2]= btn3;
         Button btn4 = new Button("Confirm");
		btns[3]= btn4;
         Button btn5 = new Button("Confirm");
		btns[4]= btn5;
		TextField textField7 = new TextField();
		TextField textField1 = new TextField();
		TextField textField2 = new TextField();
	   	TextField textField3 = new TextField();	
	
	   	TextField textField4 = new TextField();
	 	
	   	Button shuffle = new Button("Shuffle");
		 	shuffle.setOnAction( new EventHandler<ActionEvent>() {
		  	        @Override
		  	        public void handle(ActionEvent event) {
		  	            try 
		  	            {
		  	            	 shuffleCells();
		  	            }
		  	       
		            catch (Exception ex) {
		                  ex.printStackTrace();
		            }
		        }
		 	});
		
	   	
	   	
	   	Button loadRules = new Button("Load rules");
	 	loadRules.setOnAction( new EventHandler<ActionEvent>() {
	  	        @Override
	  	        public void handle(ActionEvent event) {
	  	            try 
	  	            {
	  	            	 model.loadRules();
	  	            }
	  	       
	            catch (Exception ex) {
	                  ex.printStackTrace();
	            }
	        }
	 	});
	 	
		Button saveRules = new Button("Save rules");
	 	saveRules.setOnAction( new EventHandler<ActionEvent>() {
	  	        @Override
	  	        public void handle(ActionEvent event) {
	  	            try 
	  	            {
	  	            	 model.saveRules(getPrimaryStage());
	  	            }
	  	       
	            catch (Exception ex) {
	                  ex.printStackTrace();
	            }
	        }
	 	});
 
	 	Button modeTakeColor = new Button("Take color");
	 	modeTakeColor.setOnAction( new EventHandler<ActionEvent>() {
	  	        @Override
	  	        public void handle(ActionEvent event) {
	  	            try 
	  	            {
	  	            	 //model.saveRules(getPrimaryStage());
	  	            }
	  	       
	            catch (Exception ex) {
	                  ex.printStackTrace();
	            }
	        }
	 	});
	 	
		Button modeSetColor = new Button("Set color");
	 	modeSetColor.setOnAction( new EventHandler<ActionEvent>() {
	  	        @Override
	  	        public void handle(ActionEvent event) {
	  	            try 
	  	            {
	  	            	 //model.saveRules(getPrimaryStage());
	  	            }
	  	       
	            catch (Exception ex) {
	                  ex.printStackTrace();
	            }
	        }
	 	});
 
 
	   	Button updateWhenAllChangesConfirmed = new Button("Update When All Changes Confirmed");
    	  updateWhenAllChangesConfirmed.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	 String id = textField7.getText();
    	            	 if(id.equals("")) {
    	            		 return;
    	            	 }
    	            	 
    	            	 String enLocaleName = textField1.getText();
    	            	 String firstLocaleName = textField2.getText();
    	            	 
    	            	 Color color1 = GameRegExp.getColorFromString(textField3.getText());
						Color color2 =  GameRegExp.getColorFromString(textField4.getText());
						
						ColorPoint colorPoint = new ColorPoint(color1, color2);
    	            	
						ItemType tp = ModelMap.getTypesOfItems().getById(id);
						if(tp == null) {
							tp = new ItemType(id, enLocaleName,firstLocaleName , colorPoint);
						} 
						else {
							tp = new ItemType(id, enLocaleName,firstLocaleName , colorPoint);
							ModelMap.getTypesOfItems().removeItemType(tp);
							
						}
						
    	            	ModelMap.getTypesOfItems().add(tp);
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	 
    	Label lbl1 = new Label(" Enter enLocaleName: ");
    	
        textField1.setPrefColumnCount(11);
        ;
        btn1.setOnAction(event -> {
        	
        	String s = btn1.getText();
        	//System.out.println("btn"+s);
        	if(s.equals("Confirm")) btn1.setText("Confirmed");
        	else if(s.equals("Confirmed")) btn1.setText("Confirm");
        	
        	if(allDisabled(btns)) 
        		updateWhenAllChangesConfirmed.setDisable(false);
        
        });
        
       
    	
    	Label lbl2 = new Label(" Enter firstLocaleName: ");
    	
        textField2.setPrefColumnCount(11);
        
        btn2.setOnAction(event -> {
        	
        	String s = btn2.getText();
        	//System.out.println("btn"+s);
        	if(s.equals("Confirm")) btn2.setText("Confirmed");
        	else if(s.equals("Confirmed")) btn2.setText("Confirm");
        
        	if(allConfirmed(btns)) updateWhenAllChangesConfirmed.setDisable(false);
            else  updateWhenAllChangesConfirmed.setDisable(true);
       	
        	//lbl2.setText(lbl2.getText() + " Input: " + textField2.getText());
        } );
        
        Label lbl3 = new Label(" Enter firstColor R,G,B: ");
 
        textField3.setPrefColumnCount(11);
        
        btn3.setOnAction(event -> {
        	
        	String s = btn3.getText();
        	//System.out.println("btn"+s);
        	if(s.equals("Confirm")) btn3.setText("Confirmed");
        	else if(s.equals("Confirmed")) btn3.setText("Confirm");
        	
        	if(allConfirmed(btns)) updateWhenAllChangesConfirmed.setDisable(false);
            else  updateWhenAllChangesConfirmed.setDisable(true);
       	
        	//lbl3.setText(lbl3.getText() + " Input: " + textField3.getText());
        });
    	
    	Label lbl4 = new Label(" Enter secondColor R,G,B: ");
    
        textField4.setPrefColumnCount(11);
       
        btn4.setOnAction(event -> {
        	
        	String s = btn4.getText();
        	//System.out.println("btn"+s);
        	if(s.equals("Confirm")) btn4.setText("Confirmed");
        	else if(s.equals("Confirmed")) btn4.setText("Confirm");
        
        	if(allConfirmed(btns)) updateWhenAllChangesConfirmed.setDisable(false);
            else  updateWhenAllChangesConfirmed.setDisable(true);
       	
        	//lbl4.setText(lbl4.getText() + " Input: " + textField4.getText());
        });
        
      
        btn5.setOnAction(event -> {
        	//lbl4.setText(lbl4.getText() + " Input: " + textField4.getText());
        	
        	String s = btn5.getText();
        	//System.out.println("btn"+s);
        	if(s.equals("Confirm")) btn5.setText("Confirmed");
        	else if(s.equals("Confirmed")) btn5.setText("Confirm");
        	
        	if(allConfirmed(btns)) updateWhenAllChangesConfirmed.setDisable(false);
            else  updateWhenAllChangesConfirmed.setDisable(true);
       		
        	
        });
        
        Label lblFile = new Label();
        Button browseFile = new Button("Browse for image 19x19");
        browseFile.setOnAction(event -> {
        	//lbl5.setText(lbl5.getText() + " Input: " + textField4.getText()));

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
             File file = fileChooser.showOpenDialog(this.primaryStage);
           
            if (file != null) {
                lblFile.setText(file.getName());
            }
            
        
        });
        
        
    	 Button switchToFirstWindowButton = new Button("Switch to main window");
    	  switchToFirstWindowButton.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	primaryStage.setScene(firstWindowScene);
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	  
    	  Button switchToRuleEditorButton = new Button("Switch to rule editor");
    	  switchToRuleEditorButton.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	primaryStage.setScene(ruleEditorScene);
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	  
    	  
    	
    	  
    	  Button discardAllChanges = new Button("Discard All Changes");
    	  discardAllChanges.setOnAction( new EventHandler<ActionEvent>() {
    	        @Override
    	        public void handle(ActionEvent event) {
    	            try 
    	            {
    	            	textField7.setText("");
    	            } 
    	            catch (Exception ex) {
    	                  ex.printStackTrace();
    	            }
    	        }
    	    });
    	  
    	  Label lbl0 = new Label(" Enter enLocaleName: ");
      	TextField textField0 = new TextField();
          textField0.setPrefColumnCount(11);
          Button btn0 = new Button("Search");
          btn0.setOnAction(event -> {
          	
        	  textField7.setText("");
          	String s = textField0.getText();
          	
          	TypesOfItems list = ModelMap.getTypesOfItems();
			if(list == null) 
			{
				System.out.println("Types of items not found. Load data before");
				return;
			}
          	ItemType itemType = list.getByEnLocaleName(s);
			 
          	 boolean switchValue = false; 
		         textField1.setDisable(switchValue);
		         btn1.setDisable(switchValue);
		         textField2.setDisable(switchValue);
		         btn2.setDisable(switchValue);
		         textField3.setDisable(switchValue);
		         btn3.setDisable(switchValue);
		         textField4.setDisable(switchValue);
		         btn4.setDisable(switchValue);
		         browseFile.setDisable(switchValue);
		         btn5.setDisable(switchValue);
			
		         if(itemType!=null) {
				
		        	
				
				

          	}
			else {
			
				itemType = new ItemType();
				itemType.setColorPoint(HelperRandom.getRandomColorPoint());
			}
			
			    textField1.setText(itemType.getEnLocaleName());
          		textField2.setText(itemType.getFirstLocaleName());
          		textField3.setText(""+HelperRandom.strColor(itemType.getColorPoint().getColor0()));
          		textField4.setText(""+HelperRandom.strColor(itemType.getColorPoint().getColor1()));
          		lblFile.setText(itemType.getImagePath()); 
          		textField7.setText(itemType.getId());
			
			 
          });
    	    
    	  
        	
    	HBox line0 = new HBox(lbl0,textField0,btn0);
    	line0.setAlignment(Pos.CENTER);
    	HBox line1 = new HBox(lbl1,textField1,btn1);
    	line1.setAlignment(Pos.CENTER);
    	HBox line2 = new HBox(lbl2,textField2,btn2);
    	line2.setAlignment(Pos.CENTER);
    	HBox line3 = new HBox(lbl3,textField3,btn3);
    	line3.setAlignment(Pos.CENTER);
    	HBox line4 = new HBox(lbl4,textField4,btn4);
    	line4.setAlignment(Pos.CENTER);
    	
		HBox line5 = new HBox(lblFile ,browseFile, btn5);
    	line5.setAlignment(Pos.CENTER);
    	HBox line7 = new HBox( switchToRuleEditorButton, switchToFirstWindowButton);
    	line7.setAlignment(Pos.CENTER);
    	HBox lineSubmit = new HBox(discardAllChanges, updateWhenAllChangesConfirmed,saveRules,loadRules,shuffle );
    	lineSubmit.setAlignment(Pos.CENTER); 
    	
    	////////////////////////////////////////////////////////////////////
    	 HBox box = new HBox();
         box.setPadding(new Insets(5, 5, 5, 5));          
         box.setAlignment(Pos.CENTER);  
         
         final ColorPicker colorPicker = new ColorPicker();
         colorPicker.setValue(Color.CORAL);
         
         final Text text = new Text(" Try the color picker!");
         text.setFont(Font.font ("Verdana", 20));
         text.setFill(colorPicker.getValue());
         
         colorPicker.setOnAction(new EventHandler() {
             public void handle(Event t) {
                 text.setFill(colorPicker.getValue());               
             }
         });
  
         box.getChildren().addAll(colorPicker, text);
         //////////////////////////////////////////////////////////////////
    	
         HBox line9 = new HBox(modeTakeColor,modeSetColor,box);
     	line9.setAlignment(Pos.CENTER);
         
     	
     	this.canvas0 = new Canvas( GameModel.cellWidth * GameModel.windowWidth, GameModel.cellHeight * GameModel.windowHeight );
         
         this.canvas0.setOnMouseClicked(event -> {
	        	 try {
	             
	        		 switch (event.getButton()) {
		                 case PRIMARY   -> controller.handlePrimaryClickCanvas0(event);
		                 case SECONDARY -> controller.handleSecondaryClickCanvas0(event);
		                 default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
	        		 }
	             } 
	        	 catch (Exception e) {
	        		 e.printStackTrace();
	        	 }
         	 });
         /////////
		 
         // this.canvas1 = new Canvas(380,380);
         
         // this.canvas1.setOnMouseClicked(event -> {
             // switch (event.getButton()) {
                 // case PRIMARY   -> controller.handlePrimaryClickCanvas1(event);
                 // case SECONDARY -> controller.handleSecondaryClickCanvas1(event);
 			// default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
             // }
         // });
     	
     	
         
         
         
         
         HBox boxCanvases = new HBox(canvas0);
    	
         boxCanvases.setAlignment(Pos.CENTER);
    	
//         try {
//			model.initCells();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//         
//    	
    	
    	VBox root = new VBox( line9, boxCanvases, line0, line1,line2,line3,line4, line5, lineSubmit, line7  ); 
         
         root.setAlignment(Pos.CENTER);
         boolean switchValue = true; 
         textField1.setDisable(switchValue);
         btn1.setDisable(switchValue);
         textField2.setDisable(switchValue);
         btn2.setDisable(switchValue);
         textField3.setDisable(switchValue);
         btn3.setDisable(switchValue);
         textField4.setDisable(switchValue);
         btn4.setDisable(switchValue);
         btn5.setDisable(switchValue);
         browseFile.setDisable(switchValue);
         updateWhenAllChangesConfirmed.setDefaultButton(switchValue);
         
         Scene scene = new Scene(root, 686, 650,Color.rgb(0,0,0));
         root.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
        
         try {
			model.initRandomCells();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         redrawCanvases();
         
        // btns[4]=;
         return scene;
    }
    
   

    
    //
 synchronized   void  redrawCanvases() {
    	
    	// width and height of the canvas
        int width = GameModel.windowWidth * GameModel.cellWidth; //(int) getCanvas0().getWidth();
        int height = GameModel.windowHeight * GameModel.cellHeight; //(int) getCanvas0().getHeight();

        // array to hold rgb value for every pixel
        byte[] pixels = new byte[width * height * 3];

        // Get the graphics context of the canvas
        GraphicsContext gc = getCanvas0().getGraphicsContext2D();

        // Create the PixelWriter
        PixelWriter pixelWriter = gc.getPixelWriter();

        // Define the PixelFormat
       PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();
       
       int cw = GameModel.cellWidth;
       int ch = GameModel.cellHeight;
       	
       	for(int i=0;i<width;i+=cw) {
       		for(int j=0;j<height;j+=ch) {
       		
       			//byte[] color = HelperRandom.conv(HelperRandom.getRndColor());
       			//color = MainGraphics.ave(color);
       			
       			Cell cell = model.getCellXY(i/cw,j/ch);
       			byte[] color = new byte[3];
       			if(cell!=null) {
       			int[] icolor = cell.getMyColor();
       			
       			color[0] = (byte) icolor[0];
       			color[1] = (byte) icolor[1];
       			color[2] = (byte) icolor[2];
       			//color[3] = (byte) icolor[3];
       			}
       			else {
       			color[0]=0;
       			color[1]=0;
       			color[2]=0;
       			//color[3]=(byte) 255;
       			}
       			pixels = MainGraphics.fillRectangleFast( pixels, i, j, width, cw, ch, color );	
                      
       		
       		}
       	}
       	
       	
        pixelWriter.setPixels(0, 0, width, height, pixelFormat, pixels, 0, width * 3);
        
       	
		
	}


	public Canvas getCanvas0() {
		
		return this.canvas0;
	}


	private boolean allDisabled(Button[] btns) {
		boolean result = true;
		for(int i=0;i<btns.length;i++) {
			if(btns[i].isDisable()) {
				result = false;
				break;
			}
		}
		
		return result;
	}
    
    

    private boolean allConfirmed(Button[] btns) {
		boolean result = true;
		for(int i=0;i<btns.length;i++) {
			if(btns[i].getText().equals("Confirm")) {
				return false;
			}
		}
		
		return result;
	}


	public void redrawBoardPro() {
     
     // width and height of the canvas
     //int width = (int)getCanvas().getWidth();
     //int height = (int)getCanvas().getHeight();

     // array to hold rgb value for every pixel
     byte[] pixels = new byte[this.canvas_width * this.canvas_height * 3];

     // Get the graphics context of the canvas
     GraphicsContext gc = getCanvas().getGraphicsContext2D();

     // Create the PixelWriter
     PixelWriter pixelWriter = gc.getPixelWriter();

     // Define the PixelFormat
     PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();
    int hx = model.hero.getIp().getX();
    int hy = model.hero.getIp().getY();
    
    int sw = hx-GameConstants.WIDTH_OF_WINDOW;
    if(sw<0) sw=0;
    int ew = hx+GameConstants.WIDTH_OF_WINDOW;
    if(ew>=model.im.cols) ew = model.im.cols-1;
    
    
    int sh = hy-GameConstants.HEIGHT_OF_WINDOW;
    if(sh<0) sh=0;
    int eh = hy+GameConstants.HEIGHT_OF_WINDOW;
    if(eh>=model.im.rows) eh = model.im.rows-1;
    
    ///System.out.println("wc="+ model.getWidthOfCols());
    
   // System.out.println("sw="+ sw);
  //  System.out.println("ew="+ ew);
   // System.out.println("sh="+ sh);
  //  System.out.println("eh="+ eh);
    
    It[][] its = new  It[GameConstants.WIDTH_OF_WINDOW*2][GameConstants.HEIGHT_OF_WINDOW*2];
    
   //int[] arr_x = new int[11];
   //int[] arr_y = new int[11];
   int n=0;
   int m=0;
    	for(int i=sw;i< ew ;i++)
         {
             
             for( int j= sh; j< eh; j++ )
             {
                 
                 ItStack elem = model.im.get(i,j);
                 
              //   System.out.println(elem.getStack().size());
                 
              //   System.out.println("n="+n);
              //   System.out.println("m="+m);
                 if(elem.getStack().size()>0) {
                 its[n][m] = new It(elem.getStack().peek());
                 //its[n][m] = (new It("point",new ImagePoint(n,m),new ColorPoint(color1,color2),"point"));
                   
                   
                 if(elem.getStack().size()>0) {
                 Color color1 = elem.getStack().peek().getColorPoint().getColor0();
                 Color color2 = elem.getStack().peek().getColorPoint().getColor1();
                
                if( color1 == null || color2 == null ) System.out.println("Error WITH colors: " + color1 +  " or " + color2 );
                  
              
                
                 // int red = (int) (c.getRed() * 255);
                 // int green = (int) (c.getGreen() * 255);
                 // int blue = (int) (c.getBlue() * 255);
                 
                 // byte[] col = new byte[3];
                 // col[0]=(byte)red;
                 // col[1]=(byte)green;
                 // col[2]=(byte)blue;
                 }
                 }
                 
                 m++;
                 
             }
             n++;
             m=0;
         }
    	
    	int t_widthOfCols = this.canvas_width / (GameConstants.WIDTH_OF_WINDOW*2);
    	int t_heightOfRows = this.canvas_height / (GameConstants.HEIGHT_OF_WINDOW*2);
    	
    //	System.out.println("t_widthOfCols="+t_widthOfCols);
    //	System.out.println("t_heightOfRows="+t_heightOfRows);
    	
    	for(int i=0;i<GameConstants.WIDTH_OF_WINDOW*2;i++) {
    	for(int j=0;j<GameConstants.HEIGHT_OF_WINDOW*2;j++) {
    		
    		Color color1 = Color.rgb(0, 0, 0);
    		Color color2 = Color.rgb(0,0,0);
    		if(its[i][j]==null) {
    		
    		}
    		else {
    		  color1 = its[i][j].getColorPoint().getColor0();
    		 color2 = its[i][j].getColorPoint().getColor1();
    		}
    		
            pixels = MainGraphics.fillRectangleFastOdd( pixels,
                    i* t_widthOfCols ,
                    j* t_heightOfRows,
                    this.canvas_width,
                    t_widthOfCols ,
                    t_heightOfRows, HelperRandom.conv(color1));	
                   
                    pixels = MainGraphics.fillRectangleFastEven( pixels,
                    i* t_widthOfCols ,
                    j* t_heightOfRows,
                    this.canvas_width,
                    t_widthOfCols ,
                    t_heightOfRows, HelperRandom.conv(color2));	
         
                    //}
                    //else {
                    //System.out.println("x="+i+", y="+j+" sz=0");
                    //}	
    		
    	}
    	}
    	
    	
    	
    	
    	
    	
    	
         
    //draw items here
 //   ArrayList<Item> items = ModelMap.getRealItems().getItems();
 //   for(int i=0;i<items.size();i++) {
//        Item item = items.get(i);
//        //if( item.getId().equals(id) ) return item;
//        
//        ImagePoint ip = item.getIp();
//        pixels = MainGraphics.fillRectangleFast( pixels,
//                                            ip.getX()*model.getWidthOfCols(),
//                                            ip.getY()*model.getHeightOfRows(),
//                                            this.canvas_width,
//                                            model.getWidthOfCols(),
//                                            model.getHeightOfRows(), MainGraphics.conv(item.getColorPoint().getColor1())
//                                            ); 
//        
//        
//        
//        
 //   }
    	
    	
    	
//         if(model.hero.undefined==false) {
//             ImagePoint ip = model.hero.getIp();
//             pixels = MainGraphics.fillRectangleFast( pixels,
//                                                 ip.getX()*model.getWidthOfCols(),
//                                                 ip.getY()*model.getHeightOfRows(),
//                                                 this.canvas_width,
//                                                 model.getWidthOfCols(),
//                                                 model.getHeightOfRows(), MainGraphics.conv(Color.RED)
//                                                 ); 
//         
//         }
//         
         if(model.isCursorUndefined()==false) {
         
        	 ImagePoint ip = model.cursor.getIp();
             int cx = ip.getX();
             int cy = ip.getY();
             if(cx >= sw && cx < ew) {
            	 if(cy >= sh && cy < eh) {

            		 pixels = MainGraphics.fillRectangleFast( pixels,
                                (cx-sw)*t_widthOfCols,
                                (cy-sh)*t_heightOfRows,
                                this.canvas_width,
                                t_widthOfCols,
                                t_heightOfRows, HelperRandom.conv(model.cursor.getColorPoint().getColor1())
                             ); 
       	 
                 } 
             }
             
                     
             
         
         }
      
    	
    	
    	
    	
         /////////////////////////////////
         // ImagePoint ip = GameModel.getCursorPos();
         // if( ip.undefined == false  ) {
             
              
             
                 // pixels = MainGraphics.fillRectangleFast( 
                                                 // pixels,
                                                 // ip.x*GameModel.width_cols,
                                                 // ip.y*GameModel.height_rows,
                                                 // this.canvas_width,
                                                 // GameModel.width_cols,
                                                 // GameModel.height_rows, MainGraphics.conv(GameModel.getCursorColor()) 
                 // );	
         // }
         
         ////////////////////////////////
         
         //model.getInventory().toList(null); 
         
         
         pixelWriter.setPixels(0, 0, this.canvas_width, this.canvas_height, pixelFormat, pixels, 0, this.canvas_width * 3);
         
        // lab1.setText("X: "+GameModel.heroPositionX + " Y: " + GameModel.heroPositionY + " Gold: "+GameModel.gold_counter+"      ");
         
        // this.labPlace.setText("Place: "+GameModel.getHeroPlace());
         
         //imPointChange();
 } 
    
   

   public void rem_rem_rem__redrawBoard() {
    
    // width and height of the canvas
    //int width = (int)getCanvas().getWidth();
    //int height = (int)getCanvas().getHeight();

    // array to hold rgb value for every pixel
    byte[] pixels = new byte[this.canvas_width * this.canvas_height * 3];

    // Get the graphics context of the canvas
    GraphicsContext gc = getCanvas().getGraphicsContext2D();

    // Create the PixelWriter
    PixelWriter pixelWriter = gc.getPixelWriter();

    // Define the PixelFormat
    PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();
   int hx = model.hero.getIp().getX();
   int hy = model.hero.getIp().getY();
   
   int sw = hx-5;
   if(sw<0) sw=0;
   int ew = hx+5;
   if(ew>=model.im.cols) ew = model.im.cols-1;
   
   
   int sh = hy-5;
   if(sh<0) sh=0;
   int eh = hy+5;
   if(eh>=model.im.rows) eh = model.im.rows-1;
   System.out.println("wc="+ model.getWidthOfCols());
  int[] arr_x = new int[11];
  int[] arr_y = new int[11];
  
   	for(int i=sw;i< ew ;i++)
        {
            
            for( int j= sh; j< eh; j++ )
            {
                
                ItStack elem = model.im.get(i,j);
                if(elem.getStack().size()>0) {
                Color color1 = elem.getStack().peek().getColorPoint().getColor0();
                Color color2 = elem.getStack().peek().getColorPoint().getColor1();
               
               if( color1 == null || color2 == null ) System.out.println("Error WITH colors: " + color1 +  " or " + color2 );
                     
                // int red = (int) (c.getRed() * 255);
                // int green = (int) (c.getGreen() * 255);
                // int blue = (int) (c.getBlue() * 255);
                
                // byte[] col = new byte[3];
                // col[0]=(byte)red;
                // col[1]=(byte)green;
                // col[2]=(byte)blue;
                
                pixels = MainGraphics.fillRectangleFastOdd( pixels,
                i*model.getWidthOfCols(),
                j*model.getHeightOfRows(),
                this.canvas_width,
                model.getWidthOfCols(),
                model.getHeightOfRows(), HelperRandom.conv(color1));	
               
                pixels = MainGraphics.fillRectangleFastEven( pixels,
                i*model.getWidthOfCols(),
                j*model.getHeightOfRows(),
                this.canvas_width,
                model.getWidthOfCols(),
                model.getHeightOfRows(), HelperRandom.conv(color2));	
     
                }
                else {
                System.out.println("x="+i+", y="+j+" sz=0");
                }
       
            }
        }
   
   //draw items here
//   ArrayList<Item> items = ModelMap.getRealItems().getItems();
//   for(int i=0;i<items.size();i++) {
//       Item item = items.get(i);
//       //if( item.getId().equals(id) ) return item;
//       
//       ImagePoint ip = item.getIp();
//       pixels = MainGraphics.fillRectangleFast( pixels,
//                                           ip.getX()*model.getWidthOfCols(),
//                                           ip.getY()*model.getHeightOfRows(),
//                                           this.canvas_width,
//                                           model.getWidthOfCols(),
//                                           model.getHeightOfRows(), MainGraphics.conv(item.getColorPoint().getColor1())
//                                           ); 
//       
//       
//       
//       
//   }
       
            ImagePoint ip = model.hero.getIp();
            pixels = MainGraphics.fillRectangleFast( pixels,
                                                ip.getX()*model.getWidthOfCols(),
                                                ip.getY()*model.getHeightOfRows(),
                                                this.canvas_width,
                                                model.getWidthOfCols(),
                                                model.getHeightOfRows(), HelperRandom.conv(Color.RED)
                                                ); 
        
       
        
        if(model.isCursorUndefined()==false) {
            ImagePoint ip1 = model.cursor.getIp();
            pixels = MainGraphics.fillRectangleFast( pixels,
                                                ip1.getX()*model.getWidthOfCols(),
                                                ip1.getY()*model.getHeightOfRows(),
                                                this.canvas_width,
                                                model.getWidthOfCols(),
                                                model.getHeightOfRows(), HelperRandom.conv(model.cursor.getColorPoint().getColor1())
                                                ); 
        
        }
     
        /////////////////////////////////
        // ImagePoint ip = GameModel.getCursorPos();
        // if( ip.undefined == false  ) {
            
             
            
                // pixels = MainGraphics.fillRectangleFast( 
                                                // pixels,
                                                // ip.x*GameModel.width_cols,
                                                // ip.y*GameModel.height_rows,
                                                // this.canvas_width,
                                                // GameModel.width_cols,
                                                // GameModel.height_rows, MainGraphics.conv(GameModel.getCursorColor()) 
                // );	
        // }
        
        ////////////////////////////////
        
        //model.getInventory().toList(null); 
        
        
        pixelWriter.setPixels(0, 0, this.canvas_width, this.canvas_height, pixelFormat, pixels, 0, this.canvas_width * 3);
        
       // lab1.setText("X: "+GameModel.heroPositionX + " Y: " + GameModel.heroPositionY + " Gold: "+GameModel.gold_counter+"      ");
        
       // this.labPlace.setText("Place: "+GameModel.getHeroPlace());
        
        //imPointChange();
} 
   
   public void   imPointChange() {
	    
	    // width and height of the canvas
	    //int width = (int)getCanvas().getWidth();
	    //int height = (int)getCanvas().getHeight();

	    // array to hold rgb value for every pixel
	  //  byte[] pixels = new byte[this.canvas_width * this.canvas_height * 3];

	    // Get the graphics context of the canvas
	    GraphicsContext gc = getCanvas().getGraphicsContext2D();

	    
	    
	    
	  WritableImage snap = gc.getCanvas().snapshot(null, null);
      
      for (int y = 0; y < model.im.rows; y++) {
          for (int x = 0; x < model.im.cols; x++) {
              
              Color c1  =  snap.getPixelReader().getColor(x*this.model.getWidthOfCols(), y*this.model.getHeightOfRows());
              Color c2  =  snap.getPixelReader().getColor(x*this.model.getWidthOfCols()+1, y*this.model.getHeightOfRows());
              
              //model.im.set(x,y, new ColorPoint(c1,c2));
     
          }
      }
	    
	    
//	    
//	    
//	    
//	    
//	    
//	    // Create the PixelWriter
//	    PixelWriter pixelWriter = gc.getPixelWriter();
//
//	    // Define the PixelFormat
//	    PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();
//	   
//	   for(int i=0;i< model.im.cols;i++)
//	        {
//	            
//	            for(int j=0;j<  model.im.rows;j++)
//	            {
//	                ColorPoint cp = 
//	                model.im.set(i,j, cp);
//	                
//	       
//	            }
//	        }
	   
	} 


    
    // public static void defineHeroPositionAndSetHero() {
                               
        // TextInputDialog dialog = new TextInputDialog("8,8");

        // dialog.setTitle("Entering hero destination");
        // dialog.setHeaderText("Enter hero destination as x,y:");
        // dialog.setContentText("Here:");
         
        // Optional<String> result = dialog.showAndWait();
         
        // result.ifPresent(name -> {
            
            // String[] res = name.split("\\,");
     // for (int x=0; x<res.length; x++)
         // System.out.println(res[x]);
            // int nx=0;
            // int ny=0;
            // try {
                
            // nx=Integer.parseInt(res[0]);
            // ny=Integer.parseInt(res[1]);
            // }
            // catch(Exception ex) {
                // nx = this.model.im.cols/2;
                // ny = this.model.im.rows/2;
            // }
            // // ImagePointColor icp1 = new ImagePointColor(nx,ny,Color.RED);
            
            // // GameModel.heroPositionX = icp1.x;
            // // GameModel.heroPositionY = icp1.y;
            // // GameModel.underHeroColor =  GameModel.im.get(icp1.x,icp1.y);
            // // MainGraphics.setHero(  GameModel.im, GameModel.heroPositionX, GameModel.heroPositionY ); 
            
        // });
                                
                     
    // }
    
    
    
    
    
    
    
    
    
     private java.awt.Image getImageFromClipboard() {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                try {
                    return (java.awt.Image) transferable.getTransferData(DataFlavor.imageFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        private javafx.scene.image.Image awtImageToFX(java.awt.Image image) throws Exception {
            if (!(image instanceof RenderedImage)) {
                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                        BufferedImage.TYPE_INT_ARGB);
                Graphics g = bufferedImage.createGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();

                image = bufferedImage;
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) image, "png", out);
            out.flush();
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            return new javafx.scene.image.Image(in);
        }


   
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
        
// for example

    public void changeFont() {
        StringBuilder sb = new StringBuilder();
       
            sb.append("<p style='font-family: ")
              .append("Tahoma")
              .append(";font-size:")
              .append("100%;")
              .append("'>This is Sample Text</p>");
       
        sb.toString();
    
    }
    
////////////////////////
    
    
    public void showAlertWithMessage(String message) {
    
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Well done, commander");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @SuppressWarnings("unused")
	private void useStyles(RadioButton rb) {
            rb.getStylesheets().add(getClass().getResource("../res/css/radio.css").toExternalForm());
    }
    
    @SuppressWarnings("unused")
	private byte getRandomByte() {
        byte[] b = new byte[1];
        new Random().nextBytes(b);
        return b[0];
    }
    
    
    
    

    
    // private void scale_plus(int n) throws Exception {
        // int cols = GameModel.im.cols+n;
        // int rows = GameModel.im.rows+n;
        // // String s1 = txt1.getText().toString();   
        // // String s2 = txt2.getText().toString();     
        // // if (s1.matches("^[0-9]+$") && s2.matches("^[0-9]+$") ) 
        // // {
            // // cols = Integer.parseInt(s1)+n;
            // // rows = Integer.parseInt(s2)+n;
            // // txt1.setText(""+cols);
            // // txt2.setText(""+rows);
            // // reload();
        // // }
        // justChangeSizeOfArrCell2d(cols, rows);
        // redrawBoard();
        
    // }
    
 

// private Color[][] clone_temporary_arr() {


      
        // int cols = GameModel.im.cols;      //get_settings('WN');
        // int rows = GameModel.im.rows;      //get_settings('WM');
           
        // //my 2d array initialize
       // Color[][] res = new Color[cols][rows];
    
       // //for(int i=0;i<cols;i++) arr_cell_2d[i] = new int[][3];
      
        
          // for(int i=0;i<cols;i++)
            // {
                
                // for(int j=0;j<rows;j++)
                // {
                    // res[i][j] = GameModel.im.get(i,j);
                    
                     
                // }
            // }
        
            // return res;
    // }
    
    
    
// private Color[][] paint(Color[][] temporary_arr,int i,int j,int N,int M) {
   // if((i>0 && i<N-1) && (j>0) && (j<M-1)) temporary_arr[i][j] = MainGraphics.cloneColor(GameModel.color_when_painted);
   // return temporary_arr; 
// }

// private Color[][] invis(Color[][] temporary_arr,int i,int j,int N,int M) {
    // if((i>0 && i<N-1)&& (j>0) && (j<M-1)) temporary_arr[i][j] = MainGraphics.cloneColor(GameModel.color_empty);
    // return temporary_arr;
// }




// private void refreshGlobalArr2d(Color[][] temporary_arr){
 
  
    
   // for(int i=0;i<GameModel.im.cols;i++)
        // {
            
            // for(int j=0;j<GameModel.im.rows;j++)
            // {
                // Color c = temporary_arr[i][j];
                // GameModel.im.set(i,j,c);
            // }
        // }
         
// }
    

// private void step() {

   // int N = GameModel.im.cols;
   // int M = GameModel.im.rows;     
   // Color[][] temporary_arr = clone_temporary_arr();
    // GraphicsContext gc = getCanvas().getGraphicsContext2D();
        // WritableImage snap = gc.getCanvas().snapshot(null, null);
        // PixelReader pr =  snap.getPixelReader();
        
   // for(int i=0;i< GameModel.im.cols;i++)
        // {
            
            // for(int j=0;j<GameModel.im.rows;j++)
            // {
                 
              
              // int cnt = countNear(GameModel.im.colors_array,i,j,GameModel.im.cols,GameModel.im.rows);
             
             // if (cellEmptyXY(pr,i,j)) {
               
              
                // if(cnt==3)     temporary_arr=paint(temporary_arr,i,j,N,M);
                 
             // }
             // else {
                // if(!(( cnt==2)||(cnt==3))) {
                        // temporary_arr= invis (temporary_arr,i,j,N,M);
                // }                    
             // }
             
             
       
            // }
        // }
       
     // refreshGlobalArr2d(temporary_arr);
     // redrawBoard();
// }

      
    
    
    
    
    // public void justChangeSizeOfArrCell2d(int cols, int rows) throws Exception {
    
        
        // if(cols%2==1) cols++;
        // if(rows%2==1) rows++;        
        
        // Color[][] copy_arr_cell_2d = new Color[cols][rows];
        
        // int r = (cols-GameModel.im.cols)/2;
        
        // for(int i=r;i<cols;i++)
            // {
                
                // for(int j=r;j<rows;j++)
                // {
                  
                    // try{
                    // copy_arr_cell_2d[i][j] = GameModel.im.get(i-r,j-r);
                    // }
                    // catch(Exception ex) {
                    // }
                     
                // }
            // }
            
             // for(int i=0;i<cols;i++)
            // {
                
                // for(int j=0;j<rows;j++)
                // {
                  // if( copy_arr_cell_2d[i][j]==null)  copy_arr_cell_2d[i][j] = MainGraphics.cloneColor(GameModel.color_empty);
                // }
            // }
        
            // //this.arr_cell_2d = copy_arr_cell_2d;
            
            // GameModel.setColorsArray(copy_arr_cell_2d,cols,rows); 
              
    // }
    
       
    // public void drawWithPixelFormat() {
    // // width and height of the canvas
    // int width = (int)getCanvas().getWidth();
    // int height = (int)getCanvas().getHeight();

    // // array to hold rgb value for every pixel
    // byte[] pixels = new byte[height * width * 3];

    // // Get the graphics context of the canvas
    // GraphicsContext gc = getCanvas().getGraphicsContext2D();

    // // Create the PixelWriter
    // PixelWriter pixelWriter = gc.getPixelWriter();

    // // Define the PixelFormat
    // PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();

    // for (int y = 0; y < height; y++) {
        // for (int x = 0; x < width; x++) {
            
            // int i = y * width * 3 + x * 3;
            
            // byte val_r = getRandomByte();
            // byte val_g = getRandomByte();
            // byte val_b = getRandomByte();
            
            // pixels[i] = val_r;
            // pixels[i + 1] = val_g;
            // pixels[i + 2] = val_b;
        // }
    // }
    
    // pixelWriter.setPixels(0, 0, width, height, pixelFormat, pixels, 0, width * 3);
// }

    // private byte[] getRandomRGBColor() {
        
        // byte[] col = new byte[3];
        // byte val_r = getRandomByte();
        // byte val_g = getRandomByte();
        // byte val_b = getRandomByte();
        // col[0] = val_r;
        // col[1] = val_g;
        // col[2] = val_b;
        // return col;
    // }
    
   // private int[] getRandomIntRGBColor() {
        
        // int[] col = new int[3];
        // int val_r = getRandomInt(256);
        // int val_g = getRandomInt(256);
        // int val_b = getRandomInt(256);
        // col[0] = val_r;
        // col[1] = val_g;
        // col[2] = val_b;
        // return col;
    // }
    
    @SuppressWarnings("unused")
	private Color getColorFromCell(PixelReader pr, int i, int j) {
    
        return pr.getColor(i, j);    
        
    
    }
    
    ////////////////////////////
////// for fast loading https://stackoverflow.com/questions/6319465/fast-loading-and-drawing-of-rgb-data-in-bufferedimage?rq=1
//
// public void processFrame(byte[] frame, int width, int height)
// {
   // DataBuffer videoBuffer = new DataBufferByte(frame,frame.length);
   // BufferedImage currentImage = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
   // ComponentSampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE,width,height,3,width*3,new int[] {2,1,0});
   // Raster raster = Raster.createRaster(sampleModel,videoBuffer,null);
   // currentImage.setData(raster);
// }
/////////////////
    
    
    
    
    
 
    
}


// /*
 // * To change this license header, choose License Headers in Project Properties.
 // * To change this template file, choose Tools | Templates
 // * and open the template in the editor.
 // */
// package imagesget;

// import java.io.StringWriter;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import javafx.application.Application;
// import javafx.beans.value.ChangeListener;
// import javafx.beans.value.ObservableValue;
// import javafx.concurrent.Worker;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.StackPane;
// import javafx.scene.web.WebEngine;
// import javafx.scene.web.WebView;
// import javafx.stage.Stage;
// import javax.xml.transform.OutputKeys;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerConfigurationException;
// import javax.xml.transform.TransformerException;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;
// import org.w3c.dom.Document;
// import org.w3c.dom.NodeList;




// /**
 // *
 // * @author biznis
 // */
// /**
 // *
 // * @author biznis
 // */
// public class ImagesGet extends Application {

    // /**
     // * @param args the command line arguments
     // */
    // @Override
    // public void start(Stage primaryStage) throws Exception {


        // StackPane root = new StackPane();
        // // create a HBox to hold 2 vboxes        
          // HBox hbox = new HBox(10);
        // // create a vbox with a textarea that grows vertically
       // // HBox vbox = new VBox(10);
        // //Label label1 = new Label("");
        // final WebView browser = new WebView();
        // final WebEngine wb = browser.getEngine();

    // //grid.add(new Label("Input Url: "), 0, 0);
   // // grid.add(notification, 1, 0);
        // wb.load("http://epaper.timesgroup.com/Olive/ODN/TheEconomicTimes/#");
        // wb.getLoadWorker().stateProperty().addListener(
            // new ChangeListener<Worker.State>() {
                // @Override
                // public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                    // if (newState == Worker.State.SUCCEEDED) {
                        // Document doc =   wb.getDocument();
                        // try {
                            // Transformer transformer = TransformerFactory.newInstance().newTransformer();
                            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                            // transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                            // transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                            // transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                            // transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                            // StringWriter stringWriter = new StringWriter();
                            // try {
                                // transformer.transform(new DOMSource(doc),
                                        // new StreamResult(stringWriter));
                            // } catch (TransformerException ex) {
                                // Logger.getLogger(ImagesGet.class.getName()).log(Level.SEVERE, null, ex);
                            // }
                            // String xml1 = stringWriter.getBuffer().toString();
                            // System.out.println(xml1);

// NodeList anchors = doc.getElementsByTagName("img");
// System.out.println(anchors);

                        // }catch (TransformerConfigurationException ex) {
                            // Logger.getLogger(ImagesGet.class.getName()).log(Level.SEVERE, null, ex);
                        // } 
                    // }
                // }
            // });
    // }
    // public static void main(String[] args) {
        // Application.launch(args);
    // }
// }



/******************

window.onload = function(){
     
	var CLIPBOARD = new CLIPBOARD_CLASS("canvas", true);
	var canvas = document.getElementById("canvas");
    
    fillGlobalArrCell2d();
    
    canvas.onclick = function(e){
    
    var point = get_selected_seed(e);
 console.log(get_selected_seed(e));   
   
   if(cellEmpty(e)) fillCell_pro(e);
   else  emptyCell_pro(e);
   //e.preventDefault();
	redrawBoard();

    }
    
   //  getPartOfImageData(im,x,y,w,h)
    
    // test(); 
    
   redrawBoard();
	
}
function cellEmptyXY(n,m){
 return compareColors(getColorFromCell(n,m),global_color_empty)
}
function cellEmpty(e) {
    var nm = get_selected_seed(e);
    return compareColors(getColorFromCell(nm[2],nm[3]),global_color_empty)
}

function get_settings() {
 
       var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	//imgData0 = ctx.getImageData(0,0, canvas.width, canvas.height);
    
 var cols =  Number( document.getElementById("cols").value);
    var rows = Number( document.getElementById("rows").value);
    var N = parseInt( canvas.width / cols);
   // alert("canvas.cols = " + " N="+N );
    var M = parseInt( canvas.height / rows);
   // alert("canvas.rows = " + " M="+M );
    var WN=  parseInt( canvas.width / N);
    var WM=parseInt( canvas.height / M);
    var obj = {}
    obj['cols'] = cols; 
    obj['rows'] = rows;
    obj['N'] = N; 
    obj['M'] = M;
    obj['WN'] = WN; 
    obj['WM'] = WM;
    return obj;
}

function redrawBoard() {
    
       var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	imgData0 = ctx.getImageData(0,0, canvas.width, canvas.height);

   var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
    
   for(var i=0;i<N;i++)
        {
            
            for(var j=0;j<M;j++)
            {
                var nm =  global_arr_cell_2d[i][j];
                imgData0 =   fillRectangleFast(imgData0,i*WN,j*WM,WN,WM, nm);	
     
      
       
            }
        }
        
         ctx.putImageData(imgData0,0,0); 
}

var global_arr_cell_2d = null;
var global_color_when_painted = [255,0,255,255];
var global_color_empty = [100,0,0,255];

function ret_array(arr) {
for(var i=0;i<arr.length;i++) arr[i] = global_color_when_painted;
    return arr;
}

function update_global_arr2d(){
    fillGlobalArrCell2d();
    redrawBoard();
}

function fillGlobalArrCell2d() {
    
       var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	imgData0 = ctx.getImageData(0,0, canvas.width, canvas.height);
   
   var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
   
    //my 2d array initialize
   global_arr_cell_2d = new Array(N);
    for(var i=0;i<N;i++) global_arr_cell_2d[i] = ret_array(new Array(M));
        
            
     
    // try { 
    
        // for(var i=0;i<N;i++)
        // {
            
            // for(var j=0;j<M;j++)
            // { 

                // var idx = ( imgData0.width * (i*WN+1) + j*WM+1) << 2;	
                
                // var arr0 = [];
                // arr0[0] = imgData0.data[idx]+100 ;	
                // arr0[1] = imgData0.data[idx+1] ;	
                // arr0[2] = imgData0.data[idx+2] ;
               // arr0[3] = imgData0.data[idx+3]+200   ;
               
               // global_arr_cell_2d[i][j] = new Array(arr0[0],arr0[1],arr0[2],arr0[3]);
               
               // //if(compareColors(arr0,[0,0,0,0]))  throw 'myException'; 
            // }
        // }
    
    // } catch(e) {
        // console.log(e);
    // }
    
      for(var i=0;i<N;i++)
        {
            
            for(var j=0;j<M;j++)
            {
                 global_arr_cell_2d[i][j]= global_color_empty;
                //imgData0 =   fillRectangleFast(imgData0,i*WN,j*WM,WN,WM, nm);	
     
      
       
            }
        }
        
         //ctx.putImageData(imgData0,0,0); 
}





function get_selected_seed(e)
{
	e = (e) ? e : event;   
	if(e.button == 0 || e.button==2) 
	{
		
        var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
        
		var x = e.offsetX==undefined?e.layerX:e.offsetX;
		var y = e.offsetY==undefined?e.layerY:e.offsetY;
		
		
		var n = (x/WN|0);//-tw;
		var m = (y/WM|0);//-th;
		
		//console.log("x="+x+" y="+y);
		console.log("n="+n+" m="+m);
		
		return [x,y,n,m];
		
	}
}

function fillCell(e){
    
    	var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	var imageData = ctx.getImageData(0,0, canvas.width, canvas.height);
    //imageData = fillRectangleFast(imageData, 0, 0, 20, 20, [255,0,0,0] );
    //ctx.putImageData(imageData,0,0);
     
     
    var nm = get_selected_seed(e);
    var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
     
     imgData2 = fillRectangleFast(imageData,nm[2]*WN,nm[3]*WM,WN,WM, [ 0,100 ,255,255]);	
     
      ctx.putImageData(imgData2,0,0);  
    
    
}    

function fillCell_pro(e){
    
    	var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	var imageData = ctx.getImageData(0,0, canvas.width, canvas.height);
    //imageData = fillRectangleFast(imageData, 0, 0, 20, 20, [255,0,0,0] );
    //ctx.putImageData(imageData,0,0);
     
     
    var nm = get_selected_seed(e);
 var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
    
   global_arr_cell_2d[nm[2]][nm[3]] = global_color_when_painted; 
 //     return getColorArrayFromImageData (imgData0, nm[0], nm[1])
     
//     imgData2 = fillRectangleFast(imageData,nm[2]*WN,nm[3]*WM,WN,WM, [ 0,100 ,255,255]);	
     
//      ctx.putImageData(imgData2,0,0);  
    
    
}

function getColorFromCell(i,j) {
    var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	var imageData = ctx.getImageData(0,0, canvas.width, canvas.height);
 var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
       
   return getColorArrayFromImageData(imageData, i*WN+1, j*WM+1);
}

function emptyCell_pro(e){
    
    	var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	var imageData = ctx.getImageData(0,0, canvas.width, canvas.height);
    //imageData = fillRectangleFast(imageData, 0, 0, 20, 20, [255,0,0,0] );
    //ctx.putImageData(imageData,0,0);
     
     
    var nm = get_selected_seed(e);
 var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
    
   global_arr_cell_2d[nm[2]][nm[3]] = global_color_empty; 
 //     return getColorArrayFromImageData (imgData0, nm[0], nm[1])
     
//     imgData2 = fillRectangleFast(imageData,nm[2]*WN,nm[3]*WM,WN,WM, [ 0,100 ,255,255]);	
     
//      ctx.putImageData(imgData2,0,0);  
    
    
}

function rule_if_need_paint(temporary_arr,i,j,N,M) {
    
    if(i<1) return false;
    if(j<1) return false;
    
    if((i<N-1) && (j<M-1)) {
    
        var result = false;
        //012
        //345
        //678
        var n=0;
        var color0 = temporary_arr[i-1][j-1];
        var color1 = temporary_arr[i][j-1];
        var color2 = temporary_arr[i+1][j-1];
        var color3 = temporary_arr[i-1][j];
        var color4 = temporary_arr[i][j];
        var color5 = temporary_arr[i+1][j];
        var color6 = temporary_arr[i-1][j+1];
        var color7 = temporary_arr[i][j+1];
        var color8 = temporary_arr[i+1][j+1];
        
        if(compareColors(color0,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color1,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color2,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color3,global_color_when_painted)) {
            n++;
        } 
        
          if(compareColors(color5,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color6,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color7,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color8,global_color_when_painted)) {
            n++;
        } 
        
        if(n==3 && cellEmptyXY(i,j)) result = true;
        
       
        return result;       
    }
    
    
}


function countNear(temporary_arr,i,j,N,M) {
    
    if(i<1) return 0;
    if(j<1) return 0;
    
    if((i<N-1) && (j<M-1)) {
    
        var result = false;
        //012
        //345
        //678
        var n=0;
        var color0 = temporary_arr[i-1][j-1];
        var color1 = temporary_arr[i][j-1];
        var color2 = temporary_arr[i+1][j-1];
        var color3 = temporary_arr[i-1][j];
        var color4 = temporary_arr[i][j];
        var color5 = temporary_arr[i+1][j];
        var color6 = temporary_arr[i-1][j+1];
        var color7 = temporary_arr[i][j+1];
        var color8 = temporary_arr[i+1][j+1];
        
        if(compareColors(color0,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color1,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color2,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color3,global_color_when_painted)) {
            n++;
        } 
        
          if(compareColors(color5,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color6,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color7,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color8,global_color_when_painted)) {
            n++;
        } 
        
        
        return n;       
    }
    
    return 0;
    
}

function rule_if_need_invis(temporary_arr,i,j,N,M) {
    
      if(i<1) return true;
    if(j<1) return true;
    
    if((i<N-1) && (j<M-1)) {
    
        var result = false;
        //012
        //345
        //678
        var n=0;
        var color0 = temporary_arr[i-1][j-1];
        var color1 = temporary_arr[i][j-1];
        var color2 = temporary_arr[i+1][j-1];
        var color3 = temporary_arr[i-1][j];
        var color4 = temporary_arr[i][j];
        var color5 = temporary_arr[i+1][j];
        var color6 = temporary_arr[i-1][j+1];
        var color7 = temporary_arr[i][j+1];
        var color8 = temporary_arr[i+1][j+1];
        
        if(compareColors(color0,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color1,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color2,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color3,global_color_when_painted)) {
            n++;
        } 
        
          if(compareColors(color5,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color6,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color7,global_color_when_painted)) {
            n++;
        } 
        
         if(compareColors(color8,global_color_when_painted)) {
            n++;
        } 
        
        if(((n==2) ||(n==3)) && !cellEmptyXY(i,j)) result = true;
        
       
        return result;       
    }
    
    
}


function paint(temporary_arr,i,j,N,M) {
   if((i>0 && i<N-1) && (j>0) && (j<M-1)) temporary_arr[i][j] = global_color_when_painted;
   return temporary_arr; 
}

function invis(temporary_arr,i,j,N,M) {
    if((i>0 && i<N-1)&& (j>0) && (j<M-1)) temporary_arr[i][j] = global_color_empty;
    return temporary_arr;
}

function step() {

       var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	imgData0 = ctx.getImageData(0,0, canvas.width, canvas.height);
  
  var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
   
   var temporary_arr = clone_temporary_arr();
    
   for(var i=0;i<N;i++)
        {
            
            for(var j=0;j<M;j++)
            {
                 
              
              var cnt = countNear(global_arr_cell_2d,i,j,N,M);
             
             if (cellEmptyXY(i,j)) {
               
              
                if(cnt===3)     temporary_arr=paint(temporary_arr,i,j,N,M);
                 
             }
             else {
                if(!(( cnt===2)||(cnt===3))) {
                        temporary_arr= invis (temporary_arr,i,j,N,M);
                }                    
             }
             
             
       
            }
        }
       
     refreshGlobalArr2d(temporary_arr);
     redrawBoard();
}
function refreshGlobalArr2d(temporary_arr){
 
  var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
    
   for(var i=0;i<N;i++)
        {
            
            for(var j=0;j<M;j++)
            {
                var t = temporary_arr[i][j];
                global_arr_cell_2d[i][j] = [t[0],t[1],t[2],t[3]];
            }
        }
         
}
function clone_temporary_arr(){
      
            
  var N = get_settings()['N'];
   var M = get_settings()['M'];
   var WN = get_settings()['WN'];
   var WM = get_settings()['WM'];
   var temporary_arr = new Array(N);
    for(var i=0;i<N;i++) temporary_arr[i] = ret_array(new Array(M));
    
   for(var i=0;i<N;i++)
        {
            
            for(var j=0;j<M;j++)
            {
                var t = global_arr_cell_2d[i][j];
                temporary_arr[i][j] = [t[0],t[1],t[2],t[3]];
            }
        }
        
        return temporary_arr;
}

function whenPastingFinished(img)
{
	var canvas = document.getElementById("canvas");
	canvas.width = img.width;
	canvas.height = img.height;
	var context = canvas.getContext("2d");
	context.drawImage(img,0,0);	
	 
	 							
}

function getPartOfImageData(im,x,y,w,h)
{
	var canvas = document.createElement('canvas');
	canvas.width = im.width;
	canvas.height = im.height;
	var context = canvas.getContext("2d");
	context.putImageData(im,0,0);
	return context.getImageData(x, y, w, h);
}

function compareColors(color,color2)
{
	if(
			(color2[0]==color[0]) && 
			(color2[1]==color[1]) && 
			(color2[2]==color[2]) && 
			(color2[3]==color[3]) 
							
						
		)
		{
			return true;
			
		}	
		
		return false;
}

function getColorArrayFromImageData(imgData0, x, y)
{
	
		var idx = ( imgData0.width * y + x) << 2;	
		
		var arr0 = [];
		arr0[0] = imgData0.data[idx];	
		arr0[1] = imgData0.data[idx+1];	
		arr0[2] = imgData0.data[idx+2];
		arr0[3] = imgData0.data[idx+3];	
		
		return arr0;
}
function cloneImageDataData(data)
{
	var data1 = [];
	for(var j=0;j<data.length;j++)
	{
		data1.push(data[j]);
	}
	return data1;
}
 
function fillRectangleFast(imgData2, x, y, n, m, col )
{
	
	for(var j=y;j<y+m;j++)
	{
		for(var i=x;i<x+n;i++)
		{
			var idx2 = (imgData2.width * j + i ) << 2;
			imgData2.data[idx2]=col[0];
			imgData2.data[idx2+1]=col[1];
			imgData2.data[idx2+2]=col[2];
			imgData2.data[idx2+3]=col[3];
			
		}
	}
	
	return imgData2;
}	


function setColorArrayToImageData(imgData0, arr0, x, y, w, h)
{
    var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	imgData0 = ctx.getImageData(0,0, canvas.width, canvas.height);
    for(var i=x;i<x+w;i++)
	{
		
		for(var j=y;j<y+h;j++)
        { 

        
            var idx = ( imgData0.width * i + j) << 2;	
            
            var arr0 = [];
            imgData0.data[idx]=arr0[0]  ;	
            imgData0.data[idx+1]=  arr0[1];	
            imgData0.data[idx+2]= arr0[2] ;
           imgData0.data[idx+3] = arr0[3] ;	
		}
    }
    ctx.putImageData(imgData0,0,0);
   return imgData0;
}

 	******************/