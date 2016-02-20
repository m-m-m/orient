/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.orient.data.bean.api;

import net.sf.mmm.orient.bean.api.Vertex;
import net.sf.mmm.util.property.api.lang.StringProperty;
import net.sf.mmm.util.validation.base.Mandatory;

/**
 * This is the abstract base class for a {@link Vertex} that has a {@link #Code()}.
 *
 * @author hohwille
 * @since 1.0.0
 */
public interface AbstractCode extends Vertex {

  /**
   * @return the code that acts as technical identifier of this object.
   */
  @Mandatory
  StringProperty Code();

}
