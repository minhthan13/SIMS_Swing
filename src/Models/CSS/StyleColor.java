package Models.CSS;

import java.awt.Color;

public class StyleColor {
	public static Color FormColor() {
		Color backgroundColor = Color.decode("#3c6382");
		float transparency = 0.6f;

		Color colorWithTransparency = new Color(backgroundColor.getRed(), backgroundColor.getGreen(),
				backgroundColor.getBlue(), (int) (transparency * 255));
		return colorWithTransparency;
	}

	public static Color TitleColor() {
		return Color.decode("#ffffff");
	}

	public static Color btnNoBacground() {
		Color backgroundColor = Color.decode("#f7d794");
		float transparency = 1f;

		Color colorWithTransparency = new Color(backgroundColor.getRed(), backgroundColor.getGreen(),
				backgroundColor.getBlue(), (int) (transparency * 255));
		return colorWithTransparency;
	}

	public static Color BtnBackground() {
		return Color.decode("#f5cd79");
	}
}
