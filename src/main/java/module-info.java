module pasientregister {
  requires javafx.controls;
  requires javafx.fxml;
  opens idatx.mappe2.pasientregister to javafx.fxml;
  exports idatx.mappe2.pasientregister;
}