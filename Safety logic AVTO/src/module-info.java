module pixels2DViewFromAbove {
	requires java.desktop;
	requires java.sql;
requires javafx.controls;
requires javafx.base;
requires javafx.graphics;
	
	opens pixeleditor to javafx.graphics, javafx.fxml;
	
}