/**Copyright (C) 2013 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.jimsuplee.aircraftcarriers;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

public class DBAdapter {
	static final String TAG = "CARRIERS";
	
	static final String DATABASE_NAME = "carrier";
	static final String DATABASE_TABLE = "carrier";
	static final int DATABASE_VERSION = 1;
	
	static final String carriername = "carriername";
	static final String carrierdata = "carrierdata";
	
	static final String DATABASE_CREATE = "CREATE TABLE carrier (carriername text default null, carrierdata text default null);";
	
	final Context context;

	DatabaseHelper DBHelper;
	SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			//////Log.w(TAG, "Upgrading database");
			db.execSQL("DROP TABLE IF EXISTS carrier");
			onCreate(db);
		}
	}
	
	// open
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	// close
	public void close() {
		DBHelper.close();
	}
	public Cursor getByCarrierdata(String carrierdataParam) throws SQLException {
		//Log.w(TAG, "In DBAdapter.getByCarrierdata("+carrierdataParam+")");
		//String[] columns = new String[] {carriername, carrierdata};
		//We only need the carriername column to be returned, even though we search on carrierdata
		String[] columns = new String[] {carriername};				
		String selection;
		//We assume that the carrierdataParam has ALREADY be pre-and-post-pended with "%" for LIKE sql:
	    selection = "carrierdata LIKE ?";
		String[] selectionArgs = new String[] { carrierdataParam };
		//Log.w(TAG, "In DBAdapter.getByCarrierdata, about to dbquery("+selection+" "+selectionArgs[0]);
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByCarrierdata(StringcarrierdataParam), About to check if Cursor c is null");
		if (mCursor != null) {
            //Log.w(TAG,"In DBAdapter.getByCarrierdata(String carrierdataParam), c is NOT null, about to NOT c.moveToFirst()");
			//mCursor.moveToFirst();
			if(mCursor.moveToFirst()) {
				//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is true");
			} else {
				//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is NOT true");	
			}
		}
		//Log.w(TAG, "In DBAdapter.getByCarrierdata(String carrierdataParam), about to return cursor, c");
		return mCursor;
	}	
public Cursor getByCarrierdata(String carrierdataParam, String carrierdataParamtwo) throws SQLException {
	//Log.w(TAG, "In DBAdapter.getByCarrierdata("+carrierdataParam+", "+carrierdataParamtwo+")");
	//String[] columns = new String[] {carriername, carrierdata};
	//We only need the carriername column to be returned, even though we search on carrierdata
	String[] columns = new String[] {carriername};				
	String selection;
	//We assume that the carrierdataParam has ALREADY be pre-and-post-pended with "%" for LIKE sql:
    selection = "carrierdata LIKE ? AND carrierdata LIKE ?";
	String[] selectionArgs = new String[] { carrierdataParam, carrierdataParamtwo};
	//Log.w(TAG, "In DBAdapter.getByCarrierdata, about to dbquery("+selection+" "+selectionArgs[0]);
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(StringcarrierdataParam), About to check if Cursor c is null");
	if (mCursor != null) {
            //Log.w(TAG,"In DBAdapter.getByCarrierdata(String carrierdataParam), c is NOT null, about to NOT c.moveToFirst()");
		//mCursor.moveToFirst();
		if(mCursor.moveToFirst()) {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is true");
		} else {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is NOT true");	
		}
	}
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(String carrierdataParam), about to return cursor, c");
	return mCursor;
}

public Cursor getByCarrierdata(String carrierdataParam, String carrierdataParamtwo, String carrierdataParamthree) throws SQLException {
	//Log.w(TAG, "In DBAdapter.getByCarrierdata("+carrierdataParam+", "+carrierdataParamtwo+", "+carrierdataParamthree+")");
	//String[] columns = new String[] {carriername, carrierdata};
	//We only need the carriername column to be returned, even though we search on carrierdata
	String[] columns = new String[] {carriername};				
	String selection;
	//We assume that the carrierdataParam has ALREADY be pre-and-post-pended with "%" for LIKE sql:
    selection = "carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ?";
	String[] selectionArgs = new String[] { carrierdataParam, carrierdataParamtwo, carrierdataParamthree};
	//Log.w(TAG, "In DBAdapter.getByCarrierdata, about to dbquery("+selection+" "+selectionArgs[0]);
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(StringcarrierdataParam), About to check if Cursor c is null");
	if (mCursor != null) {
            //Log.w(TAG,"In DBAdapter.getByCarrierdata(String carrierdataParam), c is NOT null, about to NOT c.moveToFirst()");
		//mCursor.moveToFirst();
		if(mCursor.moveToFirst()) {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is true");
		} else {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is NOT true");	
		}
	}
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(String carrierdataParam), about to return cursor, c");
	return mCursor;
}	
public Cursor getByCarrierdata(String carrierdataParam, String carrierdataParamtwo, String carrierdataParamthree, String carrierdataParamfour) throws SQLException {
	//Log.w(TAG, "In DBAdapter.getByCarrierdata("+carrierdataParam+", "+carrierdataParamtwo+", "+carrierdataParamthree+", "+carrierdataParamfour+")");
	//String[] columns = new String[] {carriername, carrierdata};
	//We only need the carriername column to be returned, even though we search on carrierdata
	String[] columns = new String[] {carriername};				
	String selection;
	//We assume that the carrierdataParam has ALREADY be pre-and-post-pended with "%" for LIKE sql:
    selection = "carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ?";
	String[] selectionArgs = new String[] { carrierdataParam, carrierdataParamtwo, carrierdataParamthree, carrierdataParamfour};
	//Log.w(TAG, "In DBAdapter.getByCarrierdata, about to dbquery("+selection+" "+selectionArgs[0]);
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(StringcarrierdataParam), About to check if Cursor c is null");
	if (mCursor != null) {
            //Log.w(TAG,"In DBAdapter.getByCarrierdata(String carrierdataParam), c is NOT null, about to NOT c.moveToFirst()");
		//mCursor.moveToFirst();
		if(mCursor.moveToFirst()) {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is true");
		} else {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is NOT true");	
		}
	}
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(String carrierdataParam), about to return cursor, c");
	return mCursor;
}	public Cursor getByCarrierdata(String carrierdataParam, String carrierdataParamtwo, String carrierdataParamthree, String carrierdataParamfour, String carrierdataParamfive) throws SQLException {
	//Log.w(TAG, "In DBAdapter.getByCarrierdata("+carrierdataParam+", "+carrierdataParamtwo+", "+carrierdataParamthree+", "+carrierdataParamfour+", "+carrierdataParamfive+")");
	//String[] columns = new String[] {carriername, carrierdata};
	//We only need the carriername column to be returned, even though we search on carrierdata
	String[] columns = new String[] {carriername};				
	String selection;
	//We assume that the carrierdataParam has ALREADY be pre-and-post-pended with "%" for LIKE sql:
    selection = "carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ?";
	String[] selectionArgs = new String[] { carrierdataParam, carrierdataParamtwo, carrierdataParamthree, carrierdataParamfour, carrierdataParamfive};
	//Log.w(TAG, "In DBAdapter.getByCarrierdata, about to dbquery("+selection+" "+selectionArgs[0]);
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(StringcarrierdataParam), About to check if Cursor c is null");
	if (mCursor != null) {
            //Log.w(TAG,"In DBAdapter.getByCarrierdata(String carrierdataParam), c is NOT null, about to NOT c.moveToFirst()");
		//mCursor.moveToFirst();
		if(mCursor.moveToFirst()) {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is true");
		} else {
			//Log.w(TAG,"In DBAdapter.getByCarrierdata(),mCursor.moveToFirst() is NOT true");	
		}
	}
	//Log.w(TAG, "In DBAdapter.getByCarrierdata(String carrierdataParam), about to return cursor, c");
	return mCursor;
}	
}
