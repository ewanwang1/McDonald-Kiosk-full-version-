import main.statustracker.KioskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStatusTracker {
    KioskStatus testKioskStatus;
    @BeforeEach
    public void setup(){
        testKioskStatus = new KioskStatus();
    }


    @Test
    public void setTestKioskStatus(){
           testKioskStatus.update(null, null);
           assertEquals(testKioskStatus.getItemsOrdered(),1);
    }
}
