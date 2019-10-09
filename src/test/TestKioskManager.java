import main.model.menu.Order;
import main.model.menu.burger.beef.BigMac;
import main.model.menudisplayed.BurgurMenu;
import main.model.menudisplayed.Menu;
import main.ui.KioskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestKioskManager {
    KioskManager testKioskManager;
    BigMac bigmac;
    private Order currentOrder;
    private Menu menu;
    private BurgurMenu burgurMenu;

    @BeforeEach
    public void setup()
    {
        testKioskManager = new KioskManager();
        currentOrder = new Order();
        burgurMenu = new BurgurMenu();

    }

@Test
    public void test() throws IOException, ClassNotFoundException {
        testKioskManager.setUpMenu();
        testKioskManager.startKiosk();
        testKioskManager.makeOrder(1 ,bigmac);
        testKioskManager.viewOrder();

}

}
