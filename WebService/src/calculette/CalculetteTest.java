package calculette;

import static org.testng.Assert.*;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.testng.annotations.*;

import fr.paris10.miage.procs.exercice1.Calculette;
import fr.paris10.miage.procs.exercice1.HelloWorld;


public class CalculetteTest {

	private Calculette calc;
	
	@BeforeClass
	public void setUp() throws Exception {
	  
		URL url = new URL("http://localhost:6662/ws/calc");
	    QName qname = new QName("http://calculette/", "CalculetteImplService");
	    Service service = Service.create(url, qname);
	    calc = service.getPort(Calculette.class);
	}

	@AfterClass
	public void tearDown() throws Exception {
	    calc = null;
	}

	@Test
	public void testAjouter() throws Exception {
	    assertEquals(calc.ajouter(2,3),5);
	}

	@Test
	public void testSoustraire() throws Exception {
	    assertEquals(calc.soustraire(2,3),-1);
	}
}
