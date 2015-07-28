package WojtekSasiela.DziennikSzkolny.ORM.configuration;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.Konto;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
	
 	private static final Class<?>[] classes = new Class[]{Konto.class};
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt",classes);

	}

}
