/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.util.query.base.example;

import javax.inject.Inject;
import javax.inject.Named;

import net.sf.mmm.bean.api.entity.EntityBean;
import net.sf.mmm.orient.api.bean.OrientBean;
import net.sf.mmm.property.api.WritableProperty;
import net.sf.mmm.property.api.lang.WritableBooleanProperty;
import net.sf.mmm.property.api.lang.WritableStringProperty;
import net.sf.mmm.property.api.link.LinkProperty;
import net.sf.mmm.property.api.math.IntegerProperty;
import net.sf.mmm.property.api.math.WritableIntegerProperty;
import net.sf.mmm.util.lang.api.Orientation;
import net.sf.mmm.util.validation.base.Mandatory;

/**
 * A dummy {@link EntityBean} for testing.
 *
 * @author hohwille
 */
public interface QueryTestBean extends OrientBean {

  WritableStringProperty FirstName();

  @Mandatory
  @Named("Alias")
  WritableStringProperty LastName();

  @Inject
  default WritableIntegerProperty Age() {

    return new IntegerProperty(null, null).withValdidator().mandatory().range(0, 200).and().build();
  }

  WritableBooleanProperty Friend();

  WritableProperty<Orientation> Orientation();

  LinkProperty<QueryTestBean> Parent();

}
