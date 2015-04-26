package sasiela.wojtek.dziennikszkolny.ORM.configuration;

import sasiela.wojtek.dziennikszkolny.ORM.tables.Account;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
	
 	private static final Class<?>[] classes = new Class[]{Account.class};
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt",classes);

	}

}
