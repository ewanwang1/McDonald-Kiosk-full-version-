import main.statustracker.KioskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.KioskManager;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStatusTracker {
    KioskStatus testKioskStatus;
    KioskManager testKioskManager;
    @BeforeEach
    public void setup(){
        testKioskManager = new KioskManager();
        testKioskStatus = new KioskStatus();
    }


    @Test
    public void setTestKioskStatus(){
           testKioskStatus.update(testKioskManager, null);
           assertEquals(testKioskStatus.getItemsOrdered(),1);
    }
}
