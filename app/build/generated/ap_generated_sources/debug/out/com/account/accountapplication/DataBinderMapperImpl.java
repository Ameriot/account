package com.account.accountapplication;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.account.accountapplication.databinding.CellNormalBindingImpl;
import com.account.accountapplication.databinding.FragmentRecordBindingImpl;
import com.account.accountapplication.databinding.RecordItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CELLNORMAL = 1;

  private static final int LAYOUT_FRAGMENTRECORD = 2;

  private static final int LAYOUT_RECORDITEM = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.account.accountapplication.R.layout.cell_normal, LAYOUT_CELLNORMAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.account.accountapplication.R.layout.fragment_record, LAYOUT_FRAGMENTRECORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.account.accountapplication.R.layout.record_item, LAYOUT_RECORDITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CELLNORMAL: {
          if ("layout/cell_normal_0".equals(tag)) {
            return new CellNormalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cell_normal is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRECORD: {
          if ("layout/fragment_record_0".equals(tag)) {
            return new FragmentRecordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_record is invalid. Received: " + tag);
        }
        case  LAYOUT_RECORDITEM: {
          if ("layout/record_item_0".equals(tag)) {
            return new RecordItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for record_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "data");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/cell_normal_0", com.account.accountapplication.R.layout.cell_normal);
      sKeys.put("layout/fragment_record_0", com.account.accountapplication.R.layout.fragment_record);
      sKeys.put("layout/record_item_0", com.account.accountapplication.R.layout.record_item);
    }
  }
}
