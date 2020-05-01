package com.account.accountapplication.data.record.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.account.accountapplication.data.record.dataBase.Converters;
import com.account.accountapplication.data.record.record;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class recordDao_Impl implements recordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<record> __insertionAdapterOfrecord;

  private final EntityDeletionOrUpdateAdapter<record> __deletionAdapterOfrecord;

  private final EntityDeletionOrUpdateAdapter<record> __updateAdapterOfrecord;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRecordById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllRecords;

  public recordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfrecord = new EntityInsertionAdapter<record>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `record` (`record_id`,`record_server`,`record_name`,`record_inOut`,`record_money`,`record_date`,`record_createDate`,`record_modifyDate`,`recordAccount_id`,`recordRecType_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, record value) {
        if (value.getRecordId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getRecordId());
        }
        if (value.getRecordServer() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getRecordServer());
        }
        if (value.getRecordName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecordName());
        }
        if (value.getRecordInOut() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRecordInOut());
        }
        stmt.bindDouble(5, value.getRecordMoney());
        final Long _tmp;
        _tmp = Converters.dateToTimestamp(value.getRecordDate());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = Converters.dateToTimestamp(value.getRecordCreateDate());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = Converters.dateToTimestamp(value.getRecordModifyDate());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_2);
        }
        if (value.getAccount() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getAccount());
        }
        if (value.getRecType() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getRecType());
        }
      }
    };
    this.__deletionAdapterOfrecord = new EntityDeletionOrUpdateAdapter<record>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `record` WHERE `record_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, record value) {
        if (value.getRecordId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getRecordId());
        }
      }
    };
    this.__updateAdapterOfrecord = new EntityDeletionOrUpdateAdapter<record>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `record` SET `record_id` = ?,`record_server` = ?,`record_name` = ?,`record_inOut` = ?,`record_money` = ?,`record_date` = ?,`record_createDate` = ?,`record_modifyDate` = ?,`recordAccount_id` = ?,`recordRecType_id` = ? WHERE `record_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, record value) {
        if (value.getRecordId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getRecordId());
        }
        if (value.getRecordServer() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getRecordServer());
        }
        if (value.getRecordName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecordName());
        }
        if (value.getRecordInOut() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRecordInOut());
        }
        stmt.bindDouble(5, value.getRecordMoney());
        final Long _tmp;
        _tmp = Converters.dateToTimestamp(value.getRecordDate());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = Converters.dateToTimestamp(value.getRecordCreateDate());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = Converters.dateToTimestamp(value.getRecordModifyDate());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_2);
        }
        if (value.getAccount() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getAccount());
        }
        if (value.getRecType() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getRecType());
        }
        if (value.getRecordId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getRecordId());
        }
      }
    };
    this.__preparedStmtOfDeleteRecordById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM record WHERE record_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllRecords = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM record";
        return _query;
      }
    };
  }

  @Override
  public void insertRecord(final record... records) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfrecord.insert(records);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRecords(final record... records) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfrecord.handleMultiple(records);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateRecord(final record... records) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfrecord.handleMultiple(records);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteRecordById(final Integer recordId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRecordById.acquire();
    int _argIndex = 1;
    if (recordId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, recordId);
    }
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteRecordById.release(_stmt);
    }
  }

  @Override
  public void deleteAllRecords() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllRecords.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllRecords.release(_stmt);
    }
  }

  @Override
  public LiveData<List<record>> getAllRecordsLive() {
    final String _sql = "SELECT * FROM record ORDER BY record_id DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"record"}, false, new Callable<List<record>>() {
      @Override
      public List<record> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRecordId = CursorUtil.getColumnIndexOrThrow(_cursor, "record_id");
          final int _cursorIndexOfRecordServer = CursorUtil.getColumnIndexOrThrow(_cursor, "record_server");
          final int _cursorIndexOfRecordName = CursorUtil.getColumnIndexOrThrow(_cursor, "record_name");
          final int _cursorIndexOfRecordInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "record_inOut");
          final int _cursorIndexOfRecordMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "record_money");
          final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_date");
          final int _cursorIndexOfRecordCreateDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_createDate");
          final int _cursorIndexOfRecordModifyDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_modifyDate");
          final int _cursorIndexOfAccount = CursorUtil.getColumnIndexOrThrow(_cursor, "recordAccount_id");
          final int _cursorIndexOfRecType = CursorUtil.getColumnIndexOrThrow(_cursor, "recordRecType_id");
          final List<record> _result = new ArrayList<record>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final record _item;
            final Integer _tmpRecordId;
            if (_cursor.isNull(_cursorIndexOfRecordId)) {
              _tmpRecordId = null;
            } else {
              _tmpRecordId = _cursor.getInt(_cursorIndexOfRecordId);
            }
            final Integer _tmpRecordServer;
            if (_cursor.isNull(_cursorIndexOfRecordServer)) {
              _tmpRecordServer = null;
            } else {
              _tmpRecordServer = _cursor.getInt(_cursorIndexOfRecordServer);
            }
            final String _tmpRecordName;
            _tmpRecordName = _cursor.getString(_cursorIndexOfRecordName);
            final Integer _tmpRecordInOut;
            if (_cursor.isNull(_cursorIndexOfRecordInOut)) {
              _tmpRecordInOut = null;
            } else {
              _tmpRecordInOut = _cursor.getInt(_cursorIndexOfRecordInOut);
            }
            final float _tmpRecordMoney;
            _tmpRecordMoney = _cursor.getFloat(_cursorIndexOfRecordMoney);
            final Date _tmpRecordDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfRecordDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfRecordDate);
            }
            _tmpRecordDate = Converters.fromTimestamp(_tmp);
            final Date _tmpRecordCreateDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfRecordCreateDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfRecordCreateDate);
            }
            _tmpRecordCreateDate = Converters.fromTimestamp(_tmp_1);
            final Date _tmpRecordModifyDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfRecordModifyDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfRecordModifyDate);
            }
            _tmpRecordModifyDate = Converters.fromTimestamp(_tmp_2);
            final Integer _tmpAccount;
            if (_cursor.isNull(_cursorIndexOfAccount)) {
              _tmpAccount = null;
            } else {
              _tmpAccount = _cursor.getInt(_cursorIndexOfAccount);
            }
            final Integer _tmpRecType;
            if (_cursor.isNull(_cursorIndexOfRecType)) {
              _tmpRecType = null;
            } else {
              _tmpRecType = _cursor.getInt(_cursorIndexOfRecType);
            }
            _item = new record(_tmpRecordId,_tmpRecordServer,_tmpRecordName,_tmpRecordInOut,_tmpRecordMoney,_tmpRecordDate,_tmpRecordCreateDate,_tmpRecordModifyDate,_tmpAccount,_tmpRecType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public record getRecordById(final Integer recordId) {
    final String _sql = "SELECT * FROM record WHERE record_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recordId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, recordId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRecordId = CursorUtil.getColumnIndexOrThrow(_cursor, "record_id");
      final int _cursorIndexOfRecordServer = CursorUtil.getColumnIndexOrThrow(_cursor, "record_server");
      final int _cursorIndexOfRecordName = CursorUtil.getColumnIndexOrThrow(_cursor, "record_name");
      final int _cursorIndexOfRecordInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "record_inOut");
      final int _cursorIndexOfRecordMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "record_money");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_date");
      final int _cursorIndexOfRecordCreateDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_createDate");
      final int _cursorIndexOfRecordModifyDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_modifyDate");
      final int _cursorIndexOfAccount = CursorUtil.getColumnIndexOrThrow(_cursor, "recordAccount_id");
      final int _cursorIndexOfRecType = CursorUtil.getColumnIndexOrThrow(_cursor, "recordRecType_id");
      final record _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpRecordId;
        if (_cursor.isNull(_cursorIndexOfRecordId)) {
          _tmpRecordId = null;
        } else {
          _tmpRecordId = _cursor.getInt(_cursorIndexOfRecordId);
        }
        final Integer _tmpRecordServer;
        if (_cursor.isNull(_cursorIndexOfRecordServer)) {
          _tmpRecordServer = null;
        } else {
          _tmpRecordServer = _cursor.getInt(_cursorIndexOfRecordServer);
        }
        final String _tmpRecordName;
        _tmpRecordName = _cursor.getString(_cursorIndexOfRecordName);
        final Integer _tmpRecordInOut;
        if (_cursor.isNull(_cursorIndexOfRecordInOut)) {
          _tmpRecordInOut = null;
        } else {
          _tmpRecordInOut = _cursor.getInt(_cursorIndexOfRecordInOut);
        }
        final float _tmpRecordMoney;
        _tmpRecordMoney = _cursor.getFloat(_cursorIndexOfRecordMoney);
        final Date _tmpRecordDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfRecordDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfRecordDate);
        }
        _tmpRecordDate = Converters.fromTimestamp(_tmp);
        final Date _tmpRecordCreateDate;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfRecordCreateDate)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfRecordCreateDate);
        }
        _tmpRecordCreateDate = Converters.fromTimestamp(_tmp_1);
        final Date _tmpRecordModifyDate;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfRecordModifyDate)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfRecordModifyDate);
        }
        _tmpRecordModifyDate = Converters.fromTimestamp(_tmp_2);
        final Integer _tmpAccount;
        if (_cursor.isNull(_cursorIndexOfAccount)) {
          _tmpAccount = null;
        } else {
          _tmpAccount = _cursor.getInt(_cursorIndexOfAccount);
        }
        final Integer _tmpRecType;
        if (_cursor.isNull(_cursorIndexOfRecType)) {
          _tmpRecType = null;
        } else {
          _tmpRecType = _cursor.getInt(_cursorIndexOfRecType);
        }
        _result = new record(_tmpRecordId,_tmpRecordServer,_tmpRecordName,_tmpRecordInOut,_tmpRecordMoney,_tmpRecordDate,_tmpRecordCreateDate,_tmpRecordModifyDate,_tmpAccount,_tmpRecType);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<record>> findRecordsWithPattern(final String pattern) {
    final String _sql = "SELECT * FROM record WHERE record_name LIKE ? ORDER BY record_id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (pattern == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pattern);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"record"}, false, new Callable<List<record>>() {
      @Override
      public List<record> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRecordId = CursorUtil.getColumnIndexOrThrow(_cursor, "record_id");
          final int _cursorIndexOfRecordServer = CursorUtil.getColumnIndexOrThrow(_cursor, "record_server");
          final int _cursorIndexOfRecordName = CursorUtil.getColumnIndexOrThrow(_cursor, "record_name");
          final int _cursorIndexOfRecordInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "record_inOut");
          final int _cursorIndexOfRecordMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "record_money");
          final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_date");
          final int _cursorIndexOfRecordCreateDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_createDate");
          final int _cursorIndexOfRecordModifyDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_modifyDate");
          final int _cursorIndexOfAccount = CursorUtil.getColumnIndexOrThrow(_cursor, "recordAccount_id");
          final int _cursorIndexOfRecType = CursorUtil.getColumnIndexOrThrow(_cursor, "recordRecType_id");
          final List<record> _result = new ArrayList<record>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final record _item;
            final Integer _tmpRecordId;
            if (_cursor.isNull(_cursorIndexOfRecordId)) {
              _tmpRecordId = null;
            } else {
              _tmpRecordId = _cursor.getInt(_cursorIndexOfRecordId);
            }
            final Integer _tmpRecordServer;
            if (_cursor.isNull(_cursorIndexOfRecordServer)) {
              _tmpRecordServer = null;
            } else {
              _tmpRecordServer = _cursor.getInt(_cursorIndexOfRecordServer);
            }
            final String _tmpRecordName;
            _tmpRecordName = _cursor.getString(_cursorIndexOfRecordName);
            final Integer _tmpRecordInOut;
            if (_cursor.isNull(_cursorIndexOfRecordInOut)) {
              _tmpRecordInOut = null;
            } else {
              _tmpRecordInOut = _cursor.getInt(_cursorIndexOfRecordInOut);
            }
            final float _tmpRecordMoney;
            _tmpRecordMoney = _cursor.getFloat(_cursorIndexOfRecordMoney);
            final Date _tmpRecordDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfRecordDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfRecordDate);
            }
            _tmpRecordDate = Converters.fromTimestamp(_tmp);
            final Date _tmpRecordCreateDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfRecordCreateDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfRecordCreateDate);
            }
            _tmpRecordCreateDate = Converters.fromTimestamp(_tmp_1);
            final Date _tmpRecordModifyDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfRecordModifyDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfRecordModifyDate);
            }
            _tmpRecordModifyDate = Converters.fromTimestamp(_tmp_2);
            final Integer _tmpAccount;
            if (_cursor.isNull(_cursorIndexOfAccount)) {
              _tmpAccount = null;
            } else {
              _tmpAccount = _cursor.getInt(_cursorIndexOfAccount);
            }
            final Integer _tmpRecType;
            if (_cursor.isNull(_cursorIndexOfRecType)) {
              _tmpRecType = null;
            } else {
              _tmpRecType = _cursor.getInt(_cursorIndexOfRecType);
            }
            _item = new record(_tmpRecordId,_tmpRecordServer,_tmpRecordName,_tmpRecordInOut,_tmpRecordMoney,_tmpRecordDate,_tmpRecordCreateDate,_tmpRecordModifyDate,_tmpAccount,_tmpRecType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<InnerJoinResult>> getRecFromRecord() {
    final String _sql = "SELECT recType_name from record INNER JOIN recType ON recType.recType_id=record.recordRecType_id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"record","recType"}, false, new Callable<List<InnerJoinResult>>() {
      @Override
      public List<InnerJoinResult> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRecTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "recType_name");
          final List<InnerJoinResult> _result = new ArrayList<InnerJoinResult>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final InnerJoinResult _item;
            _item = new InnerJoinResult();
            final String _tmpRecType_name;
            _tmpRecType_name = _cursor.getString(_cursorIndexOfRecTypeName);
            _item.setRecType_name(_tmpRecType_name);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
