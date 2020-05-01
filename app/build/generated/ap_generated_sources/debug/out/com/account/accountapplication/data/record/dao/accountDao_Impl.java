package com.account.accountapplication.data.record.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.account.accountapplication.data.record.account;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class accountDao_Impl implements accountDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<account> __insertionAdapterOfaccount;

  public accountDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfaccount = new EntityInsertionAdapter<account>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `account` (`account_id`,`account_user`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, account value) {
        if (value.getAccountId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getAccountId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUserId());
        }
      }
    };
  }

  @Override
  public void insertAccount(final account... accounts) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfaccount.insert(accounts);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<account> getAccount() {
    final String _sql = "SELECT * FROM account";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "account_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "account_user");
      final List<account> _result = new ArrayList<account>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final account _item;
        final Integer _tmpAccountId;
        if (_cursor.isNull(_cursorIndexOfAccountId)) {
          _tmpAccountId = null;
        } else {
          _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
        }
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item = new account(_tmpAccountId,_tmpUserId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public account getAccountById(final Integer accountId) {
    final String _sql = "SELECT * FROM account WHERE account_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (accountId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, accountId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "account_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "account_user");
      final account _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpAccountId;
        if (_cursor.isNull(_cursorIndexOfAccountId)) {
          _tmpAccountId = null;
        } else {
          _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
        }
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result = new account(_tmpAccountId,_tmpUserId);
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
  public LiveData<List<account>> getAllAccountsLive() {
    final String _sql = "SELECT * FROM account ORDER BY account_id DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"account"}, false, new Callable<List<account>>() {
      @Override
      public List<account> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "account_id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "account_user");
          final List<account> _result = new ArrayList<account>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final account _item;
            final Integer _tmpAccountId;
            if (_cursor.isNull(_cursorIndexOfAccountId)) {
              _tmpAccountId = null;
            } else {
              _tmpAccountId = _cursor.getInt(_cursorIndexOfAccountId);
            }
            final Integer _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            }
            _item = new account(_tmpAccountId,_tmpUserId);
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
