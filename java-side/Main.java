//> using jvm 23
//> using javaOpt --enable-native-access=ALL-UNNAMED

import myscalalib_bindings.*;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		String dylibPath = null;
		if (args.length != 1) {
			System.err.println("First argument has to be path to dynamic library");
			System.exit(1);
		} else {
			dylibPath = args[0];
		}
		var p = Paths.get(dylibPath).toAbsolutePath().toString();

		System.load(p);

		assert (interface_h.ScalaNativeInit() == 0);

		System.out.println(interface_h.myscalalib_exports(25, 50));
	}
}
