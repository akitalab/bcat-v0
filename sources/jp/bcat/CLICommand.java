package jp.bcat;
import java.io.*;

public interface CLICommand {
	public void process(BufferedReader in, PrintWriter out)
		throws IOException;
}
