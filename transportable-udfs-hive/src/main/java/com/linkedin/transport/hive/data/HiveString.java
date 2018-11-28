/**
 * Copyright 2018 LinkedIn Corporation. All rights reserved.
 * Licensed under the BSD-2 Clause license.
 * See LICENSE in the project root for license information.
 */
package com.linkedin.transport.hive.data;

import com.linkedin.transport.api.StdFactory;
import com.linkedin.transport.api.data.StdString;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.StringObjectInspector;


public class HiveString extends HiveData implements StdString {

  final StringObjectInspector _stringObjectInspector;

  public HiveString(Object object, StringObjectInspector stringObjectInspector, StdFactory stdFactory) {
    super(stdFactory);
    _object = object;
    _stringObjectInspector = stringObjectInspector;
  }

  @Override
  public String get() {
    return _stringObjectInspector.getPrimitiveJavaObject(_object);
  }

  @Override
  public ObjectInspector getUnderlyingObjectInspector() {
    return _stringObjectInspector;
  }
}
