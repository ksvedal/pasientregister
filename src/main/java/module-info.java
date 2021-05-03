module pasientregister {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  opens idatx.mappe2.pasientregister to javafx.fxml;
  exports idatx.mappe2.pasientregister;
}