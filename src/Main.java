
public class Main {
	public static Box box;
	public static MainFrame mainFrame;
	public static void main(String[] args) {
		Main.box = new Box();
		Main.mainFrame = new MainFrame("title");
		Main.mainFrame.setVisible(true);
	}
}
