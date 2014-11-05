
public class TasksDAO {

	private SQLiteDatabase database;
	private TasksSQLiteHelper dbHelper;
	private String [] allColumns = {
			TasksSQLiteHelper.COLUMN_ID,
			TasksSQLiteHelper.COLUMN_PRIORITY,
	}
}
