package application;

/**
 * This class has all of the sixteen tables in the restaurant
 * 
 * @author yinjiezhang
 *
 */
public class TableList {
	static Table tb1 = new Table();
	static Table tb2 = new Table();
	static Table tb3 = new Table();
	static Table tb4 = new Table();
	static Table tb5 = new Table();
	static Table tb6 = new Table();
	static Table tb7 = new Table();
	static Table tb8 = new Table();
	static Table tb9 = new Table();
	static Table tb10 = new Table();
	static Table tb11 = new Table();
	static Table tb12 = new Table();
	static Table tb13 = new Table();
	static Table tb14 = new Table();
	static Table tb15 = new Table();
	static Table tb16 = new Table();
	public static Table[] tableList = { tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8, tb9, tb10, tb11, tb12, tb13, tb14, tb15,
			tb16 };

	/**
	 * Assign a table to customer when he/she click order button, if all of the 16
	 * tables have been occupied, no operation.
	 */
	public static void assignTableToOrder() {
		int occupiedNum = 0;

		for (int i = 0; i < tableList.length; i++) {
			if (tableList[i].isOccupied()) {
				occupiedNum = i + 1;
			} else {
				break;
			}
		}

		if (occupiedNum != 16) {
			tableList[occupiedNum].setOccupied(true);
			tableList[occupiedNum].setPaid(true);
		}

		// System.out.println(tableList[0].isOccupied());

	}
}
