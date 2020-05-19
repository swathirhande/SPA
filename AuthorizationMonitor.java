import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorizationMonitor {
	public static boolean a;
	static String c = null;

	public static void main(String[] args) {
		try {
			String n = args[0];

			c = isUserLoggedIn(n) ? "1" : "0";
			System.out.print(c);

			// Runtime.getRuntime().exec(new String[] { "perl",
			// "C:\\xampp\\cgi-bin\\echo.pl", c });
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean isUserLoggedIn(String acc) {

		try {

			List<Object> list = new ArrayList<Object>();
			BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Temp\\logs\\banking-logs.log"));
			// br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());
			for (Object element : list) {
				String data = (String) element;
				String[] substrings = data.split("[:]");
				a = substrings[5].contains(acc) && substrings[4].contains("Login Successful for user");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
