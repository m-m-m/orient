/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.orient.db.impl.property;

import com.orientechnologies.orient.core.metadata.schema.OProperty;

import net.sf.mmm.orient.bean.api.OrientBean;
import net.sf.mmm.util.bean.api.BeanAccess;
import net.sf.mmm.util.bean.api.BeanFactory;

/**
 * This is the abstract interface used to {@link #build(OProperty, OrientBean) build} missing properties.
 *
 * @see SinglePropertyBuilder
 *
 * @author hohwille
 * @since 1.0.0
 */
public abstract interface AbstractPropertyBuilder {

  /**
   * Ensures that the given {@link OProperty} is available in the the given {@link OrientBean}
   * {@link BeanFactory#createPrototype(Class, boolean) prototype}.
   *
   * @see BeanAccess#getOrCreateProperty(String, net.sf.mmm.util.reflect.api.GenericType, Class)
   *
   * @param oProperty the {@link OProperty}.
   * @param prototype the {@link OrientBean} {@link BeanFactory#createPrototype(Class, boolean) prototype}.
   */
  void build(OProperty oProperty, OrientBean prototype);

}