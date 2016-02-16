/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.orient.db.impl.property;

import javax.inject.Inject;
import javax.inject.Named;

import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OProperty;
import com.orientechnologies.orient.core.metadata.schema.OType;

import net.sf.mmm.orient.bean.api.OrientBean;
import net.sf.mmm.orient.datatype.api.OrientLink;
import net.sf.mmm.orient.db.impl.OrientBeanMapper;
import net.sf.mmm.orient.property.api.LinkProperty;
import net.sf.mmm.util.component.api.ResourceMissingException;
import net.sf.mmm.util.component.base.AbstractLoggableComponent;
import net.sf.mmm.util.property.api.WritableProperty;
import net.sf.mmm.util.reflect.api.GenericType;

/**
 * The implementation of {@link SinglePropertyBuilder} for {@link OType#LINK}.
 *
 * @author hohwille
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
@Named
public class SinglePropertyBuilderLink extends AbstractLoggableComponent
    implements SinglePropertyBuilder<OrientLink> {

  private OrientBeanMapper beanMapper;

  /**
   * The constructor.
   */
  public SinglePropertyBuilderLink() {
    super();
  }

  /**
   * @param beanMapper is the OrientBeanMapper to {@link Inject}.
   */
  @Inject
  public void setBeanMapper(OrientBeanMapper beanMapper) {

    this.beanMapper = beanMapper;
  }

  @Override
  protected void doInitialize() {

    super.doInitialize();
    if (this.beanMapper == null) {
      throw new ResourceMissingException("beanMapper");
    }
  }

  @Override
  public OType getType() {

    return OType.LINK;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<? extends WritableProperty<OrientLink>> getPropertyType(OProperty oProperty) {

    return (Class) LinkProperty.class;
  }

  @SuppressWarnings("unchecked")
  @Override
  public GenericType<OrientLink> getValueType(OProperty oProperty) {

    Class beanClass = null;
    OClass linkedClass = oProperty.getLinkedClass();
    if (linkedClass != null) {
      OrientBean prototype = this.beanMapper.getBeanPrototype(linkedClass);
      if (prototype != null) {
        beanClass = prototype.access().getBeanClass();
      }
    }
    GenericType genericType = LinkProperty.createLinkType(beanClass);
    return genericType;
  }

}
