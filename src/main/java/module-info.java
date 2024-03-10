module uni.mosey.bankatm {
    requires javafx.controls;
    requires javafx.fxml;


    opens uni.mosey.bankatm to javafx.fxml;
    exports uni.mosey.bankatm;
    exports uni.mosey.bankatm.Controller;
    opens uni.mosey.bankatm.Controller to javafx.fxml;
}