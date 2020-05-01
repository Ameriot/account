package com.account.accountapplication.data.record.dataBase;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.account.accountapplication.data.record.dao.recordDao;
import com.account.accountapplication.data.record.dao.recordDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class recordDatabase_Impl extends recordDatabase {
  private volatile recordDao _recordDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `record` (`record_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `record_server` INTEGER NOT NULL, `record_name` TEXT NOT NULL, `record_inOut` INTEGER NOT NULL, `record_money` REAL NOT NULL, `record_date` INTEGER NOT NULL, `record_createDate` INTEGER NOT NULL, `record_modifyDate` INTEGER, `recordAccount_id` INTEGER, `recordRecType_id` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `account` (`account_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `account_user` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `recType` (`recType_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recType_name` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e2cd78a4737f603bb0b1b65362934c6f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `record`");
        _db.execSQL("DROP TABLE IF EXISTS `account`");
        _db.execSQL("DROP TABLE IF EXISTS `recType`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsRecord = new HashMap<String, TableInfo.Column>(10);
        _columnsRecord.put("record_id", new TableInfo.Column("record_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("record_server", new TableInfo.Column("record_server", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("record_name", new TableInfo.Column("record_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("record_inOut", new TableInfo.Column("record_inOut", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("record_money", new TableInfo.Column("record_money", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("record_date", new TableInfo.Column("record_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("record_createDate", new TableInfo.Column("record_createDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("record_modifyDate", new TableInfo.Column("record_modifyDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("recordAccount_id", new TableInfo.Column("recordAccount_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecord.put("recordRecType_id", new TableInfo.Column("recordRecType_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRecord = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRecord = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRecord = new TableInfo("record", _columnsRecord, _foreignKeysRecord, _indicesRecord);
        final TableInfo _existingRecord = TableInfo.read(_db, "record");
        if (! _infoRecord.equals(_existingRecord)) {
          return new RoomOpenHelper.ValidationResult(false, "record(com.account.accountapplication.data.record.record).\n"
                  + " Expected:\n" + _infoRecord + "\n"
                  + " Found:\n" + _existingRecord);
        }
        final HashMap<String, TableInfo.Column> _columnsAccount = new HashMap<String, TableInfo.Column>(2);
        _columnsAccount.put("account_id", new TableInfo.Column("account_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAccount.put("account_user", new TableInfo.Column("account_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAccount = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAccount = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAccount = new TableInfo("account", _columnsAccount, _foreignKeysAccount, _indicesAccount);
        final TableInfo _existingAccount = TableInfo.read(_db, "account");
        if (! _infoAccount.equals(_existingAccount)) {
          return new RoomOpenHelper.ValidationResult(false, "account(com.account.accountapplication.data.record.account).\n"
                  + " Expected:\n" + _infoAccount + "\n"
                  + " Found:\n" + _existingAccount);
        }
        final HashMap<String, TableInfo.Column> _columnsRecType = new HashMap<String, TableInfo.Column>(2);
        _columnsRecType.put("recType_id", new TableInfo.Column("recType_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecType.put("recType_name", new TableInfo.Column("recType_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRecType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRecType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRecType = new TableInfo("recType", _columnsRecType, _foreignKeysRecType, _indicesRecType);
        final TableInfo _existingRecType = TableInfo.read(_db, "recType");
        if (! _infoRecType.equals(_existingRecType)) {
          return new RoomOpenHelper.ValidationResult(false, "recType(com.account.accountapplication.data.record.recType).\n"
                  + " Expected:\n" + _infoRecType + "\n"
                  + " Found:\n" + _existingRecType);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e2cd78a4737f603bb0b1b65362934c6f", "2db25166624c47b8327c47932ac661cb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "record","account","recType");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `record`");
      _db.execSQL("DELETE FROM `account`");
      _db.execSQL("DELETE FROM `recType`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public recordDao recordDao() {
    if (_recordDao != null) {
      return _recordDao;
    } else {
      synchronized(this) {
        if(_recordDao == null) {
          _recordDao = new recordDao_Impl(this);
        }
        return _recordDao;
      }
    }
  }
}
