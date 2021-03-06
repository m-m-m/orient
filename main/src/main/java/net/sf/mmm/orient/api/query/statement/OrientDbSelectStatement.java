/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.orient.api.query.statement;

import net.sf.mmm.query.api.feature.FeatureLet;
import net.sf.mmm.query.api.statement.SelectStatement;

/**
 * Extends a regular {@link SelectStatement} for OrientDB with advanced features like
 * {@link #let(net.sf.mmm.property.api.path.PropertyPath, String) LET clause}.
 *
 * @param <E> the generic type of the queried object (typically a {@link net.sf.mmm.bean.api.Bean}).
 *
 * @author hohwille
 * @since 1.0.0
 */
public interface OrientDbSelectStatement<E> extends SelectStatement<E, OrientDbSelectStatement<E>>, FeatureLet<OrientDbSelectStatement<E>> {

}
