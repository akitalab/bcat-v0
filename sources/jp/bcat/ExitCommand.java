package jp.bcat;
import java.io.*;

public class ExitCommand implements CLICommand {
	public void process(BufferedReader in, PrintWriter out) {
		out.println("終了します。");
		out.flush();
		System.exit(0);
	}
}
