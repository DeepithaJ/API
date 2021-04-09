package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeSuite;


public class base {
	
	public static org.apache.logging.log4j.Logger log1;
	@BeforeSuite
	public void Bsuite() throws FileNotFoundException, IOException {
	String log4jConfigFile=("C:\\Users\\Qualitest\\eclipse-workspace\\TwitterAPIProject\\src\\main\\java\\Resources\\base.java");
	ConfigurationSource source=new ConfigurationSource(new FileInputStream(log4jConfigFile));
	Configurator.initialize(null,source);
	log1=LogManager.getLogger(base.class.getName());
	}

}
