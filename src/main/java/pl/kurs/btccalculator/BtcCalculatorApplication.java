package pl.kurs.btccalculator;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BtcCalculatorApplication extends VerticalLayout {

    public static void main(String[] args) {
        SpringApplication.run(BtcCalculatorApplication.class);
    }
}
