package zad1;

import java.util.ListResourceBundle;

public class TripInfo extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
	
    private Object[][] contents = {
	{ "lake", "jezioro" },
	{ "sea", "morze" },
	{ "mountains", "góry" },
    };
}
