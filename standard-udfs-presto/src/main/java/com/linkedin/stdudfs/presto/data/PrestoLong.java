package com.linkedin.stdudfs.presto.data;

import com.facebook.presto.spi.block.BlockBuilder;
import com.linkedin.stdudfs.api.data.StdLong;

import static com.facebook.presto.spi.type.BigintType.BIGINT;


public class PrestoLong extends PrestoData implements StdLong {

  long _value;

  public PrestoLong(long value) {
    _value = value;
  }

  @Override
  public long get() {
    return _value;
  }

  @Override
  public Object getUnderlyingData() {
    return _value;
  }

  @Override
  public void setUnderlyingData(Object value) {
    _value = (long) value;
  }

  @Override
  public void writeToBlock(BlockBuilder blockBuilder) {
    BIGINT.writeLong(blockBuilder, _value);
  }
}
