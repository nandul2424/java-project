<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Separator?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<BorderPane xmlns:fx="http://javafx.com/fxml/1" xmlns="http://javafx.com/javafx/23.0.1" fx:controller="javafxapplication7.FXMLDocumentController">
    
    <!-- Sidebar -->
    <left>
        <VBox alignment="TOP_CENTER" prefWidth="200" spacing="20" style="-fx-background-color: #003f5c;" BorderPane.alignment="CENTER">
            <padding>
                <Insets bottom="30" left="20" right="20" top="30" />
            </padding>

            <Label text="🌊 SafeSea" textFill="WHITE">
                <font>
                    <Font name="Verdana" size="24" />
                </font>
            </Label>

            <Separator />
            <Button fx:id="btnSurfing" onAction="#handleSurfingAction" style="-fx-text-fill: white; -fx-background-color: transparent;" text="Destinations" />
            <Button fx:id="btnDiving" onAction="#handleDivingAction" style="-fx-text-fill: white; -fx-background-color: transparent;" text="Trip Planner" />
            <Button fx:id="btnAbout" onAction="#handleAboutAction" style="-fx-text-fill: white; -fx-background-color: transparent;" text="Travel Tools" />
            <Button fx:id="btnExit" onAction="#handleExitAction" style="-fx-text-fill: white; -fx-background-color: transparent;" text="About" />
         <Button mnemonicParsing="false" style="-fx-background-color: transparent;" text="Settings" textFill="#f7f4f4" />
         <Button mnemonicParsing="false" style="-fx-background-color: transparent;" text="Exit" textFill="#f7f3f3" />
        </VBox>
    </left>

    <!-- Header -->
    <top>
        <HBox alignment="CENTER_LEFT" prefHeight="60" style="-fx-background-color: #2f4b7c;" BorderPane.alignment="CENTER">
            <padding>
                <Insets left="20" />
            </padding>
            <Label text="Welcome to Blue-Lanka Guide" textFill="WHITE">
                <font>
                    <Font size="22" />
                </font>
            </Label>
        </HBox>
    </top>

    <!-- Main Content -->
    <center>
        <HBox alignment="CENTER" spacing="30" BorderPane.alignment="CENTER">
            <padding>
                <Insets bottom="40" top="40" />
            </padding>

            <!-- Surfing Card -->
            <VBox alignment="CENTER" prefHeight="250" prefWidth="250" spacing="15" style="-fx-background-color: #ffa600; -fx-background-radius: 15;">
                <padding>
                    <Insets bottom="20" left="20" right="20" top="20" />
                </padding>
                <ImageView fitHeight="80" fitWidth="80">
                    <image>
                        <Image url="@surfing.jpg" />
                    </image>
                </ImageView>
                <Label text="Safe Surfing Spots" textFill="WHITE">
                    <font>
                        <Font size="18" />
                    </font>
                </Label>
            </VBox>

            <!-- Diving Card -->
            <VBox alignment="CENTER" prefHeight="250" prefWidth="250" spacing="15" style="-fx-background-color: #00b5ad; -fx-background-radius: 15;">
                <padding>
                    <Insets bottom="20" left="20" right="20" top="20" />
                </padding>
                <ImageView fitHeight="80" fitWidth="80">
                    <image>
                        <Image url="@diving.jpg" />
                    </image>
                </ImageView>
                <Label text="Safe Diving Locations" textFill="WHITE">
                    <font>
                        <Font size="18" />
                    </font>
                </Label>
            </VBox>

        </HBox>
    </center>

</BorderPane>
