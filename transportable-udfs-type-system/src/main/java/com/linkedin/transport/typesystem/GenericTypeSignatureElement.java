/**
 * Copyright 2018 LinkedIn Corporation. All rights reserved.
 * Licensed under the BSD-2 Clause license.
 * See LICENSE in the project root for license information.
 */
package com.linkedin.transport.typesystem;

/**
 * Class to represent generic type signatures. By default, generic types do not take any type parameters.
 */
public class GenericTypeSignatureElement implements TypeSignatureElement {
  final String _genericTypeName;

  GenericTypeSignatureElement(String genericTypeName) {
    _genericTypeName = genericTypeName;
  }

  String getGenericTypeName() {
    return _genericTypeName;
  }

  @Override
  public boolean acceptsVariableLengthParameters() {
    return false;
  }

  @Override
  public int numParameters() {
    return 0;
  }

  public String toString() {
    return getGenericTypeName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericTypeSignatureElement that = (GenericTypeSignatureElement) o;
    return _genericTypeName != null ? _genericTypeName.equals(that._genericTypeName) : that._genericTypeName == null;
  }

  @Override
  public int hashCode() {
    return _genericTypeName != null ? _genericTypeName.hashCode() : 0;
  }
}
