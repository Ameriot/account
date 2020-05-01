package com.account.accountapplication.data.record.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.account.accountapplication.data.record.recType;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class recTypeDao_Impl implements recTypeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<recType> __insertionAdapterOfrecType;

  public recTypeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfrecType = new EntityInsertionAdapter<recType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `recType` (`recType_id`,`recType_name`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, recType value) {
        if (value.getRecTypeId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getRecTypeId());
        }
        if (value.getRecTypeName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRecTypeName());
        }
      }
    };
  }

  @Override
  public void insertRecType(final recType... recTypes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfrecType.insert(recTypes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<recType> getRecType() {
    final String _sql = "SELECT * FROM recType";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRecTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recType_id");
      final int _cursorIndexOfRecTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "recType_name");
      final List<recType> _result = new ArrayList<recType>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final recType _item;
        final Integer _tmpRecTypeId;
        if (_cursor.isNull(_cursorIndexOfRecTypeId)) {
          _tmpRecTypeId = null;
        } else {
          _tmpRecTypeId = _cursor.getInt(_cursorIndexOfRecTypeId);
        }
        final String _tmpRecTypeName;
        _tmpRecTypeName = _cursor.getString(_cursorIndexOfRecTypeName);
        _item = new recType(_tmpRecTypeId,_tmpRecTypeName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public recType getRecTypeById(final Integer recTypeId) {
    final String _sql = "SELECT * FROM recType WHERE recType_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recTypeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, recTypeId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRecTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recType_id");
      final int _cursorIndexOfRecTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "recType_name");
      final recType _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpRecTypeId;
        if (_cursor.isNull(_cursorIndexOfRecTypeId)) {
          _tmpRecTypeId = null;
        } else {
          _tmpRecTypeId = _cursor.getInt(_cursorIndexOfRecTypeId);
        }
        final String _tmpRecTypeName;
        _tmpRecTypeName = _cursor.getString(_cursorIndexOfRecTypeName);
        _result = new recType(_tmpRecTypeId,_tmpRecTypeName);
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
  public LiveData<List<recType>> getAllRecTypesLive() {
    final String _sql = "SELECT * FROM recType ORDER BY recType_id DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"recType"}, false, new Callable<List<recType>>() {
      @Override
      public List<recType> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRecTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recType_id");
          final int _cursorIndexOfRecTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "recType_name");
          final List<recType> _result = new ArrayList<recType>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final recType _item;
            final Integer _tmpRecTypeId;
            if (_cursor.isNull(_cursorIndexOfRecTypeId)) {
              _tmpRecTypeId = null;
            } else {
              _tmpRecTypeId = _cursor.getInt(_cursorIndexOfRecTypeId);
            }
            final String _tmpRecTypeName;
            _tmpRecTypeName = _cursor.getString(_cursorIndexOfRecTypeName);
            _item = new recType(_tmpRecTypeId,_tmpRecTypeName);
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
