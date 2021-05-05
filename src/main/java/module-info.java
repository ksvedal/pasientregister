module pasientregister {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  opens idatx.mappe2.pasientregister.view to javafx.fxml;
  opens idatx.mappe2.pasientregister.model to javafx.base;
  exports idatx.mappe2.pasientregister.view;
}